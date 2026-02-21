    package br.com.rpires.dao.jdbc;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.util.ArrayList;
    import java.util.List;

    import br.com.rpires.domain.Produto;

    public class ProdutoDAO implements IProdutoDAO {

        @Override
        public Integer cadastrar(Produto produto) throws Exception {
            String sql = "INSERT INTO produtos (nome, preco, estoque) VALUES (?, ?, ?)";

            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {

                stm.setString(1, produto.getNome());
                stm.setDouble(2, produto.getPreco());
                stm.setInt(3, produto.getEstoque());

                return stm.executeUpdate();
            }
        }

        @Override
        public Integer atualizar(Produto produto) throws Exception {
            String sql = "UPDATE produtos SET nome = ?, preco = ?, estoque = ? WHERE id_produto = ?";

            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {

                stm.setString(1, produto.getNome());
                stm.setDouble(2, produto.getPreco());
                stm.setInt(3, produto.getEstoque());
                stm.setLong(4, produto.getIdProduto());

                return stm.executeUpdate();
            }
        }

        @Override
        public Produto buscar(Long id) throws Exception {
            String sql = "SELECT * FROM produtos WHERE id_produto = ?";
            Produto produto = null;

            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {

                stm.setLong(1, id);

                try (ResultSet rs = stm.executeQuery()) {
                    if (rs.next()) {
                        produto = new Produto();
                        produto.setIdProduto(rs.getLong("id_produto"));
                        produto.setNome(rs.getString("nome"));
                        produto.setPreco(rs.getDouble("preco"));
                        produto.setEstoque(rs.getInt("estoque"));
                    }
                }
            }

            return produto;
        }

        @Override
        public List<Produto> buscarTodos() throws Exception {
            String sql = "SELECT * FROM produtos";
            List<Produto> lista = new ArrayList<>();

            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery()) {

                while (rs.next()) {
                    Produto produto = new Produto();
                    produto.setIdProduto(rs.getLong("id_produto"));
                    produto.setNome(rs.getString("nome"));
                    produto.setPreco(rs.getDouble("preco"));
                    produto.setEstoque(rs.getInt("estoque"));

                    lista.add(produto);
                }
            }

            return lista;
        }

        @Override
        public Integer excluir(Long id) throws Exception {
            String sql = "DELETE FROM produtos WHERE id_produto = ?";

            try (Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql)) {

                stm.setLong(1, id);
                return stm.executeUpdate();
            }
        }
    }