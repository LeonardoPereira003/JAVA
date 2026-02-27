    package br.com.pereira.domain;

    import jakarta.persistence.*;

    /**
     * Entidade que representa um Produto.
     * Será mapeada automaticamente para a tabela "produto".
     */
    @Entity
    @Table(name = "produto")
    public class Produto {

        /**
         * Identificador único do produto (Chave Primária).
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        /**
         * Nome do produto.
         */
        @Column(nullable = false, length = 100)
        private String nome;

        /**
         * Preço do produto.
         */
        @Column(nullable = false)
        private Double preco;

        /**
         * Quantidade disponível em estoque.
         */
        @Column(nullable = false)
        private Integer quantidade;

        /**
         * Construtor padrão obrigatório para o JPA.
         */
        public Produto() {
        }

        public Produto(String nome, Double preco, Integer quantidade) {
            this.nome = nome;
            this.preco = preco;
            this.quantidade = quantidade;
        }

        public Long getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Double getPreco() {
            return preco;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }

        public Integer getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(Integer quantidade) {
            this.quantidade = quantidade;
        }
    }