package za.co.squnga.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author Noxolo.Mkhungo
 */
@Setter
@Getter
@RequiredArgsConstructor
@MappedSuperclass
public abstract class Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shape_generator")
    @SequenceGenerator(name = "shape_generator", sequenceName = "sequence_shape_id", allocationSize = 1)
    @Column(name = "shape_id")
    private Long shapeId;

    public abstract Shape getShape(Shape shape);
}
