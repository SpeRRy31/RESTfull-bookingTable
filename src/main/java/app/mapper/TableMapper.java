package app.mapper;

import app.dto.TableDTO;
import app.entity.Table;
import org.springframework.stereotype.Component;

@Component
public class TableMapper {

    // Перетворення з Entity у DTO
    public TableDTO toDTO(Table table) {
        TableDTO dto = new TableDTO();
        dto.setId(table.getId());
        dto.setSeats(table.getSeats());
        dto.setLocation(table.getLocation());
        dto.setAvailability(table.getAvailability());
        dto.setType(table.getType());
        dto.setMinimumOrder(table.getMinimumOrder());
        dto.setImage(table.getImage());
        return dto;
    }

    // Перетворення з DTO у Entity
    public Table toEntity(TableDTO dto) {
        Table table = new Table();
        table.setId(dto.getId());
        table.setSeats(dto.getSeats());
        table.setLocation(dto.getLocation());
        table.setAvailability(dto.getAvailability());
        table.setType(dto.getType());
        table.setMinimumOrder(dto.getMinimumOrder());
        table.setImage(dto.getImage());
        return table;
    }
}
