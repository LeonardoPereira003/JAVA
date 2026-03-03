package br.com.pereira.domain;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidade que representa um Acessório de um carro.
 *
 * Relacionamento:
 * - ManyToMany com Carro (um acessório pode estar em vários carros).
 *
 * @author Leonardo Pereira
 */
@Entity
@Table(name = "acessorio")
public class Acessorio {

    /**
     * Identificador único do acessório.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do acessório (ex: Som, Multimídia, Banco de couro).
     */
    @Column(nullable = false)
    private String nome;

    /**
     * Relacionamento ManyToMany:
     * Um acessório pode estar presente em vários carros.
     *
     * mappedBy indica que o dono da relação está na entidade Carro.
     */
    @ManyToMany(mappedBy = "acessorios")
    private List<Carro> carros;

    // ======================
    // Getters e Setters
    // ======================

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}