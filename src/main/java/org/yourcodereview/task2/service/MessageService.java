package org.yourcodereview.task2.service;

import org.yourcodereview.task2.model.dto.IncomingMessageDataDto;
import org.yourcodereview.task2.model.entity.Message;

import java.util.List;

public interface MessageService {
    Long createMessage(IncomingMessageDataDto incomingMessageDataDto);

    List<Message> getMessages(Long chatId);
}
