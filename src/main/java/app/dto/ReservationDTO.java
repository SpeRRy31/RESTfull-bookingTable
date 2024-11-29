package app.dto;

import lombok.Data;

@Data
public class ReservationDTO {
    private Long id;
    private Long tableId;
    private Long userId;
    private String name;
    private String phone;
}
