package app.mapper;

import app.dto.MessageDTO;
import app.entity.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {

    // Перетворення з Entity у DTO
    public static MessageDTO toDTO(Message message) {
        if (message == null) {
            return null;
        }

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setName(message.getName());
        messageDTO.setEmail(message.getEmail());
        messageDTO.setMessage(message.getMessage());
        return messageDTO;
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
