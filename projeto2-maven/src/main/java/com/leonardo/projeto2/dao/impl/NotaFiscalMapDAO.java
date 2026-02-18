package com.leonardo.projeto2.dao.impl;

import com.leonardo.projeto2.dao.INotaFiscalDAO;
import com.leonardo.projeto2.domain.NotaFiscal;

import java.util.*;

/**
 * Implementação em memória do DAO de Nota Fiscal.
 */
public class NotaFiscalMapDAO implements INotaFiscalDAO {

    private final Map<Long, NotaFiscal> banco = new HashMap<>();

    @Override
    public void salvar(NotaFiscal notaFiscal) {
        banco.put(notaFiscal.getId(), notaFiscal);
    }

    @Override
    public NotaFiscal buscarPorId(Long id) {
        return banco.get(id);
    }

    @Override
    public List<NotaFiscal> buscarTodos() {
        return new ArrayList<>(banco.values());
    }

    @Override
    public void remover(Long id) {
        banco.remove(id);
    }
}
