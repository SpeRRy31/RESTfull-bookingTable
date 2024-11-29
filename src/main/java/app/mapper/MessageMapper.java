package app.mapper;

import app.dto.MessageDTO;
import app.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    // Перетворення з Entity у DTO
    public MessageDTO toDTO(Message message) {
        MessageDTO dto = new MessageDTO();
        dto.setId(message.getId());
        dto.setName(message.getName());
        dto.setEmail(message.getEmail());
        dto.setMessage(message.getMessage());
        return dto;
    }

    // Перетворення з DTO у Entity
    public Message toEntity(MessageDTO dto) {
        Message message = new Message();
        message.setId(dto.getId());
        message.setName(dto.getName());
        message.setEmail(dto.getEmail());
        message.setMessage(dto.getMessage());
        return message;
    }
}
