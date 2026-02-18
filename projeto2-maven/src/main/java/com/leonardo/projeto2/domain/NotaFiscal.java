package com.leonardo.projeto2.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {

    private Long id;
    private Cliente cliente;
    private List<Produto> produtos = new ArrayList<>();

    public NotaFiscal(Long id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public BigDecimal calcularTotal() {
        return produtos.stream()
                .map(Produto::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
