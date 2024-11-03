package za.co.mkhungo.sodi.repository;

import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.co.mkhungo.sodi.entity.Sedan; import javax.persistence.EntityManager;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Noxolo.Mkhungo
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-context.xml"})
class SedanRepositoryTests {

    @Autowired
    private SedanRepository sedanRepository;
    @PersistenceContext
    private EntityManager entityManager;
    private Sedan sedan;

    @BeforeEach void setUp() {
        sedan = new Sedan(); // Set any necessary properties for sedan
    }

    @Test
    void testSaveSedan() {
        Sedan savedSedan = sedanRepository.save(sedan);
        assertNotNull(savedSedan);
        assertNotNull(savedSedan.getCarId());
    }

    @Test
    void testFindById() {
        entityManager.persist(sedan);
        Optional<Sedan> foundSedan = sedanRepository.findById(sedan.getCarId());
        assertTrue(foundSedan.isPresent());
        assertEquals(sedan.getCarId(), foundSedan.get().getCarId());
    }
}