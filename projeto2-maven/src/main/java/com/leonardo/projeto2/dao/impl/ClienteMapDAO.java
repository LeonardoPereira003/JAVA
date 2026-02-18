package com.leonardo.projeto2.dao.impl;

import com.leonardo.projeto2.dao.IClienteDAO;
import com.leonardo.projeto2.domain.Cliente;


import java.util.*;

public class ClienteMapDAO implements IClienteDAO {

    private Map<Long, Cliente> banco = new HashMap<>();

    @Override
    public void salvar(Cliente cliente) {
        banco.put(cliente.getId(), cliente);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return banco.get(id);
    }

    @Override
    public List<Cliente> buscarTodos() {
        return new ArrayList<>(banco.values());
    }

    @Override
    public void remover(Long id) {
        banco.remove(id);
    }
}
