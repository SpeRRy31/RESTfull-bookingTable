package app.mapper;

import app.dto.TableDTO;
import app.entity.Table;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TableMapper {

    TableMapper INSTANCE = Mappers.getMapper(TableMapper.class);

    TableDTO toDto(Table table);

    Table toEntity(TableDTO tableDTO);
}
