package br.com.pereira.controller;

import br.com.pereira.domain.Carro;
import br.com.pereira.service.CarroService;

public class CarroController {

    private CarroService service = new CarroService();

    public void cadastrar(Carro carro) {

        service.cadastrarCarro(carro);

        System.out.println("🚗 Carro cadastrado com sucesso!");
    }
}