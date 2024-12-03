package app.mapper;

import app.dto.RestaurantDTO;
import app.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDTO toDto(Restaurant restaurant);

    Restaurant toEntity(RestaurantDTO restaurantDTO);
}
