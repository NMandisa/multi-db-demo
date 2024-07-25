package za.co.mkhungo.sodi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mkhungo.sodi.entity.Sedan;

/**
 * @author Noxolo.Mkhungo
 */

public interface SedanRepository extends JpaRepository<Sedan,Long> {
}
