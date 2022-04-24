package org.yourcodereview.task2.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Данные для создания нового сообщения
 */
@Data
@NoArgsConstructor
public class IncomingMessageDataDto {

    /**
     * ID чата
     */
    @NonNull
    private Long chat;

    /**
     * ID Пользователя чата
     */
    @NonNull
    private Long author;

    /**
     * Текст сообщения
     */
    private String text;
}
