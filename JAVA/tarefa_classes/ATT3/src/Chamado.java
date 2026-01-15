/**
 * Classe Chamado
 * Representa um chamado de atendimento feito por um cliente.
 * 
 * Contém informações como:
 * - Nome do solicitante
 * - Local do chamado
 * - Motivo
 * - Quantidade de chamados
 * 
 * @author Leonardo Pereira
 */
public class Chamado {

/** Nome do cliente que abriu o chamado */
    private String nomeSolicitante;

/** Local onde o chamado foi solicitado */
    private String localChamado;

/** Motivo do chamado */
    private String motivoChamado;


/** Quantidade de chamados registrados */
    private int quantidadeChamado;

/**
 * Método principal para executar o programa
 * @param args argumentos da linha de comando
 */
    public static void main ( String argrs[] ){
// Criando um objeto real da classe Chamado
        Chamado chamado1 = new Chamado();

// Usando os métodos setters
    chamado1.setNomeSolicitante("João Silva");
    chamado1.setLocalChamado("Setor Financeiro");
    chamado1.setMotivoChamado("Computador não liga");
    chamado1.setQuantidadeChamado(5);
;
// Exibindo os dados no console
    System.out.println("Nome: " + chamado1.getNomeSolicitante());
    System.out.println("Local: " + chamado1.getLocalChamado());
    System.out.println("Motivo: " + chamado1.getMotivoChamado());
    System.out.println("Quantidade: " + chamado1.getQuantidadeChamado());
    }

/**
 * Retorna o nome do solicitante
 * @return nome do solicitante
 */
    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

/**
 * Define o nome do solicitante
 * @param nomeSolicitante nome do cliente
 */
    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

/**
 * Retorna o local do chamado
 * @return local do chamado
 */
    public String getLocalChamado() {
        return localChamado;
    }

/**
 * Define o local do chamado
 * @param localChamado local do atendimento
 */
    public void setLocalChamado(String localChamado) {
        this.localChamado = localChamado;
    }

    /**
     * Retorna o motivo do chamado
     * @return motivo do chamado
     */
    public String getMotivoChamado() {
        return motivoChamado;
    }

/**
 * Define o motivo do chamado
 * @param motivoChamado descrição do problema
 */
    public void setMotivoChamado(String motivoChamado) {
        this.motivoChamado = motivoChamado;
    }

/**
 * Retorna a quantidade de chamados
 * @return quantidade de chamados
 */
    public int getQuantidadeChamado() {
        return quantidadeChamado;
    }

/**
 * Define a quantidade de chamados
 * @param quantidadeChamado número de chamados
 */
    public void setQuantidadeChamado(int quantidadeChamado) {
        this.quantidadeChamado = quantidadeChamado;
    }
}