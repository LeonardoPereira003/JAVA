package tarefa_padroes_de_projeto_1.fabrica.factory;


import tarefa_padroes_de_projeto_1.fabrica.products.Car;
import tarefa_padroes_de_projeto_1.fabrica.products.Motor;
import tarefa_padroes_de_projeto_1.fabrica.products.Roda;

/**
 * Interface Abstract Factory.
 * 
 * Responsável por definir métodos para criação
 * de uma família de objetos relacionados.
 */
public interface CarFactory {

    /**
     * Cria um motor específico.
     * 
     * @return Motor
     */
    Motor criarMotor();

    /**
     * Cria uma roda específica.
     * 
     * @return Roda
     */
    Roda criarRoda();

    /**
     * Cria um carro completo.
     * 
     * @return Car
     */
    Car criarCarro();
}

