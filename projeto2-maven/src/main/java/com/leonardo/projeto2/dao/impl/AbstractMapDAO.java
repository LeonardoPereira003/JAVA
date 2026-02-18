package com.leonardo.projeto2.dao.impl;

import com.leonardo.projeto2.dao.IGenericDAO;

import java.util.*;

/**
 * Implementação genérica baseada em Map
 * que simula persistência em memória.
 *
 * @param <T>  Tipo da entidade
 * @param <ID> Tipo do identificador
 */
public abstract class AbstractMapDAO<T, ID> implements IGenericDAO<T, ID> {

    /**
     * Estrutura que simula o banco de dados.
     */
    protected Map<ID, T> banco = new HashMap<>();

    @Override
    public void salvar(T entity) {
        banco.put(getId(entity), entity);
    }

    @Override
    public T buscarPorId(ID id) {
        return banco.get(id);
    }

    @Override
    public List<T> buscarTodos() {
        return new ArrayList<>(banco.values());
    }

    @Override
    public void remover(ID id) {
        banco.remove(id);
    }

    /**
     * Método abstrato que obriga
     * as subclasses a definirem
     * como obter o ID da entidade.
     */
    protected abstract ID getId(T entity);
}
