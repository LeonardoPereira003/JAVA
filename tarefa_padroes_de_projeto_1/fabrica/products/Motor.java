package tarefa_padroes_de_projeto_1.fabrica.products;

/**
 * Interface que representa um motor.
 * 
 * Cada tipo de carro possui um tipo específico de motor.
 * 
 * @author Leonardo
 */
public interface Motor {

    /**
     * Retorna o tipo do motor.
     * 
     * @return descrição do motor
     */
    String getTipo();
}
