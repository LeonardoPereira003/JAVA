package br.com.rpires.dao.jdbc;

import java.util.List;
import br.com.rpires.domain.Venda;

public interface IVendaDAO {

    Integer cadastrar(Venda venda) throws Exception;

    Venda buscar(Long id) throws Exception;

    List<Venda> buscarTodos() throws Exception;

    Integer excluir(Long id) throws Exception;
}