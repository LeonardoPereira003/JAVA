package br.com.rpires.dao;

/**
 * Interface responsável por definir as operações
 * de persistência do objeto Contrato.
 * 
 * Essa interface representa o contrato da camada DAO,
 * seguindo o princípio da Inversão de Dependência.
 * 
 * @author Leonardo
 */
public interface IContratoDao {

    /**
     * Salva um contrato.
     */
    void salvar();

    /**
     * Busca um contrato.
     */
    void buscar();

    /**
     * Exclui um contrato.
     */
    void excluir();

    /**
     * Atualiza um contrato.
     */
    void atualizar();
}
