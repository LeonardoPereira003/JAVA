		package br.com.rpires.dao.generic;

		import java.io.Serializable;
		import java.lang.reflect.*;
		import java.math.BigDecimal;
		import java.sql.*;
		import java.util.*;

		import anotacao.ColunaTabela;
		import anotacao.Tabela;
		import anotacao.TipoChave;
		import br.com.rpires.dao.Persistente;
		import br.com.rpires.dao.generic.jdbc.ConnectionFactory;
		import br.com.rpires.exceptions.*;

		public abstract class GenericDAO<T extends Persistente, E extends Serializable>
				implements IGenericDAO<T, E> {

			public abstract Class<T> getTipoClasse();
			public abstract void atualiarDados(T entity, T entityCadastrado);
			protected abstract String getQueryInsercao();
			protected abstract String getQueryExclusao();
			protected abstract String getQueryAtualizacao();
			protected abstract void setParametrosQueryInsercao(PreparedStatement stmInsert, T entity) throws SQLException;
			protected abstract void setParametrosQueryExclusao(PreparedStatement stmDelete, E valor) throws SQLException;
			protected abstract void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, T entity) throws SQLException;
			protected abstract void setParametrosQuerySelect(PreparedStatement stmUpdate, E valor) throws SQLException;

			@SuppressWarnings("unchecked")
			public E getChave(T entity) throws TipoChaveNaoEncontradaException {
				for (Field field : entity.getClass().getDeclaredFields()) {
					if (field.isAnnotationPresent(TipoChave.class)) {
						TipoChave tipoChave = field.getAnnotation(TipoChave.class);
						try {
							Method method = entity.getClass().getMethod(tipoChave.value());
							return (E) method.invoke(entity);
						} catch (Exception e) {
							throw new TipoChaveNaoEncontradaException(
									"Chave principal não encontrada para " + entity.getClass(), e);
						}
					}
				}
				throw new TipoChaveNaoEncontradaException(
						"Chave principal não encontrada para " + entity.getClass());
			}

			@Override
			public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
				try (Connection connection = getConnection();
					PreparedStatement stm = connection.prepareStatement(
							getQueryInsercao(), Statement.RETURN_GENERATED_KEYS)) {

					setParametrosQueryInsercao(stm, entity);
					int rows = stm.executeUpdate();

					if (rows > 0) {
						try (ResultSet rs = stm.getGeneratedKeys()) {
							if (rs.next()) {
								entity.setId(rs.getLong(1));
							}
						}
						return true;
					}

				} catch (SQLException e) {
					throw new DAOException("ERRO CADASTRANDO OBJETO", e);
				}
				return false;
			}

			@Override
			public void excluir(E valor) throws DAOException {
				try (Connection connection = getConnection();
					PreparedStatement stm = connection.prepareStatement(getQueryExclusao())) {

					setParametrosQueryExclusao(stm, valor);
					stm.executeUpdate();

				} catch (SQLException e) {
					throw new DAOException("ERRO EXCLUINDO OBJETO", e);
				}
			}

			@Override
			public void alterar(T entity) throws DAOException {
				try (Connection connection = getConnection();
					PreparedStatement stm = connection.prepareStatement(getQueryAtualizacao())) {

					setParametrosQueryAtualizacao(stm, entity);
					stm.executeUpdate();

				} catch (SQLException e) {
					throw new DAOException("ERRO ALTERANDO OBJETO", e);
				}
			}

			@Override
			public T consultar(E valor)
					throws MaisDeUmRegistroException, TableException, DAOException {

				try {
					validarMaisDeUmRegistro(valor);

					String sql = "SELECT * FROM " + getTableName()
							+ " WHERE " + getNomeCampoChave(getTipoClasse()) + " = ?";

					try (Connection connection = getConnection();
						PreparedStatement stm = connection.prepareStatement(sql)) {

						setParametrosQuerySelect(stm, valor);

						try (ResultSet rs = stm.executeQuery()) {
							if (rs.next()) {
								T entity = getTipoClasse().getDeclaredConstructor().newInstance();

								for (Field field : entity.getClass().getDeclaredFields()) {
									if (field.isAnnotationPresent(ColunaTabela.class)) {

										ColunaTabela coluna = field.getAnnotation(ColunaTabela.class);
										Method method = entity.getClass()
												.getMethod(coluna.setJavaName(), field.getType());

										setValueByType(entity, method,
												field.getType(), rs, coluna.dbName());
									}
								}
								return entity;
							}
						}
					}

				} catch (Exception e) {
					throw new DAOException("ERRO CONSULTANDO OBJETO", e);
				}
				return null;
			}

			public String getNomeCampoChave(Class<?> clazz)
					throws TipoChaveNaoEncontradaException {

				for (Field field : clazz.getDeclaredFields()) {
					if (field.isAnnotationPresent(TipoChave.class)
							&& field.isAnnotationPresent(ColunaTabela.class)) {

						return field.getAnnotation(ColunaTabela.class).dbName();
					}
				}
				throw new TipoChaveNaoEncontradaException("Chave não encontrada.");
			}

			private void setValueByType(T entity, Method method,
										Class<?> type, ResultSet rs, String fieldName)
					throws Exception {

				Object value;

				if (type.equals(Integer.class) || type.equals(Integer.TYPE)) {
					value = rs.getInt(fieldName);
				} else if (type.equals(Long.class) || type.equals(Long.TYPE)) {
					value = rs.getLong(fieldName);
				} else if (type.equals(Double.class) || type.equals(Double.TYPE)) {
					value = rs.getDouble(fieldName);
				} else if (type.equals(Short.class) || type.equals(Short.TYPE)) {
					value = rs.getShort(fieldName);
				} else if (type.equals(BigDecimal.class)) {
					value = rs.getBigDecimal(fieldName);
				} else if (type.equals(String.class)) {
					value = rs.getString(fieldName);
				} else {
					throw new TipoElementoNaoConhecidoException("Tipo não suportado: " + type);
				}

				method.invoke(entity, value);
			}

	private void validarMaisDeUmRegistro(E valor)
			throws MaisDeUmRegistroException, TableException, DAOException {

		String sql;
		try {
			sql = "SELECT count(*) FROM " + getTableName()
					+ " WHERE " + getNomeCampoChave(getTipoClasse()) + " = ?";
		} catch (TipoChaveNaoEncontradaException e) {
			throw new DAOException("ERRO OBTENDO NOME DO CAMPO CHAVE", e);
		}

		try (Connection connection = getConnection();
			PreparedStatement stm = connection.prepareStatement(sql)) {

			setParametrosQuerySelect(stm, valor);

			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next() && rs.getLong(1) > 1) {
					throw new MaisDeUmRegistroException(
							"Encontrado mais de um registro.");
				}
			}

		} catch (SQLException e) {
			throw new DAOException("ERRO VALIDANDO REGISTRO", e);
		}
	}

			private String getTableName() throws TableException {
				if (getTipoClasse().isAnnotationPresent(Tabela.class)) {
					return getTipoClasse().getAnnotation(Tabela.class).value();
				}
				throw new TableException("Tabela não encontrada.");
			}

			@Override
			public Collection<T> buscarTodos() throws DAOException {

				List<T> list = new ArrayList<>();

				try (Connection connection = getConnection();
					PreparedStatement stm = connection.prepareStatement(
							"SELECT * FROM " + getTableName());
					ResultSet rs = stm.executeQuery()) {

					while (rs.next()) {

						T entity = getTipoClasse().getDeclaredConstructor().newInstance();

						for (Field field : entity.getClass().getDeclaredFields()) {
							if (field.isAnnotationPresent(ColunaTabela.class)) {

								ColunaTabela coluna = field.getAnnotation(ColunaTabela.class);
								Method method = entity.getClass()
										.getMethod(coluna.setJavaName(), field.getType());

								setValueByType(entity, method,
										field.getType(), rs, coluna.dbName());
							}
						}
						list.add(entity);
					}

				} catch (Exception e) {
					throw new DAOException("ERRO LISTANDO OBJETOS", e);
				}

				return list;
			}

			protected Connection getConnection() throws DAOException {
				try {
					return ConnectionFactory.getConnection();
				} catch (SQLException e) {
					throw new DAOException("ERRO CONEXÃO BANCO", e);
				}
			}
		}