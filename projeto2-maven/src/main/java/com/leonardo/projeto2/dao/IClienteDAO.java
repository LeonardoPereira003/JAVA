package com.leonardo.projeto2.dao;


import com.leonardo.projeto2.domain.Cliente;


import java.util.List;

/**
 * Interface responsável pelas operações de persistência da entidade Cliente.
 */
public interface IClienteDAO {

    /**
     * Salva um cliente no sistema.
     */
    void salvar(Cliente cliente);

    /**
     * Busca um cliente pelo ID.
     */
    Cliente buscarPorId(Long id);

    /**
     * Retorna todos os clientes cadastrados.
     */
    List<Cliente> buscarTodos();

    /**
     * Remove um cliente pelo ID.
     */
    void remover(Long id);
}
