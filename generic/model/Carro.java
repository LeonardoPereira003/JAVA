package generic.model;

public abstract class Carro {

    protected String modelo;
    protected int ano;
    protected double preco;

    public Carro(String modelo, int ano, double preco) {
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getPreco() {
        return preco;
    }

    // Método abstrato (cada marca implementa do seu jeito)
    public abstract String getMarca();

    public void exibirInfo() {
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Preço: " + preco);
        System.out.println("----------------------");
    }
}

