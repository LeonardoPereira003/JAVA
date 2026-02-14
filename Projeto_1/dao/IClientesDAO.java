package Projeto_1.dao;

import java.util.Collection;

import Projeto_1.domain.Clientes;

public interface IClientesDAO {

    public boolean cadastrar(Clientes clientes);

    public void excluir(Long cpf);

    public void alterar(Clientes cliente);

    public Clientes consultar(Long cpf);

    public Collection<Clientes> buscarTodos();

}
