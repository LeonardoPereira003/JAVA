package com.leonardo.projeto2.service;

import com.leonardo.projeto2.dao.IProdutoDAO;
import com.leonardo.projeto2.domain.Produto;

import java.util.List;

/**
 * Camada de serviço responsável pelas regras de negócio do Produto.
 */
public class ProdutoService {

    private final IProdutoDAO produtoDAO;

    public ProdutoService(IProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public void cadastrarProduto(Produto produto) {
        produtoDAO.salvar(produto);
    }

    public Produto buscarPorId(Long id) {
        return produtoDAO.buscarPorId(id);
    }

    public List<Produto> listarTodos() {
        return produtoDAO.buscarTodos();
    }

    public void remover(Long id) {
        produtoDAO.remover(id);
    }
}
