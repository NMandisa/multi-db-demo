package za.co.mkhungo.sodi.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Noxolo.Mkhungo
 */
@Setter
@Getter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING,name = "car_type")
public abstract class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_generator")
    @SequenceGenerator(name = "car_generator", sequenceName = "sequence_car_id", allocationSize = 1)
    @Column(name = "car_id")
    private Long carId;

    public abstract Car getCar(Car car);
}
