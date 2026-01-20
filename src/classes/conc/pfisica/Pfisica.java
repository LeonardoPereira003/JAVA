package classes.conc.pfisica;

import classes.abs.Pessoa;

/**
 * Classe Pessoa Física.
 * 
 * Representa uma pessoa física e herda
 * os atributos comuns da classe Pessoa.
 */
public class Pfisica extends Pessoa {

    /** CPF da pessoa física */
    private Long cpf;

    /** Valor do vale transporte */
    private Double valeTransporte;

    /** Valor do vale alimentação */
    private Double valeAlimentacao;

    /** Total de horas trabalhadas no mês */
    private Double horasTrabalhadas;

    /**
     * Implementação do método imprimir().
     * 
     * Exibe no console os dados específicos
     * da pessoa física.
     */
    @Override
    public void imprimir() {
        System.out.println("------Pessoa Física------");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Etnia: " + getEtnia());
        System.out.println("CPF: " + cpf);
        System.out.println("Vale Transporte: " + valeTransporte);
        System.out.println("Vale Alimentação: " + valeAlimentacao);
        System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
    }

    // ================= GETTERS E SETTERS =================

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Double getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(Double valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public Double getValeAlimentacao() {
        return valeAlimentacao;
    }

    public void setValeAlimentacao(Double valeAlimentacao) {
        this.valeAlimentacao = valeAlimentacao;
    }

    public Double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
}
