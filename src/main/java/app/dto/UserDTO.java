package app.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String password; // Пароль може бути хешованим
    private String phoneNumber;
    private Boolean isAdmin;
}
