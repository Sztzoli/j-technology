package jtech.thirdTask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MasterRepositoryIT {

    MasterRepository masterRepository;
    DetailRepository detailRepository;

    @BeforeEach
    void setUp() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
        masterRepository = new MasterRepository(factory);
        detailRepository = new DetailRepository(factory);
    }

    @Test
    void test() {
        Master master = new Master(LocalDate.now(), "at1", "at2", "at3");
        masterRepository.save(master);
        detailRepository.save(new Detail((byte) 1, "dat1", "dat2", "dat3", master));
        detailRepository.save(new Detail((byte) 1, "dat1", "dat2", "dat3", master));
        detailRepository.save(new Detail((byte) 1, "dat1", "dat2", "dat3", master));
        detailRepository.save(new Detail((byte) 0, "dat1", "dat2", "dat3", master));
        detailRepository.save(new Detail((byte) 0, "dat1", "dat2", "dat3", master));
        Master master2 = new Master(LocalDate.now().minusDays(60), "at1_2", "at2_2", "at3_2");
        masterRepository.save(master2);
        detailRepository.save(new Detail((byte) 1, "dat1", "dat2", "dat3", master2));
        detailRepository.save(new Detail((byte) 1, "dat1", "dat2", "dat3", master2));
        detailRepository.save(new Detail((byte) 1, "dat1", "dat2", "dat3", master2));
        detailRepository.save(new Detail((byte) 1, "dat1", "dat2", "dat3", master2));
        detailRepository.save(new Detail((byte) 0, "dat1", "dat2", "dat3", master2));

        List<Object[]> result = masterRepository.getSelect();

        System.out.println(Arrays.toString(result.get(0)));
        assertEquals(master.getId(), result.get(0)[0]);
        assertEquals(master2.getId(), result.get(1)[0]);
        assertEquals(LocalDate.now(), result.get(0)[1]);
        assertEquals(LocalDate.now().minusDays(60), result.get(1)[1]);
        assertEquals("at2", result.get(0)[2]);
        assertEquals("at2_2", result.get(1)[2]);
        assertEquals(2L, result.get(0)[3]);
        assertEquals(1L, result.get(1)[3]);
        assertEquals(3L, result.get(0)[4]);
        assertEquals(4L, result.get(1)[4]);

    }

    @Test
    void olderThan100Days() {
        Master master = new Master(LocalDate.now(), "at1", "at2", "at3");
        masterRepository.save(master);
        detailRepository.save(new Detail((byte) 1, "dat1", "dat2", "dat3", master));
        detailRepository.save(new Detail((byte) 1, "dat1", "dat2", "dat3", master));
        detailRepository.save(new Detail((byte) 1, "dat1", "dat2", "dat3", master));
        detailRepository.save(new Detail((byte) 0, "dat1", "dat2", "dat3", master));
        detailRepository.save(new Detail((byte) 0, "dat1", "dat2", "dat3", master));
        Master master2 = new Master(LocalDate.now().minusDays(100), "at1_2", "at2_2", "at3_2");
        masterRepository.save(master2);
        detailRepository.save(new Detail((byte) 1, "dat1", "dat2", "dat3", master2));
        detailRepository.save(new Detail((byte) 1, "dat1", "dat2", "dat3", master2));
        detailRepository.save(new Detail((byte) 1, "dat1", "dat2", "dat3", master2));
        detailRepository.save(new Detail((byte) 1, "dat1", "dat2", "dat3", master2));
        detailRepository.save(new Detail((byte) 0, "dat1", "dat2", "dat3", master2));

        List<Object[]> result = masterRepository.getSelect();

        assertEquals(1,result.size());
    }
}