    package br.com.rpires.dao.jdbc;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.util.ArrayList;
    import java.util.List;

    import br.com.rpires.domain.Cliente;

    /**
     * Implementação do DAO para a entidade Cliente.
     */
    public class ClienteDAO implements IClienteDAO {

        @Override
        public Integer cadastrar(Cliente cliente) throws Exception {
            String sql = "INSERT INTO clientes (nome, email, telefone) VALUES (?, ?, ?)";

            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {

                stm.setString(1, cliente.getNome());
                stm.setString(2, cliente.getEmail());
                stm.setString(3, cliente.getTelefone());

                return stm.executeUpdate();
            }
        }

        @Override
        public Integer atualizar(Cliente cliente) throws Exception {
            String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ? WHERE id_cliente = ?";

            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {

                stm.setString(1, cliente.getNome());
                stm.setString(2, cliente.getEmail());
                stm.setString(3, cliente.getTelefone());
                stm.setLong(4, cliente.getIdCliente());

                return stm.executeUpdate();
            }
        }

        @Override
        public Cliente buscar(Long id) throws Exception {
            String sql = "SELECT * FROM clientes WHERE id_cliente = ?";
            Cliente cliente = null;

            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {

                stm.setLong(1, id);

                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        cliente = new Cliente();
                        cliente.setIdCliente(rs.getLong("id_cliente"));
                        cliente.setNome(rs.getString("nome"));
                        cliente.setEmail(rs.getString("email"));
                        cliente.setTelefone(rs.getString("telefone"));
                    }
                }
            }
            return cliente;
        }

        @Override
        public List<Cliente> buscarTodos() throws Exception {
            String sql = "SELECT * FROM clientes";
            List<Cliente> lista = new ArrayList<>();

            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery()) {

                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getLong("id_cliente"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setTelefone(rs.getString("telefone"));

                    lista.add(cliente);
                }
            }

            return lista;
        }

        @Override
        public Integer excluir(Long id) throws Exception {
            String sql = "DELETE FROM clientes WHERE id_cliente = ?";

            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {

                stm.setLong(1, id);
                return stm.executeUpdate();
            }
        }
    }