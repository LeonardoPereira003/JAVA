package tarefa_padroes_de_projeto_1.fabrica.products;

/**
 * Classe concreta que representa um carro do tipo SUV.
 */
public class SUVCar implements Car {

    private Motor motor;
    private Roda roda;

    /**
     * Construtor que recebe as dependências do carro.
     * 
     * @param motor Motor do SUV
     * @param roda  Roda do SUV
     */
    public SUVCar(Motor motor, Roda roda) {
        this.motor = motor;
        this.roda = roda;
    }

    @Override
    public void montar() {
        System.out.println("===== SUV =====");
        System.out.println("Motor: " + motor.getTipo());
        System.out.println("Rodas: " + roda.getModelo());
        System.out.println("SUV montado com sucesso!");
    }
}
