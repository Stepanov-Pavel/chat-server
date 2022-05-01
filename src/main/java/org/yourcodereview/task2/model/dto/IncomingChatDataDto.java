package org.yourcodereview.task2.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

/**
 * Данные для создания нового чата
 */
@Data
@NoArgsConstructor
public class IncomingChatDataDto {

    /**
     * Название чата
     */
    @NonNull
    private String name;

    /**
     * Идентификаторы пользователей чата
     */
    @NonNull
    private List<Long> users;
}
