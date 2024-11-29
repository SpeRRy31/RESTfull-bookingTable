package app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "reservations")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tables_id")
    private Long tableId;

    @Column(name = "user_id")
    private Long userId;

    private String name;

    private String phone;
}
