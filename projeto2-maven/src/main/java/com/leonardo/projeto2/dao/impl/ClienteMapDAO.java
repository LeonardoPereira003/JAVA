package com.leonardo.projeto2.dao.impl;

import com.leonardo.projeto2.dao.IClienteDAO;
import com.leonardo.projeto2.domain.Cliente;

/**
 * DAO em memória para Cliente.
 */
public class ClienteMapDAO extends AbstractMapDAO<Cliente, Long>
        implements IClienteDAO {

    @Override
    protected Long getId(Cliente entity) {
        return entity.getId();
    }
}
