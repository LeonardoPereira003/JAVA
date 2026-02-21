package br.com.rpires.dao.jdbc;


import java.util.List;
import br.com.rpires.domain.Cliente;

public interface IClienteDAO {

    Integer cadastrar(Cliente cliente) throws Exception;

    Integer atualizar(Cliente cliente) throws Exception;

    Cliente buscar(Long id) throws Exception;

    List<Cliente> buscarTodos() throws Exception;

    Integer excluir(Long id) throws Exception;
}