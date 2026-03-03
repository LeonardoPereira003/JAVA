package br.com.pereira.domain;

import jakarta.persistence.*;
import java.util.List;

/**
 * Entidade principal que representa um Carro.
 *
 * Relacionamentos:
 * - ManyToOne com Marca
 * - ManyToMany com Acessorio
 * - OneToOne com Documento
 *
 * @author Leonardo Pereira
 */
@Entity
@Table(name = "carro")
public class Carro {

    /**
     * Identificador único do carro.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Modelo do carro.
     */
    @Column(nullable = false)
    private String modelo;

    /**
     * Ano de fabricação do carro.
     */
    @Column(nullable = false)
    private Integer ano;

    /**
     * Relacionamento ManyToOne:
     * Muitos carros pertencem a uma única marca.
     */
    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;

    /**
     * Relacionamento ManyToMany:
     * Um carro pode possuir vários acessórios.
     *
     * Será criada automaticamente a tabela intermediária
     * chamada "carro_acessorio".
     */
    @ManyToMany
    @JoinTable(
            name = "carro_acessorio",
            joinColumns = @JoinColumn(name = "id_carro"),
            inverseJoinColumns = @JoinColumn(name = "id_acessorio")
    )
    private List<Acessorio> acessorios;

    /**
     * Relacionamento OneToOne:
     * Um carro possui um único documento.
     *
     * Cascade.ALL permite salvar o documento junto com o carro.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_documento", unique = true)
    private Documento documento;

    // ======================
    // Getters e Setters
    // ======================

    public Long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }
}