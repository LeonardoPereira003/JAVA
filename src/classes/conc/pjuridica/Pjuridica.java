package classes.conc.pjuridica;

import classes.abs.Pessoa;

/**
 * Classe Pessoa Jurídica.
 * 
 * Representa uma empresa ou entidade jurídica,
 * contendo dados específicos de PJ.
 */
public class Pjuridica extends Pessoa {

    /** CNPJ da empresa */
    private Long cnpj;

    /** Custos operacionais da empresa */
    private Double custosOperacionais;

    /** Controle de rotina da empresa */
    private String controleRotina;

    /**
     * Implementação do método imprimir().
     * 
     * Exibe no console os dados específicos
     * da pessoa jurídica.
     */
    @Override
    public void imprimir() {
        System.out.println("------Pessoa Jurídica------");
        System.out.println("Nome: " + getNome());
        System.out.println("Etnia: " + getEtnia());
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Custos Operacionais: " + custosOperacionais);
        System.out.println("Rotina: " + controleRotina);
    }

    // ================= GETTERS E SETTERS =================

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public Double getCustosOperacionais() {
        return custosOperacionais;
    }

    public void setCustosOperacionais(Double custosOperacionais) {
        this.custosOperacionais = custosOperacionais;
    }

    public String getControleRotina() {
        return controleRotina;
    }

    public void setControleRotina(String controleRotina) {
        this.controleRotina = controleRotina;
    }
}
