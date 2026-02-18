package com.leonardo.projeto2.service;

import com.leonardo.projeto2.dao.IClienteDAO;
import com.leonardo.projeto2.domain.Cliente;

/**
 * Service específico para Cliente.
 */
public class ClienteService
        extends AbstractService<Cliente, Long> {

    public ClienteService(IClienteDAO dao) {
        super(dao);
    }

    // Aqui você pode colocar regras de negócio específicas de Cliente
}
