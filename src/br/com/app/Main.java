package src.br.com.app;

import src.br.com.projetoannotation.domain.*;
import src.br.com.projetoannotation.annotation.*;

public class Main {

    public static void main(String[] args) {

        imprimirNomeTabela(Cliente.class);
        imprimirNomeTabela(Produto.class);
    }

    private static void imprimirNomeTabela(Class<?> classe) {

        if (classe.isAnnotationPresent(TABELA.class)) {

            TABELA tabela = classe.getAnnotation(TABELA.class);

            System.out.println("Classe: " + classe.getSimpleName());
            System.out.println("Nome da tabela: " + tabela.value());
            System.out.println("---------------------------");
        } else {
            System.out.println("A classe não possui annotation TABELA.");
        }
    }
}