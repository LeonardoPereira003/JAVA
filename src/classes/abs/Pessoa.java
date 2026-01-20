package classes.abs;

/**
 * Classe abstrata Pessoa.
 * 
 * Representa uma pessoa genérica do sistema.
 * Contém apenas atributos e comportamentos comuns
 * a Pessoa Física e Pessoa Jurídica.
 * 
 * @author Leonardo Pereira
 */
public abstract class Pessoa {

    /** Nome da pessoa */
    private String nome;

    /** Idade da pessoa */
    private Integer idade;

    /** Etnia da pessoa */
    private String etnia;

    /**
     * Método abstrato responsável por imprimir
     * os dados da pessoa.
     * 
     * Cada classe filha deve implementar
     * sua própria forma de impressão.
     */
    public abstract void imprimir();

    // ================= GETTERS E SETTERS =================

    /**
     * Retorna o nome da pessoa.
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da pessoa.
     * @param nome nome da pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a idade da pessoa.
     * @return idade
     */
    public Integer getIdade() {
        return idade;
    }

    /**
     * Define a idade da pessoa.
     * @param idade idade da pessoa
     */
    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    /**
     * Retorna a etnia da pessoa.
     * @return etnia
     */
    public String getEtnia() {
        return etnia;
    }

    /**
     * Define a etnia da pessoa.
     * @param etnia etnia da pessoa
     */
    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }
}
