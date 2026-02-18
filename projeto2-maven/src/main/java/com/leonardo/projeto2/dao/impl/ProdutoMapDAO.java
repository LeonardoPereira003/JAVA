package com.leonardo.projeto2.dao.impl;

import com.leonardo.projeto2.dao.IProdutoDAO;
import com.leonardo.projeto2.domain.Produto;

/**
 * DAO em memória para Produto.
 */
public class ProdutoMapDAO extends AbstractMapDAO<Produto, Long>
        implements IProdutoDAO {

    @Override
    protected Long getId(Produto entity) {
        return entity.getId();
    }
}
