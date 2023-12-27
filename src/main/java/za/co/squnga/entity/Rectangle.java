package za.co.squnga.entity;

import jakarta.persistence.Entity;
import lombok.*;

/**
 * @author Noxolo.Mkhungo
 */
@Setter
@Getter
@RequiredArgsConstructor
@Entity
public class Rectangle extends Shape {
    @Override
    public Shape getShape(Shape shape) {
        return shape;
    }
}
