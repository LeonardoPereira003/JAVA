package com.leonardo.projeto2.service;

import com.leonardo.projeto2.dao.IClienteDAO;
import com.leonardo.projeto2.domain.Cliente;

import java.util.List;

/**
 * Camada de serviço responsável pelas regras de negócio do Cliente.
 */
public class ClienteService {

    private final IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    /**
     * Cadastra um novo cliente.
     */
    public void cadastrarCliente(Cliente cliente) {
        clienteDAO.salvar(cliente);
    }

    /**
     * Busca cliente por ID.
     */
    public Cliente buscarPorId(Long id) {
        return clienteDAO.buscarPorId(id);
    }

    /**
     * Lista todos os clientes.
     */
    public List<Cliente> listarTodos() {
        return clienteDAO.buscarTodos();
    }

    /**
     * Remove cliente.
     */
    public void remover(Long id) {
        clienteDAO.remover(id);
    }
}
