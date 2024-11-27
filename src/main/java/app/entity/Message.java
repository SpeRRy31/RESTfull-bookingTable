package app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mes")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String message;

}
