package tarefa_wrapper.src.Classes;

/**
 * @author Leonardo Pereira
 */
public class Casting {

    public static void main(String[] args) {

        // Variável primitiva
        int idade = 22;

        // Conversão do primitivo para Wrapper
        Integer idadeWrapper = Integer.valueOf(idade);

        // Exibindo os valores
        System.out.println("Idade primitiva: " + idade);
        System.out.println("Idade Wrapper: " + idadeWrapper);
    }
}
