package org.yourcodereview.task2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yourcodereview.task2.model.dto.IncomingChatIdDto;
import org.yourcodereview.task2.model.dto.IncomingMessageDataDto;
import org.yourcodereview.task2.model.entity.Message;
import org.yourcodereview.task2.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/messages")
@AllArgsConstructor
public class MessageController {

    private final MessageService messageService;

    /**
     * Отправить сообщение в чат от лица пользователя
     *
     * @param incomingMessageDataDto Данные для создания нового сообщения (чат и автор сообщения и текст сообщения)
     * @return id созданного сообщения
     */
    @PostMapping("/add")
    public ResponseEntity<Long> makeMessage(@RequestBody IncomingMessageDataDto incomingMessageDataDto) {
        return ResponseEntity.ok(messageService.createMessage(incomingMessageDataDto));
    }

    /**
     * Получить список сообщений в конкретном чате
     *
     * @param incomingChatIdDto Входящий ID чата
     * @return список всех сообщений чата со всеми полями, отсортированный по времени создания сообщения (от раннего к позднему)
     */
    @PostMapping("/get")
    public ResponseEntity<List<Message>> takeMessages(@RequestBody IncomingChatIdDto incomingChatIdDto) {
        return ResponseEntity.ok(messageService.getMessages(incomingChatIdDto.getChat()));
    }
}
