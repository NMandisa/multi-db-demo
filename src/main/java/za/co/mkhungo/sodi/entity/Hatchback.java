package za.co.mkhungo.sodi.entity;

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
@Table(schema = "multi_db2")
@DiscriminatorValue("hatchback_car")
public class Hatchback extends Car {
    @Override
    public Car getCar(Car car) {
        return car;
    }
}
