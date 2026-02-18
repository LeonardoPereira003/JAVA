package com.leonardo.projeto2.service;

import com.leonardo.projeto2.dao.IGenericDAO;

import java.util.List;

/**
 * Implementação base para serviços genéricos.
 */
public abstract class AbstractService<T, ID>
        implements IGenericService<T, ID> {

    protected IGenericDAO<T, ID> dao;

    protected AbstractService(IGenericDAO<T, ID> dao) {
        this.dao = dao;
    }

    @Override
    public void salvar(T entity) {
        dao.salvar(entity);
    }

    @Override
    public T buscarPorId(ID id) {
        return dao.buscarPorId(id);
    }

    @Override
    public List<T> buscarTodos() {
        return dao.buscarTodos();
    }

    @Override
    public void remover(ID id) {
        dao.remover(id);
    }
}
