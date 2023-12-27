package za.co.sodi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.sodi.entity.Hatchback;

/**
 * @author Noxolo.Mkhungo
 */
@Repository
public interface HatchbackRepository extends CrudRepository<Hatchback,Long> {
}
