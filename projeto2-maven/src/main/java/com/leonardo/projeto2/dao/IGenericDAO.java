package com.leonardo.projeto2.dao;

import java.util.List;

/**
 * Interface genérica para operações básicas de persistência.
 *
 * @param <T>  Tipo da entidade
 * @param <ID> Tipo do identificador
 */
public interface IGenericDAO<T, ID> {

    void salvar(T entity);

    T buscarPorId(ID id);

    List<T> buscarTodos();

    void remover(ID id);
}
