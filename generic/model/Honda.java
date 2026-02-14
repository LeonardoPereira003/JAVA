package generic.model;

public class Honda extends Carro {

    public Honda(String modelo, int ano, double preco) {
        super(modelo, ano, preco);
    }

    @Override
    public String getMarca() {
        return "Honda";
    }
}

