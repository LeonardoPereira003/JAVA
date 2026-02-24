package br.com.rpires.dao;

import java.sql.*;
import java.util.*;

import br.com.rpires.dao.factory.ProdutoQuantidadeFactory;
import br.com.rpires.dao.factory.VendaFactory;
import br.com.rpires.dao.generic.GenericDAO;
import br.com.rpires.domain.ProdutoQuantidade;
import br.com.rpires.domain.Venda;
import br.com.rpires.domain.Venda.Status;
import br.com.rpires.exceptions.DAOException;
import br.com.rpires.exceptions.MaisDeUmRegistroException;
import br.com.rpires.exceptions.TableException;

public class VendaDAO extends GenericDAO<Venda, String> implements IVendaDAO {

    @Override
    public Class<Venda> getTipoClasse() {
        return Venda.class;
    }

    @Override
    public void atualiarDados(Venda entity, Venda entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setStatus(entity.getStatus());
    }

    @Override
    public void excluir(String valor) {
        throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
    }

    // ================================
    // FINALIZAR / CANCELAR
    // ================================

    @Override
    public void finalizarVenda(Venda venda) throws DAOException {
        atualizarStatus(venda, Status.CONCLUIDA);
    }

    @Override
    public void cancelarVenda(Venda venda) throws DAOException {
        atualizarStatus(venda, Status.CANCELADA);
    }

    private void atualizarStatus(Venda venda, Status status) throws DAOException {
        String sql = "UPDATE TB_VENDA SET STATUS = ? WHERE ID = ?";

        try (Connection conn = getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, status.name());
            stm.setLong(2, venda.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("ERRO ATUALIZANDO OBJETO", e);
        }
    }

    // ================================
    // INSERT VENDA (SEM SEQUENCE)
    // ================================

    @Override
    protected String getQueryInsercao() {
        return """
            INSERT INTO TB_VENDA
            (CODIGO, ID_CLIENTE, VALOR_TOTAL, DATA_VENDA, STATUS)
            VALUES (?,?,?,?,?)
        """;
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stm, Venda entity) throws SQLException {
        stm.setString(1, entity.getCodigo());
        stm.setLong(2, entity.getCliente().getId());
        stm.setBigDecimal(3, entity.getValorTotal());
        stm.setTimestamp(4, Timestamp.from(entity.getDataVenda()));
        stm.setString(5, entity.getStatus().name());
    }

    // ================================
    // CONSULTAR
    // ================================

    @Override
    public Venda consultar(String codigo)
            throws MaisDeUmRegistroException, TableException, DAOException {

        String sql = """
            SELECT V.ID AS ID_VENDA, V.CODIGO, V.VALOR_TOTAL,
                   V.DATA_VENDA, V.STATUS,
                   C.ID AS ID_CLIENTE, C.NOME, C.CPF,
                   C.TEL, C.ENDERECO, C.NUMERO,
                   C.CIDADE, C.ESTADO
            FROM TB_VENDA V
            INNER JOIN TB_CLIENTE C ON V.ID_CLIENTE = C.ID
            WHERE V.CODIGO = ?
        """;

        try (Connection conn = getConnection();
             PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setString(1, codigo);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Venda venda = VendaFactory.convert(rs);
                buscarProdutos(conn, venda);
                return venda;
            }

        } catch (SQLException e) {
            throw new DAOException("ERRO CONSULTANDO OBJETO", e);
        }

        return null;
    }

    private void buscarProdutos(Connection conn, Venda venda) throws DAOException {

        String sql = """
            SELECT PQ.ID, PQ.QUANTIDADE, PQ.VALOR_TOTAL,
                   P.ID AS ID_PRODUTO,
                   P.CODIGO, P.NOME,
                   P.DESCRICAO, P.VALOR
            FROM TB_PRODUTO_QUANTIDADE PQ
            INNER JOIN TB_PRODUTO P ON P.ID = PQ.ID_PRODUTO
            WHERE PQ.ID_VENDA = ?
        """;

        try (PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setLong(1, venda.getId());
            ResultSet rs = stm.executeQuery();

            Set<ProdutoQuantidade> produtos = new HashSet<>();

            while (rs.next()) {
                ProdutoQuantidade pq = ProdutoQuantidadeFactory.convert(rs);
                produtos.add(pq);
            }

            venda.setProdutos(produtos);
            venda.recalcularValorTotalVenda();

        } catch (SQLException e) {
            throw new DAOException("ERRO CONSULTANDO PRODUTOS", e);
        }
    }

    // ================================
    // CADASTRAR
    // ================================

    @Override
    public Boolean cadastrar(Venda venda) throws DAOException {

        try (Connection conn = getConnection();
             PreparedStatement stmVenda =
                     conn.prepareStatement(getQueryInsercao(), Statement.RETURN_GENERATED_KEYS)) {

            setParametrosQueryInsercao(stmVenda, venda);
            int rows = stmVenda.executeUpdate();

            if (rows > 0) {

                ResultSet rs = stmVenda.getGeneratedKeys();
                if (rs.next()) {
                    venda.setId(rs.getLong(1));
                }

                for (ProdutoQuantidade prod : venda.getProdutos()) {
                    inserirProdutoQuantidade(conn, venda, prod);
                }

                return true;
            }

        } catch (SQLException e) {
            throw new DAOException("ERRO CADASTRANDO OBJETO", e);
        }

        return false;
    }

    private void inserirProdutoQuantidade(Connection conn,
                                          Venda venda,
                                          ProdutoQuantidade prod) throws SQLException {

        String sql = """
            INSERT INTO TB_PRODUTO_QUANTIDADE
            (ID_PRODUTO, ID_VENDA, QUANTIDADE, VALOR_TOTAL)
            VALUES (?,?,?,?)
        """;

        try (PreparedStatement stm = conn.prepareStatement(sql)) {

            stm.setLong(1, prod.getProduto().getId());
            stm.setLong(2, venda.getId());
            stm.setInt(3, prod.getQuantidade());
            stm.setBigDecimal(4, prod.getValorTotal());

            stm.executeUpdate();
        }
    }

    // Métodos não usados
    @Override protected String getQueryExclusao() { throw new UnsupportedOperationException(); }
    @Override protected String getQueryAtualizacao() { throw new UnsupportedOperationException(); }
    @Override protected void setParametrosQueryExclusao(PreparedStatement s, String v) {}
    @Override protected void setParametrosQueryAtualizacao(PreparedStatement s, Venda e) {}
    @Override protected void setParametrosQuerySelect(PreparedStatement s, String v) {}
}