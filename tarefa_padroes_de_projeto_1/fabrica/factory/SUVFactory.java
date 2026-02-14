package tarefa_padroes_de_projeto_1.fabrica.factory;

import tarefa_padroes_de_projeto_1.fabrica.products.*;

/**
 * Fábrica concreta responsável por criar
 * a família de objetos do tipo SUV.
 */
public class SUVFactory implements CarFactory {

    @Override
    public Motor criarMotor() {
        return new MotorSUV();
    }

    @Override
    public Roda criarRoda() {
        return new RodaSUV();
    }

    @Override
    public Car criarCarro() {
        return new SUVCar(criarMotor(), criarRoda());
    }
}
