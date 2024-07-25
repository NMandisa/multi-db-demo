package za.co.mkhungo.squnga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.mkhungo.squnga.entity.Rectangle;

/**
 * @author Noxolo.Mkhungo
 */
public interface RectangleRepository extends JpaRepository<Rectangle,Long> {
}
