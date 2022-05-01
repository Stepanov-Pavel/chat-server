package org.yourcodereview.task2.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.yourcodereview.task2.exception.CreateMessageException;
import org.yourcodereview.task2.model.dto.IncomingMessageDataDto;
import org.yourcodereview.task2.model.entity.Chat;
import org.yourcodereview.task2.model.entity.Message;
import org.yourcodereview.task2.model.entity.User;
import org.yourcodereview.task2.repository.ChatRepository;
import org.yourcodereview.task2.repository.MessageRepository;
import org.yourcodereview.task2.repository.UserRepository;
import org.yourcodereview.task2.service.MessageService;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;

    /**
     * Создание нового сообщения
     *
     * @param incomingMessageDataDto Данные для создания нового сообщения (чат и автор сообщения и текст сообщения)
     * @return id созданного сообщения
     */
    @Override
    public Long createMessage(IncomingMessageDataDto incomingMessageDataDto) {
        Message incomingMessage = new Message();

        Chat chatForIncomingMessage = chatRepository.findById(incomingMessageDataDto.getChat())
                .orElseThrow(() -> new CreateMessageException("ОШИБКА: Чата с ID: " + incomingMessageDataDto.getChat() + " не существует!"));

        User userForIncomingMessage = chatForIncomingMessage.getUsers().stream()
                .filter(user -> user.getId().equals(incomingMessageDataDto.getAuthor()))
                .findAny()
                .orElseThrow(() -> new CreateMessageException("ОШИБКА: Пользователя с ID: " + incomingMessageDataDto.getAuthor()
                        + " не является участником чата с ID: " + incomingMessageDataDto.getChat() + "!"));

        incomingMessage.setAuthor(userForIncomingMessage);
        incomingMessage.setChat(chatForIncomingMessage);
        incomingMessage.setText(incomingMessageDataDto.getText());

        Message savedMessage = messageRepository.save(incomingMessage);

        return savedMessage.getId();
    }

    /**
     * Взять список сообщений в конкретном чате
     *
     * @param chatId ID чата
     * @return список всех сообщений чата со всеми полями, отсортированный по времени создания сообщения (от раннего к позднему)
     */
    @Override
    public List<Message> getMessages(Long chatId) {
        List<Message> result = messageRepository.findAllByChatIdOrderByCreatedAtDesc(chatId);

        if (result.isEmpty()) {
            throw new CreateMessageException("ОШИБКА: Для чата с ID: " + chatId + " не найдено сообщений!");
        }

        return result;
    }
}
