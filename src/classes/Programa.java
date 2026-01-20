package classes;

import classes.abs.Pessoa;
import classes.conc.pfisica.Pfisica;
import classes.conc.pjuridica.Pjuridica;

/**
 * Classe principal do sistema.
 * 
 * Responsável por instanciar os objetos
 * e executar o programa.
 */
public class Programa {

    public static void main(String[] args) {

        // ================= PESSOA FÍSICA =================
        Pessoa pf = new Pfisica();
        pf.setNome("Leonardo");
        pf.setIdade(22);
        pf.setEtnia("Pardo");

        Pfisica pfisica = (Pfisica) pf;
        pfisica.setCpf(123456789L);
        pfisica.setValeTransporte(245.0d);
        pfisica.setValeAlimentacao(500.0);
        pfisica.setHorasTrabalhadas(160.0d);

        // ================= PESSOA JURÍDICA =================
        Pessoa pj = new Pjuridica();
        pj.setNome("Empresa X");
        pj.setEtnia("Privada");

        Pjuridica pjuridica = (Pjuridica) pj;
        pjuridica.setCnpj(55555555555555L);
        pjuridica.setCustosOperacionais(10000.0);
        pjuridica.setControleRotina("Segunda: Produção");

        // Impressão dos dados
        pf.imprimir();
        System.out.println();
        pj.imprimir();
    }
}
