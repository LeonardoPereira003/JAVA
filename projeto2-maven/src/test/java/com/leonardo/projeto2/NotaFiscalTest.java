package com.leonardo.projeto2;

import com.leonardo.projeto2.domain.Cliente;
import com.leonardo.projeto2.domain.NotaFiscal;
import com.leonardo.projeto2.domain.Produto;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Teste unitário da NotaFiscal.
 */
public class NotaFiscalTest {

    @Test
    void deveCalcularTotalCorretamente() {

        Cliente cliente = new Cliente(1L, "Teste", "111", "teste@email.com");

        Produto p1 = new Produto(1L, "Produto1", new BigDecimal("100"));
        Produto p2 = new Produto(2L, "Produto2", new BigDecimal("200"));

        NotaFiscal nota = new NotaFiscal(1L, cliente);
        nota.adicionarProduto(p1);
        nota.adicionarProduto(p2);

        assertEquals(new BigDecimal("300"), nota.calcularTotal());
    }
}
