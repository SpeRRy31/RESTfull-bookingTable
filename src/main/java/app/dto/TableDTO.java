package app.dto;

import lombok.Data;

@Data
public class TableDTO {
    private Long id;
    private Integer seats;
    private String location;
    private Boolean availability;
    private String type;
    private Double minimumOrder;
    private String image;
}
