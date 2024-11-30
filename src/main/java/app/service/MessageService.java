package app.service;

import app.dto.MessageDTO;
import app.entity.Message;
import app.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    // Конструктор для інжекції залежностей
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // Метод для збереження повідомлення
    public MessageDTO saveMessage(MessageDTO messageDTO) {
        Message message = new Message();
        message.setName(messageDTO.getName());
        message.setEmail(messageDTO.getEmail());
        message.setMessage(messageDTO.getMessage());

        // Збереження повідомлення в базі даних
        message = messageRepository.save(message);

        // Повертаємо DTO з id
        messageDTO.setId(message.getId());
        return messageDTO;
    }


    // Метод для отримання повідомлення за ID
    public MessageDTO getMessageById(Long id) {
        Message message = messageRepository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setName(message.getName());
        messageDTO.setEmail(message.getEmail());
        messageDTO.setMessage(message.getMessage());
        return messageDTO;
    }
}
