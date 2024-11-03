package za.co.mkhungo.sodi.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import za.co.mkhungo.sodi.entity.Hatchback;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
/**
 * @author Noxolo.Mkhungo
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:META-INF/application-context.xml"})
class HatchbackRepositoryTests {

    @Autowired
    private HatchbackRepository hatchbackRepository;
    private Hatchback hatchback;

    @BeforeEach
    void setUp() {
        hatchback = new Hatchback();
    }

    @Test
    void testSaveHatchback() {
        Hatchback savedHatchback = hatchbackRepository.save(hatchback);
        assertNotNull(savedHatchback); assertNotNull(savedHatchback.getCarId());
    }

    @Test
    void testFindById() {
        hatchbackRepository.save(hatchback);
        Hatchback foundHatchback = hatchbackRepository.findById(hatchback.getCarId()).orElse(null);
        assertNotNull(foundHatchback); assertEquals(hatchback.getCarId(), foundHatchback.getCarId());
    }
}
