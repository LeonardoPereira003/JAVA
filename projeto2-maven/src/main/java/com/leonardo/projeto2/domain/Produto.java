package com.leonardo.projeto2.domain;


import java.math.BigDecimal;
import java.util.Objects;

/**
 * Representa um produto do sistema.
 */
public class Produto {

    private Long id;
    private String nome;
    private BigDecimal preco;

    public Produto(Long id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() { return id; }

    public String getNome() { return nome; }

    public BigDecimal getPreco() { return preco; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
