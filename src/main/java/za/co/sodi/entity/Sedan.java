package za.co.sodi.entity;

import jakarta.persistence.Entity;
import lombok.*;

/**
 * @author Noxolo.Mkhungo
 */
@Setter
@Getter
@RequiredArgsConstructor
@Entity
public class Sedan extends Car{
    @Override
    public Car getCar(Car car) {
        return car;
    }
}
