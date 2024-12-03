package app.dto;

import lombok.Data;
import java.util.List;

@Data
public class RestaurantDTO {
    private Long id;
    private String name;
    private String address;
    private String typeWork;


//    private List<TableDTO> tables; // додано зв'язок
}
