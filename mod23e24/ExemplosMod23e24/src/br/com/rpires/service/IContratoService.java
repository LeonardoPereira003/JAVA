package br.com.rpires.service;

/**
 * Interface responsável pelas regras de negócio
 * relacionadas ao Contrato.
 * 
 * Define os métodos que a camada de serviço deve implementar.
 * 
 * @author Leonardo
 */
public interface IContratoService {

    /**
     * Executa a regra de salvar contrato.
     * 
     * @return mensagem de sucesso
     */
    String salvar();

    /**
     * Executa a regra de buscar contrato.
     * 
     * @return mensagem de sucesso
     */
    String buscar();

    /**
     * Executa a regra de excluir contrato.
     * 
     * @return mensagem de sucesso
     */
    String excluir();

    /**
     * Executa a regra de atualizar contrato.
     * 
     * @return mensagem de sucesso
     */
    String atualizar();
}
