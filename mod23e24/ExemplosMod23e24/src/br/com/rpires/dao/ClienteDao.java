package br.com.rpires.dao;

/**
 * Implementação real do ClienteDao
 */
public class ClienteDao implements IClienteDao {

    @Override
    public String salvar() {
        throw new UnsupportedOperationException("Sem banco de dados");
    }

    @Override
    public String buscar() {
        throw new UnsupportedOperationException("Sem banco de dados");
    }

    @Override
    public String excluir() {
        throw new UnsupportedOperationException("Sem banco de dados");
    }

    @Override
    public String atualizar() {
        throw new UnsupportedOperationException("Sem banco de dados");
    }
}
