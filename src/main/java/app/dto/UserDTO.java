package app.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private Boolean isAdmin;
    private List<ReservationDTO> reservations;
}
