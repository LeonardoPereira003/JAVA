// Classe principal do programa
public class Morning {

    // Variáveis que representam o tempo (em minutos) de cada atividade
    private static int acordandoCama;
    private static int acordandoDentes;
    private static int acordandoRosto;
    private static int acordandoCafe;
    private static int acordandoAjeitando;

    // Método principal: ponto inicial do programa
    public static void main(String[] args) {

        // Chama o método que inicializa os valores
        criarDadosPessoais();

        // Exibe as mensagens com os tempos
        System.out.println(acordandoCama + " min - Aqui eu não sei se eu to acordado ou dormindo kkkkk, só sei que o despertador ta tocando");
        System.out.println(acordandoRosto + " min - Dando aquele trato no rosto né kkk");
        System.out.println(acordandoDentes + " min - Escovando dentes");
        System.out.println(acordandoAjeitando + " min - Aqui eu me ajeitando pra ir trabalhar e arrumando a cama também");
        System.out.println(acordandoCafe + " min - Fazendo meu café da manhã para já ajudar a bater a meta de proteína diária kkkk");
    }

    // Método responsável por definir os valores das variáveis
    private static void criarDadosPessoais() {
        acordandoCama = 5;
        acordandoDentes = 5;
        acordandoRosto = 10;
        acordandoCafe = 30;
        acordandoAjeitando = 5;
    }
}
