package br.com.pereira.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Classe utilitária responsável por criar e gerenciar
 * o EntityManager da aplicação.
 */
public class JPAUtil {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("modulo33-jpa");

    /**
     * Retorna uma instância de EntityManager.
     *
     * @return EntityManager
     */
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}