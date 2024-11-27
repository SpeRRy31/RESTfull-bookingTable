package app.service;

import app.entity.Message;
import app.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // Отримати всі повідомлення
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    // Отримати повідомлення за id
    public Optional<Message> getMessageById(Long id) {
        return messageRepository.findById(id);
    }

    // Створити нове повідомлення
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    // Оновити повідомлення
    public Message updateMessage(Long id, Message messageDetails) {
        Message message = messageRepository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));

        message.setName(messageDetails.getName());
        message.setEmail(messageDetails.getEmail());
        message.setMessage(messageDetails.getMessage());

        return messageRepository.save(message);
    }

    // Видалити повідомлення
    public void deleteMessage(Long id) {
        Message message = messageRepository.findById(id).orElseThrow(() -> new RuntimeException("Message not found"));
        messageRepository.delete(message);
    }
}
