package br.com.rpires.service;

import br.com.rpires.dao.IContratoDao;

/**
 * Implementação da camada de serviço.
 * 
 * Essa classe recebe a dependência da interface IContratoDao
 * através do construtor (Injeção de Dependência).
 * 
 * Aplica a regra de negócio e retorna mensagem de sucesso.
 * 
 * @author Leonardo
 */
public class ContratoService implements IContratoService {

    private IContratoDao dao;

    /**
     * Construtor que recebe a implementação do DAO.
     * 
     * @param dao implementação da interface IContratoDao
     */
    public ContratoService(IContratoDao dao) {
        this.dao = dao;
    }

    @Override
    public String salvar() {
        dao.salvar();
        return "Sucesso";
    }

    @Override
    public String buscar() {
        dao.buscar();
        return "Sucesso";
    }

    @Override
    public String excluir() {
        dao.excluir();
        return "Sucesso";
    }

    @Override
    public String atualizar() {
        dao.atualizar();
        return "Sucesso";
    }
}
