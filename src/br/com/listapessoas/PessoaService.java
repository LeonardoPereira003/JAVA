package br.com.listapessoas;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaService {

    public List<Pessoa> filtrarSomenteMulheres(List<Pessoa> pessoas) {
        return pessoas.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("F"))
                .collect(Collectors.toList());
    }
}
