package com.leonardo.projeto2.dao.impl;

import com.leonardo.projeto2.dao.INotaFiscalDAO;
import com.leonardo.projeto2.domain.NotaFiscal;

/**
 * DAO em memória para NotaFiscal.
 */
public class NotaFiscalMapDAO extends AbstractMapDAO<NotaFiscal, Long>
        implements INotaFiscalDAO {

    @Override
    protected Long getId(NotaFiscal entity) {
        return entity.getId();
    }
}
