package jtech.thirdTask;

import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class MasterRepository {

    private final EntityManagerFactory entityManagerFactory;

    public void save(Master master) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(master);
        em.getTransaction().commit();
        em.close();
    }

    public List<Object[]> getSelect() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Object[]> result = em.createQuery("select m.id, m.created, m.attr2," +
                        " (select count(d.status) from m.details d where d.status = 0)," +
                        " (select count(d.status) from m.details d where d.status = 1)  " +
                        "from Master m where m.created> :date order by m.id",
                Object[].class)
                .setParameter("date", LocalDate.now().minusDays(100))
                .getResultList();
        em.close();
        return result;
    }
}
