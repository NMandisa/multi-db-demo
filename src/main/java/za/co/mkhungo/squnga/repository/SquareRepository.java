package za.co.mkhungo.squnga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mkhungo.squnga.entity.Square;

/**
 * @author Noxolo.Mkhungo
 */
public interface SquareRepository extends JpaRepository<Square,Long> {
}
