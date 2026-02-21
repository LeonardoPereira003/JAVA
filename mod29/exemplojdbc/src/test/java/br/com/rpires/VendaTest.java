package br.com.rpires;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.rpires.dao.jdbc.ClienteDAO;
import br.com.rpires.dao.jdbc.IClienteDAO;
import br.com.rpires.dao.jdbc.IProdutoDAO;
import br.com.rpires.dao.jdbc.IVendaDAO;
import br.com.rpires.dao.jdbc.ProdutoDAO;
import br.com.rpires.dao.jdbc.VendaDAO;
import br.com.rpires.domain.Cliente;
import br.com.rpires.domain.Produto;
import br.com.rpires.domain.Venda;

public class VendaTest {

    private IClienteDAO clienteDAO = new ClienteDAO();
    private IProdutoDAO produtoDAO = new ProdutoDAO();
    private IVendaDAO vendaDAO = new VendaDAO();

    @Test
    public void testCRUDVenda() throws Exception {

        // Criar Cliente
        Cliente cliente = new Cliente();
        cliente.setNome("Cliente Venda");
        cliente.setEmail("vendacliente@email.com");
        cliente.setTelefone("11999999999");
        clienteDAO.cadastrar(cliente);

        Cliente clienteSalvo = clienteDAO.buscarTodos()
                .get(clienteDAO.buscarTodos().size() - 1);

        // Criar Produto
        Produto produto = new Produto();
        produto.setNome("Produto Venda");
        produto.setPreco(2000.0);
        produto.setEstoque(10);
        produtoDAO.cadastrar(produto);

        Produto produtoSalvo = produtoDAO.buscarTodos()
                .get(produtoDAO.buscarTodos().size() - 1);

        // Criar Venda
        Venda venda = new Venda();
        venda.setIdCliente(clienteSalvo.getIdCliente());
        venda.setIdProduto(produtoSalvo.getIdProduto());
        venda.setQuantidade(2);

        Integer insert = vendaDAO.cadastrar(venda);
        assertEquals(1, insert);

        // Verificar se existe
        assertFalse(vendaDAO.buscarTodos().isEmpty());

        Venda ultima = vendaDAO.buscarTodos()
                .get(vendaDAO.buscarTodos().size() - 1);

        assertNotNull(ultima);

        // Delete venda
        Integer delete = vendaDAO.excluir(ultima.getIdVenda());
        assertEquals(1, delete);

        // Limpeza final
        clienteDAO.excluir(clienteSalvo.getIdCliente());
        produtoDAO.excluir(produtoSalvo.getIdProduto());
    }
}