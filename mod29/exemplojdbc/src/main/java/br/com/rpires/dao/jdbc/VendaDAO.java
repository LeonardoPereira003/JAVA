    package br.com.rpires.dao.jdbc;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.util.ArrayList;
    import java.util.List;

    import br.com.rpires.domain.Venda;

    public class VendaDAO implements IVendaDAO {

        @Override
        public Integer cadastrar(Venda venda) throws Exception {

            String sql = "INSERT INTO vendas (id_cliente, id_produto, quantidade) VALUES (?, ?, ?)";

            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {

                stm.setLong(1, venda.getIdCliente());
                stm.setLong(2, venda.getIdProduto());
                stm.setInt(3, venda.getQuantidade());

                return stm.executeUpdate();
            }
        }

        @Override
        public Venda buscar(Long id) throws Exception {

            String sql = "SELECT * FROM vendas WHERE id_venda = ?";
            Venda venda = null;

            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {

                stm.setLong(1, id);

                try (ResultSet rs = stm.executeQuery()) {

                    if (rs.next()) {
                        venda = new Venda();
                        venda.setIdVenda(rs.getLong("id_venda"));
                        venda.setIdCliente(rs.getLong("id_cliente"));
                        venda.setIdProduto(rs.getLong("id_produto"));
                        venda.setQuantidade(rs.getInt("quantidade"));
                        venda.setDataVenda(rs.getDate("data_venda").toLocalDate());
                    }
                }
            }

            return venda;
        }

        @Override
        public List<Venda> buscarTodos() throws Exception {

            String sql = "SELECT * FROM vendas";
            List<Venda> lista = new ArrayList<>();

            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery()) {

                while (rs.next()) {

                    Venda venda = new Venda();
                    venda.setIdVenda(rs.getLong("id_venda"));
                    venda.setIdCliente(rs.getLong("id_cliente"));
                    venda.setIdProduto(rs.getLong("id_produto"));
                    venda.setQuantidade(rs.getInt("quantidade"));
                    venda.setDataVenda(rs.getDate("data_venda").toLocalDate());

                    lista.add(venda);
                }
            }

            return lista;
        }

        @Override
        public Integer excluir(Long id) throws Exception {

            String sql = "DELETE FROM vendas WHERE id_venda = ?";

            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {

                stm.setLong(1, id);
                return stm.executeUpdate();
            }
        }
    }