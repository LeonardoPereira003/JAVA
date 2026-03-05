package br.com.pereira.service;

import br.com.pereira.domain.Carro;
import br.com.pereira.repository.CarroRepository;

public class CarroService {

    private CarroRepository repository = new CarroRepository();

    public void cadastrarCarro(Carro carro) {

        if (carro.getModelo() == null || carro.getModelo().isEmpty()) {
            throw new RuntimeException("Modelo obrigatório");
        }

        if (carro.getAno() < 1900) {
            throw new RuntimeException("Ano inválido");
        }

        repository.salvar(carro);
    }
}