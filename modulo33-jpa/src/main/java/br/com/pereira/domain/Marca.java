package br.com.pereira.domain;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidade que representa uma Marca de carro.
 *
 * Relacionamento:
 * - OneToMany com Carro (uma marca pode ter vários carros).
 *
 * @author Leonardo Pereira
 */
@Entity
@Table(name = "marca")
public class Marca {

    /**
     * Identificador único da marca.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome da marca (ex: Toyota, BMW, Honda).
     */
    @Column(nullable = false)
    private String nome;

    /**
     * Relacionamento OneToMany:
     * Uma marca pode possuir vários carros.
     *
     * mappedBy indica que o dono da relação está na entidade Carro.
     */
    @OneToMany(mappedBy = "marca")
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