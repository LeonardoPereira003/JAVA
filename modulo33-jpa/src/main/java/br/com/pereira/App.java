package br.com.pereira;

import br.com.pereira.domain.*;
import br.com.pereira.util.JPAUtil;

import jakarta.persistence.EntityManager;
import java.util.Arrays;

/**
 * Classe principal para testar a persistência das entidades.
 */
public class App {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            // Criando Marca
            Marca marca = new Marca();
            marca.setNome("Toyota");

            // Criando Acessórios
            Acessorio som = new Acessorio();
            som.setNome("Som Premium");

            Acessorio multimidia = new Acessorio();
            multimidia.setNome("Multimídia 10 polegadas");

            // Persistindo acessórios primeiro
            em.persist(som);
            em.persist(multimidia);

            // Criando Documento
            Documento documento = new Documento();
            documento.setNumeroChassi("ABC123456789");

            // Criando Carro
            Carro carro = new Carro();
            carro.setModelo("Corolla");
            carro.setAno(2024);
            carro.setMarca(marca);
            carro.setDocumento(documento);
            carro.setAcessorios(Arrays.asList(som, multimidia));

            // Persistindo Marca
            em.persist(marca);

            // Persistindo Carro (Documento vai junto por causa do Cascade)
            em.persist(carro);

            em.getTransaction().commit();

            System.out.println("🚗 Carro salvo com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}