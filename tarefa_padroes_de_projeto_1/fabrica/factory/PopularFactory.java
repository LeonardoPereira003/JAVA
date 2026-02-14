package tarefa_padroes_de_projeto_1.fabrica.factory;



import tarefa_padroes_de_projeto_1.fabrica.products.*;

/**
 * Fábrica concreta responsável por criar
 * a família de objetos do tipo Popular.
 */
public class PopularFactory implements CarFactory {

    @Override
    public Motor criarMotor() {
        return new MotorPopular();
    }

    @Override
    public Roda criarRoda() {
        return new RodaPopular();
    }

    @Override
    public Car criarCarro() {
        return new PopularCar(criarMotor(), criarRoda());
    }
}
