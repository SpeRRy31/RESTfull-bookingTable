package app.service;

import app.dto.MessageDTO;
import app.entity.Message;
import app.mapper.MessageMapper;
import app.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageService(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    // Отримати всі повідомлення
    public List<MessageDTO> getAllMessages() {
        return messageRepository.findAll()
                .stream()
                .map(messageMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Отримати повідомлення за ID
    public MessageDTO getMessageById(Long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Повідомлення не знайдено"));
        return messageMapper.toDTO(message);
    }

    // Додати нове повідомлення
    public MessageDTO createMessage(MessageDTO messageDTO) {
        Message message = messageMapper.toEntity(messageDTO);
        Message savedMessage = messageRepository.save(message);
        return messageMapper.toDTO(savedMessage);
    }

    // Видалити повідомлення
    public void deleteMessage(Long id) {
        if (!messageRepository.existsById(id)) {
            throw new RuntimeException("Повідомлення не знайдено");
        }
        messageRepository.deleteById(id);
    }
}
