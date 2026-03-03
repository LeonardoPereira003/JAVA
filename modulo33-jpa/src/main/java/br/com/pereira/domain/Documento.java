package br.com.pereira.domain;

import jakarta.persistence.*;

/**
 * Entidade que representa o Documento de um carro.
 *
 * Relacionamento:
 * - OneToOne com Carro (um documento pertence a um único carro).
 *
 * @author Leonardo Pereira
 */
@Entity
@Table(name = "documento")
public class Documento {

    /**
     * Identificador único do documento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Número do chassi do carro.
     */
    @Column(nullable = false, unique = true)
    private String numeroChassi;

    /**
     * Relacionamento OneToOne:
     * O documento está associado a um único carro.
     *
     * mappedBy indica que o dono da relação está na entidade Carro.
     */
    @OneToOne(mappedBy = "documento")
    private Carro carro;

    // ======================
    // Getters e Setters
    // ======================

    public Long getId() {
        return id;
    }

    public String getNumeroChassi() {
        return numeroChassi;
    }

    public void setNumeroChassi(String numeroChassi) {
        this.numeroChassi = numeroChassi;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}