package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Movie movie = new Movie();
            movie.setDirector("a");
            movie.setActor("bbbbb");
            movie.setName("바람과 함께사리지다");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println("findMovie = "+findMovie);

            tx.commit();
        }catch(Exception e) {
            System.out.println(e.getMessage());
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}