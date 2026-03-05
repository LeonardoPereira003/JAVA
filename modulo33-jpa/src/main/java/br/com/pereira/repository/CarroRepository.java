package br.com.pereira.repository;

import br.com.pereira.domain.Carro;
import br.com.pereira.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class CarroRepository {

    public void salvar(Carro carro) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(carro);

            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
            throw e;

        } finally {
            em.close();
        }
    }
}