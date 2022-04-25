package org.yourcodereview.task2.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.yourcodereview.task2.exception.CreateChatException;
import org.yourcodereview.task2.model.dto.IncomingChatDataDto;
import org.yourcodereview.task2.model.entity.Chat;
import org.yourcodereview.task2.model.entity.User;
import org.yourcodereview.task2.repository.ChatRepository;
import org.yourcodereview.task2.repository.UserRepository;
import org.yourcodereview.task2.service.ChatService;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    /**
     * Создание нового чата
     *
     * @param incomingChatDataDto Данные для создания нового чата (название чата и перечень пользователей)
     * @return id созданного чата
     */
    @Override
    public Long createChat(IncomingChatDataDto incomingChatDataDto) {
        Chat newChat = new Chat();

        if (incomingChatDataDto.getUsers().isEmpty()) {
            throw new CreateChatException("ОШИБКА: Нельзя просто взять и создать чат без пользователей!");
        }

        List<User> allUsersById = userRepository.findAllById(incomingChatDataDto.getUsers());

        if (allUsersById.size() != incomingChatDataDto.getUsers().size()) {
            throw new CreateChatException("ОШИБКА: Не все пользователи из: " + incomingChatDataDto.getUsers().toString() + " были найдены в БД! " +
                    "Пользователи которых удалось найти в БД: " + allUsersById.toString());
        }

        newChat.setName(incomingChatDataDto.getName());
        newChat.setUsers(allUsersById);

        Chat savedChat;
        try {
            savedChat = chatRepository.save(newChat);
        } catch (DataIntegrityViolationException e) {
            throw new CreateChatException(e.getCause().getCause().getMessage());
        }

        return savedChat.getId();
    }

    /**
     * Взять список чатов конкретного пользователя
     *
     * @param userId ID пользователя
     * @return список всех чатов со всеми полями, отсортированный по времени создания последнего сообщения в чате (от позднего к раннему)
     */
    @Override
    public Set<Chat> getChats(Long userId) {
        Set<Chat> result = chatRepository.findAllByAuthorMessageIdOrderByMessageCreatedAtDesc(userId);

        if (result.isEmpty()) {
            throw new CreateChatException("ОШИБКА: По пользователю с ID: " + userId + " не найдено чатов!");
        }

        return result;
    }
}
