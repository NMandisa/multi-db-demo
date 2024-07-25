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
@DiscriminatorValue("sedan_car")
public class Sedan extends Car{
    @Override
    public Car getCar(Car car) {
        return car;
    }
}
