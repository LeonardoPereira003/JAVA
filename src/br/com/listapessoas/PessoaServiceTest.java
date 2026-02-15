package br.com.listapessoas;

import java.util.Arrays;
import java.util.List;

class PessoaServiceTest {

    @Test
    void deveRetornarApenasMulheres() {

        PessoaService service = new PessoaService();

        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Ana", "F"),
                new Pessoa("Maria", "F"),
                new Pessoa("João", "M"),
                new Pessoa("Carla", "F")
        );

        List<Pessoa> resultado = service.filtrarSomenteMulheres(pessoas);

        // 🔥 Aqui está o teste real
        boolean todasSaoMulheres = resultado.stream()
                .allMatch(p -> p.getSexo().equalsIgnoreCase("F"));

        assertTrue(todasSaoMulheres);
    }

}