package generic.app;

import java.util.ArrayList;
import java.util.List;
import generic.model.*;

public class App {

    public static void main(String[] args) {

        // Lista que aceita QUALQUER tipo de carro
        List<Carro> listaCarros = new ArrayList<>();

        listaCarros.add(new Honda("Civic", 2022, 120000));
        listaCarros.add(new BYD("Dolphin", 2023, 150000));
        listaCarros.add(new Honda("HR-V", 2021, 110000));

        for (Carro carro : listaCarros) {
            carro.exibirInfo(); // Polimorfismo acontece aqui
        }
    }
}
