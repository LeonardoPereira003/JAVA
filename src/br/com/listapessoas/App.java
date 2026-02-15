
package br.com.listapessoas;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Pessoa> pessoas = new ArrayList<>();

        System.out.println("Digite pessoas no formato Nome-Sexo separadas por vírgula:");
        String entrada = scanner.nextLine();

        // separa por vírgula
        String[] dados = entrada.split(",");

        // monta a lista de pessoas
        for (String item : dados) {
            String[] partes = item.trim().split("-");
            String nome = partes[0];
            String sexo = partes[1];

            pessoas.add(new Pessoa(nome, sexo));
        }

        // 🔥 lambda para filtrar mulheres
        List<Pessoa> mulheres = pessoas.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("F"))
                .collect(Collectors.toList());

        // imprime resultado
        System.out.println("\nLista de mulheres:");
        mulheres.forEach(System.out::println);

        scanner.close();
    }
}
