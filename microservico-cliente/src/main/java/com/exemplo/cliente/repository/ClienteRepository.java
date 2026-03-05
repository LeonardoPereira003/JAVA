package com.exemplo.cliente.repository;

import com.exemplo.cliente.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {

    private List<Cliente> clientes = new ArrayList<>();

    public List<Cliente> listarTodos() {
        return clientes;
    }

    public Cliente salvar(Cliente cliente) {
        clientes.add(cliente);
        return cliente;
    }

    public Cliente buscarPorId(Long id) {

        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }

        return null;
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado) {

        Cliente cliente = buscarPorId(id);

        if (cliente != null) {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setEmail(clienteAtualizado.getEmail());
        }

        return cliente;
    }

}