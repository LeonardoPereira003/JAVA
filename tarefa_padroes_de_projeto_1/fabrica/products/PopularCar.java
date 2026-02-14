package tarefa_padroes_de_projeto_1.fabrica.products;

/**
 * Classe concreta que representa um carro popular.
 * 
 * Depende de Motor e Roda para sua composição.
 */
public class PopularCar implements Car {

    private Motor motor;
    private Roda roda;

    /**
     * Construtor com injeção de dependência.
     * 
     * @param motor Motor do carro
     * @param roda  Roda do carro
     */
    public PopularCar(Motor motor, Roda roda) {
        this.motor = motor;
        this.roda = roda;
    }

    @Override
    public void montar() {
        System.out.println("===== CARRO POPULAR =====");
        System.out.println("Motor: " + motor.getTipo());
        System.out.println("Rodas: " + roda.getModelo());
        System.out.println("Carro montado com sucesso!");
    }
}
