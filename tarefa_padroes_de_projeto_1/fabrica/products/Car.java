package tarefa_padroes_de_projeto_1.fabrica.products;


/**
 * Interface que representa um carro genérico.
 * 
 * Todas as implementações devem definir como o carro será montado.
 * 
 * @author Leonardo
 */
public interface Car {

    /**
     * Método responsável por montar o carro
     * utilizando suas dependências (Motor e Roda).
     */
    void montar();
}
