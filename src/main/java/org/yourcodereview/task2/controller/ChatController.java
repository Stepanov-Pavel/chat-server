package org.yourcodereview.task2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yourcodereview.task2.model.dto.IncomingChatDataDto;
import org.yourcodereview.task2.model.dto.IncomingUserIdDto;
import org.yourcodereview.task2.model.entity.Chat;
import org.yourcodereview.task2.service.ChatService;

import java.util.Set;

@RestController
@RequestMapping("/chats")
@AllArgsConstructor
public class ChatController {

    private final ChatService chatService;

    /**
     * Создать новый чат между пользователями. Количество пользователей в чате не ограничено.
     *
     * @param incomingChatDataDto Данные для создания нового чата (название чата и перечень пользователей)
     * @return id созданного чата
     */
    @PostMapping("/add")
    public ResponseEntity<Long> makeChat(@RequestBody IncomingChatDataDto incomingChatDataDto) {
        return ResponseEntity.ok(chatService.createChat(incomingChatDataDto));
    }

    /**
     * Получить список чатов конкретного пользователя
     *
     * @param incomingUserIdDto Входящий ID пользователя
     * @return список всех чатов со всеми полями, отсортированный по времени создания последнего сообщения в чате (от позднего к раннему)
     */
    @PostMapping("/get")
    public ResponseEntity<Set<Chat>> takeChats(@RequestBody IncomingUserIdDto incomingUserIdDto) {
        return ResponseEntity.ok(chatService.getChats(incomingUserIdDto.getUser()));
    }
}
