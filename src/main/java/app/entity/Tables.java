package app.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table(name = "tables")
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int seats;

    @Column
    private String location;

    @Column(nullable = false)
    private boolean availability;

    @Column(length = 50)
    private String type;

    @Column(name = "minimum_order")
    private BigDecimal minimumOrder;

    @Column
    private String image;
}