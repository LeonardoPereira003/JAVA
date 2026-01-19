    package colecoes.src.java.classes.tarefaum;

    import java.util.*;

    public class ParteUm1 {

        // Criando o método main
        public static void main(String[] args) {

            // Cria o objeto scanner
            Scanner scanner = new Scanner(System.in);

            // Crinado as listas para erceber os dados
            TreeMap<String, String> pessoas = new TreeMap<>();

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
                    pessoas.put(nome, sexo);

                    // Verifica se o sexo é feminino
                } else if (sexo.equalsIgnoreCase("F")) {

                    // Adiciona o nome na lista feminina
                    pessoas.put(nome, sexo);

                    // Caso o sexo digitado não seja válido
                } else {
                    System.out.println("Sexo inválido. Use M ou F.");
                }
            }

            // Exibe o grupo masculino
            System.out.println("\nGrupo Masculino:");
            for (Map.Entry<String, String> entry : pessoas.entrySet()) {
                if (entry.getValue().equalsIgnoreCase("M")) {
                    System.out.println(entry.getKey());
                }
            }

            // Exibe o grupo feminino
            System.out.println("\nGrupo Feminino:");
            for (Map.Entry<String, String> entry : pessoas.entrySet()) {
                if (entry.getValue().equalsIgnoreCase("F")) {
                    System.out.println(entry.getKey());
                }
            }

            // Fecha o Scanner (boa prática para liberar recursos)
            scanner.close();
        }
    }
