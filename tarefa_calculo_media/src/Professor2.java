package tarefa_calculo_media.src;


/*** Caulculo de média dos alunos do 3° ano  "Médio"
 *  @author Leonardo Pereira
 */  

public class Professor2 {

/***
 * Os prints seram gerados aqui 
 * @param args
 */

    public static void main (String args[]){
        aluno1();
        aluno2();
        aluno3();
    }
    

/*** Aluna Gabriela Do Birinbal
 * Esforçada, sempre busca conhecimento
 * Se necessario arredondarei
 */

public static void aluno1() {

//Declarando o nome do Aluno

    String aluno = ("Gabriela Do Birinbal");

//Declarand as notas do Aluno   
    int nota1 = 10;
    int nota2 = 5;
    int nota3 = 6;
    int nota4 = 7;

//Declarando a média do Aluno

    double media = (nota1 + nota2 + nota3 + nota4) / 4.0;
    
    boolean isVerificacao1 = media >= 7 && media <= 10;
    boolean isVerificacao2 = media >= 5 && media <= 10;


/***
 * Fomratação condicional para a media 
 */
        if (isVerificacao1){
            System.out.println( (media));
            System.out.println( (aluno)+ ","  +  " " + ("Aprado."));
        }
        else if (isVerificacao2) {
            System.out.println( (media));
            System.out.println( (aluno)+ ","  +  " " + (" De Recuperação."));
        } 
        else {
            System.out.println( (media));
            System.out.println( (aluno)+ ","  +  " " + ("Reprovado."));
        }
    }


/*** Aluno James Du Cato
 * Baderneiro
 * Se eu pudesse tiraria nota
 */

public static void aluno2() {

//Declarando o nome do Aluno

    String aluno2 = ("James Du Cato");

//Declarand as notas do Aluno   
    int nota1 = 3;
    int nota2 = 1;
    int nota3 = 2;
    int nota4 = 6;



//Declarando a média do Aluno

    double media = (nota1 + nota2 + nota3 + nota4) / 4.0;
    
    boolean isVerificacao1 = media >= 7 && media <= 10;
    boolean isVerificacao2 = media >= 5 && media <= 10;

/***
 * Fomratação condicional para a media 
 */
        if (isVerificacao1){
            System.out.println( (media));
            System.out.println( (aluno2)+ ","  +  " " + ("Aprado."));
        }
        else if (isVerificacao2) {
            System.out.println( (media));
            System.out.println( (aluno2)+ ","  +  " " + (" De Recuperação."));
        } 
        else {
            System.out.println( (media));
            System.out.println( (aluno2)+ ","  +  " " + ("Reprovado."));
        }
    }

/*** Aluno James Du Cato
 * Baderneiro
 * Se eu pudesse tiraria nota
 */

public static void aluno3() {

//Declarando o nome do Aluno

    String aluno3 = ("BAYBE DO BAYBE DO TIRULAIBE LEIBE");

//Declarand as notas do Aluno   
    int nota1 = 3;
    int nota2 = 1;
    int nota3 = 2;
    int nota4 = 6;



//Declarando a média do Aluno

    double media = (nota1 + nota2 + nota3 + nota4) / 4.0;
    
    boolean isVerificacao1 = media >= 7 && media <= 10;
    boolean isVerificacao2 = media >= 5 && media <= 10;

/***
 * Fomratação condicional para a media 
 */
        if (isVerificacao1){
            System.out.println( (media));
            System.out.println( (aluno3)+ ","  +  " " + ("Aprado."));
        }
        else if (isVerificacao2) {
            System.out.println( (media));
            System.out.println( (aluno3)+ ","  +  " " + (" De Recuperação."));
        } 
        else {
            System.out.println( (media));
            System.out.println( (aluno3)+ ","  +  " " + ("Reprovado."));
        }
    }
}


