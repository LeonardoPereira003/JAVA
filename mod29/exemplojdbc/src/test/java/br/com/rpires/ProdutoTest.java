package br.com.rpires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.rpires.dao.jdbc.IProdutoDAO;
import br.com.rpires.dao.jdbc.ProdutoDAO;
import br.com.rpires.domain.Produto;

public class ProdutoTest {

    private IProdutoDAO produtoDAO = new ProdutoDAO();

    @Test
    public void testCRUDProduto() throws Exception {

        // CREATE
        Produto produto = new Produto();
        produto.setNome("Notebook Teste");
        produto.setPreco(3000.0);
        produto.setEstoque(5);

        Integer insert = produtoDAO.cadastrar(produto);
        assertEquals(1, insert);

        // READ ALL
        assertFalse(produtoDAO.buscarTodos().isEmpty());

        Produto ultimo = produtoDAO.buscarTodos()
                .get(produtoDAO.buscarTodos().size() - 1);

        // UPDATE
        ultimo.setNome("Notebook Atualizado");
        Integer update = produtoDAO.atualizar(ultimo);
        assertEquals(1, update);

        // DELETE
        Integer delete = produtoDAO.excluir(ultimo.getIdProduto());
        assertEquals(1, delete);
    }
}