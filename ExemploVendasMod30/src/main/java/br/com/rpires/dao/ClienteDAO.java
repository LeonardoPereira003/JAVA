package br.com.rpires.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.rpires.dao.generic.GenericDAO;
import br.com.rpires.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
        entityCadastrado.setCidade(entity.getCidade());
        entityCadastrado.setCpf(entity.getCpf());
        entityCadastrado.setEnd(entity.getEnd());
        entityCadastrado.setEstado(entity.getEstado());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setNumero(entity.getNumero());
        entityCadastrado.setTel(entity.getTel());
    }

    @Override
    protected String getQueryInsercao() {
        return """
            INSERT INTO TB_CLIENTE
            (NOME, CPF, TELEFONE, ENDERECO, NUMERO, CIDADE, ESTADO)
            VALUES (?,?,?,?,?,?,?)
        """;
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stm, Cliente entity) throws SQLException {
        stm.setString(1, entity.getNome());
        stm.setLong(2, entity.getCpf());
        stm.setLong(3, entity.getTel());
        stm.setString(4, entity.getEnd());
        stm.setInt(5, entity.getNumero());
        stm.setString(6, entity.getCidade());
        stm.setString(7, entity.getEstado());
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_CLIENTE WHERE CPF = ?";
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stm, Long valor) throws SQLException {
        stm.setLong(1, valor);
    }

    @Override
    protected String getQueryAtualizacao() {
        return """
            UPDATE TB_CLIENTE SET
            NOME = ?, TELEFONE = ?, ENDERECO = ?, NUMERO = ?, CIDADE = ?, ESTADO = ?
            WHERE CPF = ?
        """;
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stm, Cliente entity) throws SQLException {
        stm.setString(1, entity.getNome());
        stm.setLong(2, entity.getTel());
        stm.setString(3, entity.getEnd());
        stm.setInt(4, entity.getNumero());
        stm.setString(5, entity.getCidade());
        stm.setString(6, entity.getEstado());
        stm.setLong(7, entity.getCpf());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stm, Long valor) throws SQLException {
        stm.setLong(1, valor);
    }
}