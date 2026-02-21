package br.com.rpires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.rpires.dao.jdbc.ClienteDAO;
import br.com.rpires.dao.jdbc.IClienteDAO;
import br.com.rpires.domain.Cliente;

public class ClienteTest {

    private IClienteDAO clienteDAO = new ClienteDAO();

    @Test
    public void testCRUDCliente() throws Exception {

        // CREATE
        Cliente cliente = new Cliente();
        cliente.setNome("Teste Cliente");
        cliente.setEmail("teste@email.com");
        cliente.setTelefone("11999999999");

        Integer insert = clienteDAO.cadastrar(cliente);
        assertEquals(1, insert);

        // READ ALL
        assertFalse(clienteDAO.buscarTodos().isEmpty());

        // Vamos pegar o último cliente inserido
        Cliente ultimo = clienteDAO.buscarTodos()
                .get(clienteDAO.buscarTodos().size() - 1);

        // UPDATE
        ultimo.setNome("Cliente Atualizado");
        Integer update = clienteDAO.atualizar(ultimo);
        assertEquals(1, update);

        // DELETE
        Integer delete = clienteDAO.excluir(ultimo.getIdCliente());
        assertEquals(1, delete);
    }
}