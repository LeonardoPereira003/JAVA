package com.leonardo.projeto2.dao;

import com.leonardo.projeto2.domain.Produto;
import java.util.List;

public interface IProdutoDAO {

    void salvar(Produto produto);

    Produto buscarPorId(Long id);

    List<Produto> buscarTodos();

    void remover(Long id);
}
