package jtech.thirdTask;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RequiredArgsConstructor
public class DetailRepository {

    private final EntityManagerFactory entityManagerFactory;

    public void save(Detail detail) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(detail);
        em.getTransaction().commit();
        em.close();
    }
}
