package app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "tables")
@Data
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer seats;

    private String location;

    private Boolean availability;

    private String type;

    @Column(name = "minimum_order")
    private Double minimumOrder;

    private String image;
}
