package app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@jakarta.persistence.Table(name = "mes")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String message;
}
