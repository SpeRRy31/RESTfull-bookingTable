package app.mapper;

import app.dto.UserDTO;
import app.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "reservations", target = "reservations")
    UserDTO toDTO(User user);

    @Mapping(source = "reservations", target = "reservations")
    User toEntity(UserDTO userDTO);
}
