package tarefa_padroes_de_projeto_1.fabrica.products;

/**
 * Implementação concreta de um motor SUV.
 */
public class MotorSUV implements Motor {

    @Override
    public String getTipo() {
        return "Motor 2.4 Turbo";
    }
}
