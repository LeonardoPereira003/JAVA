package src.br.com.projetoannotation.domain;

import src.br.com.projetoannotation.annotation.*;

@TABELA("produtos")
public class Produto {

    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }
}
