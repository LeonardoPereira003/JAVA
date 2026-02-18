package br.com.rpires.dao;

/**
 * Implementação real da interface IContratoDao.
 * 
 * Essa classe simula um acesso ao banco de dados.
 * Como não temos banco configurado, os métodos
 * lançam UnsupportedOperationException.
 * 
 * @author Leonardo
 */
public class ContratoDao implements IContratoDao {

    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Não funciona sem banco de dados");
    }

    @Override
    public void buscar() {
        throw new UnsupportedOperationException("Não funciona sem banco de dados");
    }

    @Override
    public void excluir() {
        throw new UnsupportedOperationException("Não funciona sem banco de dados");
    }

    @Override
    public void atualizar() {
        throw new UnsupportedOperationException("Não funciona sem banco de dados");
    }
}
