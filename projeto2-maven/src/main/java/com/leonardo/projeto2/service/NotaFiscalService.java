package com.leonardo.projeto2.service;

import com.leonardo.projeto2.dao.INotaFiscalDAO;
import com.leonardo.projeto2.domain.NotaFiscal;

import java.util.List;

/**
 * Camada de regra de negócio da Nota Fiscal.
 */
public class NotaFiscalService {

    private final INotaFiscalDAO notaFiscalDAO;

    public NotaFiscalService(INotaFiscalDAO notaFiscalDAO) {
        this.notaFiscalDAO = notaFiscalDAO;
    }

    public void emitirNota(NotaFiscal nota) {
        notaFiscalDAO.salvar(nota);
    }

    public NotaFiscal buscarPorId(Long id) {
        return notaFiscalDAO.buscarPorId(id);
    }

    public List<NotaFiscal> listarTodas() {
        return notaFiscalDAO.buscarTodos();
    }

    public void cancelarNota(Long id) {
        notaFiscalDAO.remover(id);
    }
}
