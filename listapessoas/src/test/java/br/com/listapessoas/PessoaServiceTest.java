package br.com.listapessoas;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    // 🔥 Aqui está a validação principal
    assertTrue(
            resultado.stream()
                    .allMatch(p -> p.getSexo().equalsIgnoreCase("F"))
    );

    // 🔥 Garante que só vieram 3
    assertEquals(3, resultado.size());
}
}
