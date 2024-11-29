package app.mapper;

import app.dto.UserDTO;
import app.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Перетворення з Entity у DTO
    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword()); // Ви можете хешувати паролі перед поверненням
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setIsAdmin(user.getIsAdmin());
        return dto;
    }

    // Перетворення з DTO у Entity
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setIsAdmin(dto.getIsAdmin());
        return user;
    }
}
