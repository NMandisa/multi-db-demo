package za.co.mkhungo.squnga.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

/**
 * @author Noxolo.Mkhungo
 */
@Setter
@Getter
@Entity
@DiscriminatorValue("square_shape")
@Table(schema = "multi_db")
public class Square extends Shape{
    @Override
    public Shape getShape(Shape shape) {
        return shape;
    }
}
