    package com.exemplo.produto.repository;

    import com.exemplo.produto.model.Produto;
    import org.springframework.stereotype.Repository;

    import java.util.ArrayList;
    import java.util.List;

    @Repository
    public class ProdutoRepository {

        private List<Produto> produtos = new ArrayList<>();

        public List<Produto> listarTodos() {
            return produtos;
        }

        public Produto salvar(Produto produto) {
            produtos.add(produto);
            return produto;
        }

        public Produto buscarPorId(Long id) {

            for (Produto p : produtos) {
                if (p.getId().equals(id)) {
                    return p;
                }
            }

            return null;
        }

        public Produto atualizar(Long id, Produto produtoAtualizado) {

            Produto produto = buscarPorId(id);

            if (produto != null) {
                produto.setNome(produtoAtualizado.getNome());
                produto.setPreco(produtoAtualizado.getPreco());
            }

            return produto;
        }

    }