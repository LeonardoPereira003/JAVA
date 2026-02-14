package src.br.com.projetoannotation.domain;

import src.br.com.projetoannotation.annotation.*;

@TABELA("clientes")
public class Cliente {

    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
