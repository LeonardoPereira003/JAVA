    package br.com.pereira;

    import br.com.pereira.domain.Produto;
    import jakarta.persistence.EntityManager;
    import jakarta.persistence.EntityManagerFactory;
    import jakarta.persistence.Persistence;

    /**
     * Classe principal da aplicação.
     * Responsável por iniciar o Hibernate e salvar um Produto no banco.
     */
    public class App {

        public static void main(String[] args) {

            EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("produtoPU");

            EntityManager em = emf.createEntityManager();

            try {
                em.getTransaction().begin();

                Produto produto = new Produto("Notebook Gamer", 4500.00, 3);

                em.persist(produto);

                em.getTransaction().commit();

                System.out.println("Produto salvo com sucesso!");

            } catch (Exception e) {
                em.getTransaction().rollback();
                e.printStackTrace();
            } finally {
                em.close();
                emf.close();
            }
        }
    }