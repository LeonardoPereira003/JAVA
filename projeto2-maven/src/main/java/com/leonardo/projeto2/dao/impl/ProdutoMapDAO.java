package com.leonardo.projeto2.dao.impl;

import com.leonardo.projeto2.dao.IProdutoDAO;
import com.leonardo.projeto2.domain.Produto;

import java.util.*;

/**
 * Implementação em memória do DAO de Produto.
 * Utiliza um Map para simular persistência.
 */
public class ProdutoMapDAO implements IProdutoDAO {

    /**
     * Estrutura que simula o banco de dados.
     * A chave é o ID do produto.
     */
    private final Map<Long, Produto> banco = new HashMap<>();

    /**
     * Salva um produto na "base de dados".
     */
    @Override
    public void salvar(Produto produto) {
        banco.put(produto.getId(), produto);
    }

    /**
     * Busca um produto pelo ID.
     */
    @Override
    public Produto buscarPorId(Long id) {
        return banco.get(id);
    }

    /**
     * Retorna todos os produtos cadastrados.
     */
    @Override
    public List<Produto> buscarTodos() {
        return new ArrayList<>(banco.values());
    }

    /**
     * Remove um produto pelo ID.
     */
    @Override
    public void remover(Long id) {
        banco.remove(id);
    }
}
