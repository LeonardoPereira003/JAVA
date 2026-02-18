package com.leonardo.projeto2.service;

import java.util.List;

/**
 * Interface genérica para serviços da aplicação.
 *
 * @param <T>  Tipo da entidade
 * @param <ID> Tipo do identificador
 */
public interface IGenericService<T, ID> {

    void salvar(T entity);

    T buscarPorId(ID id);

    List<T> buscarTodos();

    void remover(ID id);
}
