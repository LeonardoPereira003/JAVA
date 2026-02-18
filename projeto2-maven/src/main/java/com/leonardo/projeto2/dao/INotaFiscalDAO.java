package com.leonardo.projeto2.dao;

import com.leonardo.projeto2.domain.NotaFiscal;
import java.util.List;

public interface INotaFiscalDAO {

    void salvar(NotaFiscal notaFiscal);

    NotaFiscal buscarPorId(Long id);

    List<NotaFiscal> buscarTodos();

    void remover(Long id);
}
