package br.com.rpires.dao.mocks;

import br.com.rpires.dao.IClienteDao;

/**
 * Mock de ClienteDao
 */
public class ClienteDaoMock implements IClienteDao {

    @Override
    public String salvar() {
        return "Sucesso";
    }

    @Override
    public String buscar() {
        return "Sucesso";
    }

    @Override
    public String excluir() {
        return "Sucesso";
    }

    @Override
    public String atualizar() {
        return "Sucesso";
    }
}
