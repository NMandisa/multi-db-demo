package za.co.sodi.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Noxolo.Mkhungo
 */
@Setter
@Getter
@RequiredArgsConstructor
@MappedSuperclass
public abstract class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_generator")
    @SequenceGenerator(name = "car_generator", sequenceName = "sequence_car_id", allocationSize = 1)
    @Column(name = "car_id")
    private Long carId;

    public abstract Car getCar(Car car);
}
