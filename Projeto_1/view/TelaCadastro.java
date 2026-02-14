package Projeto_1.view;

import Projeto_1.dao.ClientesMapDAO;
import Projeto_1.dao.IClientesDAO;
import Projeto_1.domain.Clientes;

import javax.swing.*;
import java.awt.*;


/**
 * Tela gráfica para cadastro de clientes utilizando Swing.
 */
public class TelaCadastro extends JFrame {

    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtTel;
    private JTextField txtEndereco;
    private JTextField txtNumero;
    private JTextField txtCidade;
    private JTextField txtEstado;

    private IClientesDAO dao;

    public TelaCadastro() {

        dao = new ClientesMapDAO();

        setTitle("Cadastro de Clientes");
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 5, 5));

        panel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panel.add(txtNome);

        panel.add(new JLabel("CPF:"));
        txtCpf = new JTextField();
        panel.add(txtCpf);

        panel.add(new JLabel("Telefone:"));
        txtTel = new JTextField();
        panel.add(txtTel);

        panel.add(new JLabel("Endereço:"));
        txtEndereco = new JTextField();
        panel.add(txtEndereco);

        panel.add(new JLabel("Número:"));
        txtNumero = new JTextField();
        panel.add(txtNumero);

        panel.add(new JLabel("Cidade:"));
        txtCidade = new JTextField();
        panel.add(txtCidade);

        panel.add(new JLabel("Estado:"));
        txtEstado = new JTextField();
        panel.add(txtEstado);

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnConsultar = new JButton("Consultar");
        JButton btnAlterar = new JButton("Alterar");
        JButton btnExcluir = new JButton("Excluir");

        panel.add(btnCadastrar);
        panel.add(btnConsultar);
        panel.add(btnAlterar);
        panel.add(btnExcluir);

        add(panel);

        // ================= EVENTOS =================

        btnCadastrar.addActionListener(e -> cadastrar());

        btnConsultar.addActionListener(e -> consultar());

        btnAlterar.addActionListener(e -> alterar());

        btnExcluir.addActionListener(e -> excluir());
    }

    private void cadastrar() {

        try {

            Clientes cliente = new Clientes(
                    txtNome.getText(),
                    txtCpf.getText(),
                    txtTel.getText(),
                    txtEndereco.getText(),
                    txtNumero.getText(),
                    txtCidade.getText(),
                    txtEstado.getText()
            );

            boolean sucesso = dao.cadastrar(cliente);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso!");
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(this, "CPF já cadastrado!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro nos dados digitados.");
        }
    }

    private void consultar() {

        try {
            Long cpf = Long.valueOf(txtCpf.getText());
            Clientes cliente = dao.consultar(cpf);

            if (cliente != null) {
                txtNome.setText(cliente.getNome());
                txtTel.setText(cliente.getTel().toString());
                txtEndereco.setText(cliente.getEnd());
                txtNumero.setText(cliente.getNumero().toString());
                txtCidade.setText(cliente.getCidade());
                txtEstado.setText(cliente.getEstado());
            } else {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "CPF inválido.");
        }
    }

    private void alterar() {

        try {

            Clientes cliente = new Clientes(
                    txtNome.getText(),
                    txtCpf.getText(),
                    txtTel.getText(),
                    txtEndereco.getText(),
                    txtNumero.getText(),
                    txtCidade.getText(),
                    txtEstado.getText()
            );

            dao.alterar(cliente);
            JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao alterar cliente.");
        }
    }

    private void excluir() {

        try {
            Long cpf = Long.valueOf(txtCpf.getText());
            dao.excluir(cpf);
            JOptionPane.showMessageDialog(this, "Cliente excluído!");
            limparCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "CPF inválido.");
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtTel.setText("");
        txtEndereco.setText("");
        txtNumero.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
    }
}
