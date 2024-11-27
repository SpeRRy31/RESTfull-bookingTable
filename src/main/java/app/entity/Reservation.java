package app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime reservationTime;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    // Зв'язок багато-до-одного з User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Зв'язок багато-до-одного з Table
    @ManyToOne
    @JoinColumn(name = "table_id", nullable = false)
    private Tables table;

    // Зв'язок багато-до-одного з Restaurant (ресторан, до якого належить стіл)
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}
