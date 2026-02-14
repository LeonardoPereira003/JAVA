package tarefa_padroes_de_projeto_1.fabrica.products;

/**
 * Implementação concreta de um motor popular.
 */
public class MotorPopular implements Motor {

    @Override
    public String getTipo() {
        return "Motor 1.0 Econômico";
    }
}
