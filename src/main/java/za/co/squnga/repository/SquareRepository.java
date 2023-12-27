package za.co.squnga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.co.squnga.entity.Circle;

/**
 * @author Noxolo.Mkhungo
 */
@Repository
public interface SquareRepository extends CrudRepository<Circle,Long> {
}
