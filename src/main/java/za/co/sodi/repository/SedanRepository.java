package za.co.sodi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.sodi.entity.Sedan;

/**
 * @author Noxolo.Mkhungo
 */
@Repository
public interface SedanRepository extends CrudRepository<Sedan,Long> {
}
