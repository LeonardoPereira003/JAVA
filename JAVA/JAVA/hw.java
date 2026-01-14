// ------------------------------ CRIAÇÃO DA CLASSE --------------------------
public class hw {
// ------------------------------ CRIAÇÃO DA MAIN ----------------------------    
    public static void main(String[] args) {
// ------------------------------ CRIAÇAO DE VARIAVEL TIPO STRING ------------
        String solicitante = args[0];
        if (solicitante.equalsIgnoreCase("Professor")) {
            System.out.println("Obrigado por me ensinar essa maravilha odiada por todos, espero me tornar um grande Dev a partir de seus ensinamentos.");
        } 
        else if (solicitante.equalsIgnoreCase("Estranho")) {
            System.out.println(args[0] + " SAI PRA LÁ CURIOSO");
        }
    }
}cd