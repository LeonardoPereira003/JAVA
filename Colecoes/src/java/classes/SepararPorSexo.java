
    package Colecoes.src.java.classes;

// Importa a classe ArrayList, que é uma implementação de List
import java.util.ArrayList;

// Importa a interface List (boa prática: programar para a interface)
import java.util.List;

// Importa a classe Scanner para ler dados do teclado
import java.util.Scanner;

// Declara a classe principal do programa
public class SepararPorSexo {

    // Método principal — ponto de entrada da aplicação
    public static void main(String[] args) {

        // Cria um objeto Scanner para capturar entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Cria uma lista para armazenar nomes do sexo masculino
        List<String> masculino = new ArrayList<>();

        // Cria uma lista para armazenar nomes do sexo feminino
        List<String> feminino = new ArrayList<>();

        // Exibe instruções para o usuário
        System.out.println("Digite nome e sexo no formato Nome-Sexo (ex: João-M)");
        System.out.println("Digite 'sair' para encerrar");

        // Loop infinito (vai rodar até o usuário digitar "sair")
        while (true) {

            // Lê uma linha inteira digitada pelo usuário
            String entrada = scanner.nextLine();

            // Verifica se o usuário quer encerrar o programa
            if (entrada.equalsIgnoreCase("sair")) {
                break; // sai do loop
            }

            // Divide a String usando o "-" como separador
            // Ex: "João-M" vira ["João", "M"]
            String[] dados = entrada.split("-");

            // Pega o nome (posição 0 do array)
            String nome = dados[0];

            // Pega o sexo (posição 1 do array)
            String sexo = dados[1];

            // Verifica se o sexo é masculino
            if (sexo.equalsIgnoreCase("M")) {

                // Adiciona o nome na lista masculina
                masculino.add(nome);

            // Verifica se o sexo é feminino
            } else if (sexo.equalsIgnoreCase("F")) {

                // Adiciona o nome na lista feminina
                feminino.add(nome);

            // Caso o sexo digitado não seja válido
            } else {
                System.out.println("Sexo inválido. Use M ou F.");
            }
        }

        // Exibe o grupo masculino
        System.out.println("\nGrupo Masculino:");
        System.out.println(masculino);

        // Exibe o grupo feminino
        System.out.println("\nGrupo Feminino:");
        System.out.println(feminino);

        // Fecha o Scanner (boa prática para liberar recursos)
        scanner.close();
    }
}
