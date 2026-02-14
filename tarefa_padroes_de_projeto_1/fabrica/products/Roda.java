package tarefa_padroes_de_projeto_1.fabrica.products;

/**
 * Interface que representa uma roda.
 * 
 * Cada modelo de carro pode possuir rodas diferentes.
 * 
 * @author Leonardo
 */
public interface Roda {

    /**
     * Retorna o modelo da roda.
     * 
     * @return descrição da roda
     */
    String getModelo();
}
