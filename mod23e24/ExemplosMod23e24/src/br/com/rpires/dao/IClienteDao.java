package br.com.rpires.dao;

/**
 * Interface de persistência do Cliente
 */
public interface IClienteDao {

    String salvar();

    String buscar();

    String excluir();

    String atualizar();
}
