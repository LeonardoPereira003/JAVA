package com.leonardo.projeto2.service;

import com.leonardo.projeto2.dao.IProdutoDAO;
import com.leonardo.projeto2.domain.Produto;

/**
 * Service específico para Produto.
 */
public class ProdutoService
        extends AbstractService<Produto, Long> {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }
}
