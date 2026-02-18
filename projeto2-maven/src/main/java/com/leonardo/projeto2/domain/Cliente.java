package com.leonardo.projeto2.domain;


import java.util.Objects;

/**
 * Representa um cliente do sistema.
 */
public class Cliente {

    private Long id;
    private String nome;
    private String cpf;
    private String email;

    /**
     * Construtor padrão da entidade Cliente.
     */
    public Cliente(Long id, String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Dois clientes são considerados iguais se tiverem o mesmo CPF.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
