package Projeto_1.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Projeto_1.domain.Clientes;

/**
 * Implementação da interface IClientesDAO utilizando
 * um Map para simular um banco de dados em memória.
 * 
 * A chave do Map é o CPF do cliente.
 */
public class ClientesMapDAO implements IClientesDAO {

    // Estrutura que simula o banco de dados
    private Map<Long, Clientes> map;

    /**
     * Construtor que inicializa o Map.
     */
    public ClientesMapDAO() {
        this.map = new HashMap<>();
    }

    /**
     * Cadastra um novo cliente.
     * 
     * @param clientes Cliente a ser cadastrado
     * @return true se cadastrou com sucesso,
     *         false se já existir cliente com mesmo CPF
     */
    @Override
    public boolean cadastrar(Clientes clientes) {

        // Verifica se já existe cliente com esse CPF
        if (this.map.containsKey(clientes.getCpf())) {
            return false;
        }

        // Adiciona cliente ao Map
        this.map.put(clientes.getCpf(), clientes);

        return true;
    }

    /**
     * Remove um cliente pelo CPF.
     * 
     * @param cpf CPF do cliente a ser removido
     */
    @Override
    public void excluir(Long cpf) {

        Clientes clienteCadastrado = this.map.get(cpf);

        // Se existir, remove
        if (clienteCadastrado != null) {
            this.map.remove(cpf);
        }
    }

    /**
     * Atualiza os dados de um cliente.
     * 
     * @param cliente Cliente com dados atualizados
     */
    @Override
    public void alterar(Clientes cliente) {

        // Verifica se cliente já existe
        if (this.map.containsKey(cliente.getCpf())) {
            this.map.put(cliente.getCpf(), cliente);
        }
    }

    /**
     * Consulta um cliente pelo CPF.
     * 
     * @param cpf CPF do cliente
     * @return Cliente encontrado ou null se não existir
     */
    @Override
    public Clientes consultar(Long cpf) {
        return this.map.get(cpf);
    }

    /**
     * Retorna todos os clientes cadastrados.
     * 
     * @return Collection com todos os clientes
     */
    @Override
    public Collection<Clientes> buscarTodos() {
        return this.map.values();
    }
}
