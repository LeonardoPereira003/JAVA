package com.leonardo.projeto2.app;

import com.leonardo.projeto2.dao.impl.ClienteMapDAO;
import com.leonardo.projeto2.dao.impl.ProdutoMapDAO;
import com.leonardo.projeto2.dao.impl.NotaFiscalMapDAO;
import com.leonardo.projeto2.domain.Cliente;
import com.leonardo.projeto2.domain.Produto;
import com.leonardo.projeto2.domain.NotaFiscal;
import com.leonardo.projeto2.service.NotaFiscalService;

import java.math.BigDecimal;

/**
 * Classe principal da aplicação.
 */
public class Main {

    public static void main(String[] args) {

        ClienteMapDAO clienteDAO = new ClienteMapDAO();
        ProdutoMapDAO produtoDAO = new ProdutoMapDAO();
        NotaFiscalMapDAO notaDAO = new NotaFiscalMapDAO();

        Cliente cliente = new Cliente(1L, "Leonardo", "12345678900", "leo@email.com");
        clienteDAO.salvar(cliente);

        Produto p1 = new Produto(1L, "Notebook", new BigDecimal("3500.00"));
        Produto p2 = new Produto(2L, "Mouse", new BigDecimal("150.00"));

        produtoDAO.salvar(p1);
        produtoDAO.salvar(p2);

        NotaFiscal nota = new NotaFiscal(1001L, cliente);
        nota.adicionarProduto(p1);
        nota.adicionarProduto(p2);

        NotaFiscalService service = new NotaFiscalService(notaDAO);
        service.emitirNota(nota);

        System.out.println("Total da Nota: " + nota.calcularTotal());
    }
}
