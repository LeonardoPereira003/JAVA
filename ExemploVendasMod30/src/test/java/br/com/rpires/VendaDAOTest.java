    package br.com.rpires;

    import static org.junit.Assert.*;

    import java.math.BigDecimal;
    import java.math.RoundingMode;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.time.Instant;
    import java.util.Collection;

    import org.junit.After;
    import org.junit.Before;
    import org.junit.Test;

    import br.com.rpires.dao.ClienteDAO;
    import br.com.rpires.dao.IClienteDAO;
    import br.com.rpires.dao.IProdutoDAO;
    import br.com.rpires.dao.IVendaDAO;
    import br.com.rpires.dao.ProdutoDAO;
    import br.com.rpires.dao.VendaDAO;
    import br.com.rpires.domain.Cliente;
    import br.com.rpires.domain.Produto;
    import br.com.rpires.domain.Venda;
    import br.com.rpires.domain.Venda.Status;
    import br.com.rpires.exceptions.DAOException;

    public class VendaDAOTest {

        private IVendaDAO vendaDao;
        private IClienteDAO clienteDao;
        private IProdutoDAO produtoDao;

        private Cliente cliente;
        private Produto produto;

        public VendaDAOTest() {
            vendaDao = new VendaDAO();
            clienteDao = new ClienteDAO();
            produtoDao = new ProdutoDAO();
        }

        @Before
        public void init() throws Exception {
            this.cliente = cadastrarCliente();
            this.produto = cadastrarProduto("P1", BigDecimal.TEN);
        }

        @After
        public void end() throws Exception {
            excluirVendas();
            excluirProdutos();
            clienteDao.excluir(this.cliente.getCpf());
        }

        @Test
        public void pesquisar() throws Exception {
            Venda venda = criarVenda("V1");
            assertTrue(vendaDao.cadastrar(venda));

            Venda vendaConsultada = vendaDao.consultar("V1");
            assertNotNull(vendaConsultada);
            assertEquals("V1", vendaConsultada.getCodigo());
        }

        @Test
        public void salvar() throws Exception {
            Venda venda = criarVenda("V2");
            assertTrue(vendaDao.cadastrar(venda));

            BigDecimal esperado = BigDecimal.valueOf(20).setScale(2, RoundingMode.HALF_DOWN);
            assertEquals(esperado, venda.getValorTotal());

            Venda vendaConsultada = vendaDao.consultar("V2");
            assertNotNull(vendaConsultada.getId());
        }

        @Test
        public void cancelarVenda() throws Exception {
            Venda venda = criarVenda("V3");
            vendaDao.cadastrar(venda);

            vendaDao.cancelarVenda(venda);

            Venda vendaConsultada = vendaDao.consultar("V3");
            assertEquals(Status.CANCELADA, vendaConsultada.getStatus());
        }

        @Test
        public void finalizarVenda() throws Exception {
            Venda venda = criarVenda("V4");
            vendaDao.cadastrar(venda);

            vendaDao.finalizarVenda(venda);

            Venda vendaConsultada = vendaDao.consultar("V4");
            assertEquals(Status.CONCLUIDA, vendaConsultada.getStatus());
        }

        @Test(expected = DAOException.class)
        public void salvarVendaMesmoCodigoExistente() throws Exception {
            Venda venda = criarVenda("V5");
            vendaDao.cadastrar(venda);
            vendaDao.cadastrar(venda);
        }

        // =========================
        // MÉTODOS AUXILIARES
        // =========================

        private Cliente cadastrarCliente() throws Exception {
            Cliente cliente = new Cliente();
            cliente.setCpf(12312312312L);
            cliente.setNome("Rodrigo");
            cliente.setCidade("São Paulo");
            cliente.setEnd("End");
            cliente.setEstado("SP");
            cliente.setNumero(10);
            cliente.setTel(1199999999L);
            clienteDao.cadastrar(cliente);
            return cliente;
        }

        private Produto cadastrarProduto(String codigo, BigDecimal valor) throws Exception {
            Produto produto = new Produto();
            produto.setCodigo(codigo);
            produto.setDescricao("Produto");
            produto.setNome("Produto");
            produto.setValor(valor);
            produtoDao.cadastrar(produto);
            return produto;
        }

        private Venda criarVenda(String codigo) {
            Venda venda = new Venda();
            venda.setCodigo(codigo);
            venda.setDataVenda(Instant.now());
            venda.setCliente(this.cliente);
            venda.setStatus(Status.INICIADA);
            venda.adicionarProduto(this.produto, 2);
            return venda;
        }

    private void excluirVendas() throws DAOException {
        String sql1 = "DELETE FROM TB_PRODUTO_QUANTIDADE";
        String sql2 = "DELETE FROM TB_VENDA";

        try (Connection conn = br.com.rpires.dao.generic.jdbc.ConnectionFactory.getConnection();
            PreparedStatement stm1 = conn.prepareStatement(sql1);
            PreparedStatement stm2 = conn.prepareStatement(sql2)) {

            stm1.executeUpdate();
            stm2.executeUpdate();

        } catch (Exception e) {
            throw new DAOException("Erro limpando vendas", e);
        }
    }

        private void excluirProdutos() throws Exception {
            Collection<Produto> list = produtoDao.buscarTodos();
            for (Produto p : list) {
                produtoDao.excluir(p.getCodigo());
            }
        }
    }