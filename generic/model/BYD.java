package generic.model;



public class BYD extends Carro {

    public BYD(String modelo, int ano, double preco) {
        super(modelo, ano, preco);
    }

    @Override
    public String getMarca() {
        return "BYD";
    }
}
