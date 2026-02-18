package com.leonardo.projeto2.service;

import com.leonardo.projeto2.dao.INotaFiscalDAO;
import com.leonardo.projeto2.domain.NotaFiscal;

/**
 * Service responsável pelas regras de negócio da Nota Fiscal.
 */
public class NotaFiscalService
        extends AbstractService<NotaFiscal, Long> {

    public NotaFiscalService(INotaFiscalDAO dao) {
        super(dao);
    }

    /**
     * Regra específica: emitir nota.
     */
    public void emitirNota(NotaFiscal nota) {
        if (nota.getProdutos().isEmpty()) {
            throw new IllegalStateException("Nota fiscal deve ter pelo menos um produto.");
        }

        salvar(nota);
    }
}
