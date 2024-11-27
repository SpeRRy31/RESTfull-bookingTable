package app.controller;

import app.entity.Message;
import app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // Отримати всі повідомлення
    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    // Отримати повідомлення за id
    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        Optional<Message> message = messageService.getMessageById(id);
        return message.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Створити нове повідомлення
    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message createdMessage = messageService.createMessage(message);
        return ResponseEntity.ok(createdMessage);
    }

    // Оновити повідомлення
    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(
            @PathVariable Long id,
            @RequestBody Message messageDetails) {
        Message updatedMessage = messageService.updateMessage(id, messageDetails);
        return ResponseEntity.ok(updatedMessage);
    }

    // Видалити повідомлення
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
