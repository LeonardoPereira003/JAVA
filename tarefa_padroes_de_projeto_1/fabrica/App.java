
package tarefa_padroes_de_projeto_1.fabrica;

import tarefa_padroes_de_projeto_1.fabrica.factory.CarFactory;
import tarefa_padroes_de_projeto_1.fabrica.factory.PopularFactory;
import tarefa_padroes_de_projeto_1.fabrica.factory.SUVFactory;
import tarefa_padroes_de_projeto_1.fabrica.products.Car;

/**
 * Classe principal responsável por executar o sistema.
 * 
 * Demonstra o uso do padrão Abstract Factory.
 */
public class App {

    public static void main(String[] args) {

        CarFactory factory;

        // Simulação de escolha do cliente
        String tipo = "SUV";

        if (tipo.equalsIgnoreCase("SUV")) {
            factory = new SUVFactory();
        } else {
            factory = new PopularFactory();
        }

        // Criação do carro através da fábrica
        Car carro = factory.criarCarro();

        // Montagem do carro
        carro.montar();
    }
}
