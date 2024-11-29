package app.dto;

import lombok.Data;

@Data
public class MessageDTO {
    private Long id;
    private String name;
    private String email;
    private String message;
}
