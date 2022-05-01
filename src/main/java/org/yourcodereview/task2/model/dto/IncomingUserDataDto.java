package org.yourcodereview.task2.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Входящий пользователь приложения.
 */
@Data
@NoArgsConstructor
public class IncomingUserDataDto {

    /**
     * Имя пользователя
     */
    @NonNull
    private String username;
}
