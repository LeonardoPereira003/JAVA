package br.com.rpires.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.rpires.dao.generic.GenericDAO;
import br.com.rpires.domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualiarDados(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setCodigo(entity.getCodigo());
        entityCadastrado.setDescricao(entity.getDescricao());
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setValor(entity.getValor());
        entityCadastrado.setQuantidadeEstoque(entity.getQuantidadeEstoque()); // NOVO CAMPO
    }

    @Override
    protected String getQueryInsercao() {
        return """
            INSERT INTO TB_PRODUTO
            (CODIGO, NOME, DESCRICAO, VALOR, QUANTIDADE_ESTOQUE)
            VALUES (?,?,?,?,?)
        """;
    }

    @Override
    protected void setParametrosQueryInsercao(PreparedStatement stm, Produto entity) throws SQLException {
        stm.setString(1, entity.getCodigo());
        stm.setString(2, entity.getNome());
        stm.setString(3, entity.getDescricao());
        stm.setBigDecimal(4, entity.getValor());
        stm.setInt(5, entity.getQuantidadeEstoque()); // NOVO CAMPO
    }

    @Override
    protected String getQueryExclusao() {
        return "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
    }

    @Override
    protected void setParametrosQueryExclusao(PreparedStatement stm, String valor) throws SQLException {
        stm.setString(1, valor);
    }

    @Override
    protected String getQueryAtualizacao() {
        return """
            UPDATE TB_PRODUTO SET
            NOME = ?, DESCRICAO = ?, VALOR = ?, QUANTIDADE_ESTOQUE = ?
            WHERE CODIGO = ?
        """;
    }

    @Override
    protected void setParametrosQueryAtualizacao(PreparedStatement stm, Produto entity) throws SQLException {
        stm.setString(1, entity.getNome());
        stm.setString(2, entity.getDescricao());
        stm.setBigDecimal(3, entity.getValor());
        stm.setInt(4, entity.getQuantidadeEstoque()); // NOVO CAMPO
        stm.setString(5, entity.getCodigo());
    }

    @Override
    protected void setParametrosQuerySelect(PreparedStatement stm, String valor) throws SQLException {
        stm.setString(1, valor);
    }
}