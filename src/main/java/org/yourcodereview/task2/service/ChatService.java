package org.yourcodereview.task2.service;

import org.yourcodereview.task2.model.dto.IncomingChatDataDto;
import org.yourcodereview.task2.model.entity.Chat;

import java.util.Set;

public interface ChatService {
    Long createChat(IncomingChatDataDto incomingChatDataDto);

    Set<Chat> getChats(Long userId);
}
