package br.com.rpires;

import br.com.rpires.dao.ContratoDao;
import br.com.rpires.dao.mocks.ContratoDaoMock;
import br.com.rpires.service.ContratoService;
import br.com.rpires.service.IContratoService;
import br.com.rpires.dao.IContratoDao;

import org.junit.Assert;
import org.junit.Test;

/**
 * Classe responsável por testar a camada de serviço
 * utilizando implementação real e mock.
 * 
 * Demonstra teste de sucesso e teste de exceção.
 * 
 * @author Leonardo
 */
public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);

        String retorno = service.salvar();

        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDadosTest() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);

        service.salvar();
    }

    @Test
    public void buscarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);

        String retorno = service.buscar();

        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void excluirTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);

        String retorno = service.excluir();

        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void atualizarTest() {
        IContratoDao dao = new ContratoDaoMock();
        IContratoService service = new ContratoService(dao);

        String retorno = service.atualizar();

        Assert.assertEquals("Sucesso", retorno);
    }
}
