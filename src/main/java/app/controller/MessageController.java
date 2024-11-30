package app.controller;

import app.dto.MessageDTO;
import app.dto.ReservationDTO;
import app.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    // Конструктор для інжекції залежностей
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // Створення нового повідомлення
    @PostMapping
    public MessageDTO createMessage(@RequestBody MessageDTO messageDTO) {
        return messageService.saveMessage(messageDTO);
    }

    // Отримання повідомлення за ID
    @GetMapping("/{id}")
    public MessageDTO getMessage(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    @GetMapping
    public List<MessageDTO> getAllReservations() {
        return messageService.getAllMessages();
    }

}
