package Projeto_1;


import Projeto_1.view.TelaCadastro;

/**
 * Classe principal da aplicação.
 * Apenas inicializa a interface gráfica.
 */
public class App {

    public static void main(String[] args) {

        // Boa prática para Swing
        javax.swing.SwingUtilities.invokeLater(() -> {
            new TelaCadastro().setVisible(true);
        });
    }
}
