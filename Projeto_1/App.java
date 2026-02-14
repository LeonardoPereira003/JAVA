package Projeto_1;

import javax.swing.JOptionPane;

import Projeto_1.dao.ClientesMapDAO;
import Projeto_1.dao.IClientesDAO;
import Projeto_1.domain.Clientes;

/**
 * Classe principal da aplicação.
 */
public class App {

    public static void main(String[] args) {

        IClientesDAO dao = new ClientesMapDAO();

        while (true) {

            String opcao = JOptionPane.showInputDialog(
                    null,
                    "Digite 1 para cadastrar\n"
                    + "Digite 2 para consultar\n"
                    + "Digite 3 para excluir\n"
                    + "Digite 4 para alterar\n"
                    + "Digite 5 para sair\n"
            );

            if (opcao == null) sair();

            if (!isOpcaoValida(opcao)) {
                JOptionPane.showMessageDialog(null, "Opção inválida");
                continue;
            }

            try {

                if ("1".equals(opcao)) cadastrar(dao);
                if ("2".equals(opcao)) consultar(dao);
                if ("3".equals(opcao)) excluir(dao);
                if ("4".equals(opcao)) alterar(dao);
                if ("5".equals(opcao)) sair();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Erro: CPF, telefone e número devem conter apenas números.");
            }
        }
    }

    // ================= CADASTRO =================

    private static void cadastrar(IClientesDAO dao) {

        Clientes cliente = criarCliente();
        if (cliente == null) sair();

        boolean sucesso = dao.cadastrar(cliente);

        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
        }
    }

    // ================= CONSULTA =================

    private static void consultar(IClientesDAO dao) {

        String cpfStr = inputObrigatorio("Digite o CPF para consultar:");
        Long cpf = Long.valueOf(cpfStr);

        Clientes cliente = dao.consultar(cpf);

        if (cliente != null) {
            JOptionPane.showMessageDialog(null,
                    "Nome: " + cliente.getNome()
                    + "\nCPF: " + cliente.getCpf()
                    + "\nTelefone: " + cliente.getTel()
                    + "\nEndereço: " + cliente.getEnd()
                    + ", " + cliente.getNumero()
                    + "\nCidade: " + cliente.getCidade()
                    + "\nEstado: " + cliente.getEstado()
            );
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
        }
    }

    // ================= EXCLUSÃO =================

    private static void excluir(IClientesDAO dao) {

        String cpfStr = inputObrigatorio("Digite o CPF para excluir:");
        Long cpf = Long.valueOf(cpfStr);

        Clientes cliente = dao.consultar(cpf);

        if (cliente != null) {
            dao.excluir(cpf);
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
        }
    }

    // ================= ALTERAÇÃO =================

    private static void alterar(IClientesDAO dao) {

        String cpfStr = inputObrigatorio("Digite o CPF do cliente para alterar:");
        Long cpf = Long.valueOf(cpfStr);

        Clientes clienteExistente = dao.consultar(cpf);

        if (clienteExistente != null) {

            Clientes clienteAtualizado = criarCliente();
            if (clienteAtualizado == null) sair();

            dao.alterar(clienteAtualizado);
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
        }
    }

    // ================= MÉTODO DE CRIAÇÃO COM VALIDAÇÃO =================

    private static Clientes criarCliente() {

        String nome = inputObrigatorio("Digite o nome:");
        String cpf = inputNumerico("Digite o CPF (apenas números):");
        String tel = inputNumerico("Digite o telefone (apenas números):");
        String end = inputObrigatorio("Digite o endereço:");
        String numero = inputNumerico("Digite o número:");
        String cidade = inputObrigatorio("Digite a cidade:");
        String estado = inputObrigatorio("Digite o estado:");

        return new Clientes(nome, cpf, tel, end, numero, cidade, estado);
    }

    // ================= VALIDAÇÕES =================

    private static String inputObrigatorio(String mensagem) {

        while (true) {
            String valor = JOptionPane.showInputDialog(mensagem);

            if (valor == null) sair();

            if (!valor.trim().isEmpty()) {
                return valor.trim();
            }

            JOptionPane.showMessageDialog(null, "Campo obrigatório!");
        }
    }

    private static String inputNumerico(String mensagem) {

        while (true) {
            String valor = JOptionPane.showInputDialog(mensagem);

            if (valor == null) sair();

            if (valor.matches("\\d+")) {
                return valor;
            }

            JOptionPane.showMessageDialog(null, "Digite apenas números!");
        }
    }

    private static boolean isOpcaoValida(String opcao) {
        return "1".equals(opcao)
            || "2".equals(opcao)
            || "3".equals(opcao)
            || "4".equals(opcao)
            || "5".equals(opcao);
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "See You");
        System.exit(0);
    }
}
