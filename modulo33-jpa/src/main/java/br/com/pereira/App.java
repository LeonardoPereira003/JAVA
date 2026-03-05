package br.com.pereira;

import br.com.pereira.controller.CarroController;
import br.com.pereira.domain.*;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        CarroController controller = new CarroController();

        Marca marca = new Marca();
        marca.setNome("Toyota");

        Acessorio som = new Acessorio();
        som.setNome("Som Premium");

        Acessorio multimidia = new Acessorio();
        multimidia.setNome("Multimídia 10 polegadas");

        Documento documento = new Documento();
        documento.setNumeroChassi("ABC123456789");

        Carro carro = new Carro();
        carro.setModelo("Corolla");
        carro.setAno(2024);
        carro.setMarca(marca);
        carro.setDocumento(documento);
        carro.setAcessorios(Arrays.asList(som, multimidia));

        controller.cadastrar(carro);
    }
}