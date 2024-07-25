package za.co.mkhungo.squnga.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Noxolo.Mkhungo
 */
@Setter
@Getter
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING,name = "shape_type")
public abstract class Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shape_generator")
    @SequenceGenerator(name = "shape_generator", sequenceName = "sequence_shape_id", allocationSize = 1)
    @Column(name = "shape_id")
    private Long shapeId;

    public abstract Shape getShape(Shape shape);
}
