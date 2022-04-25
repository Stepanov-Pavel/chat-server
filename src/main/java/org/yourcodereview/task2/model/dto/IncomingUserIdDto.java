package org.yourcodereview.task2.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Входящий ID пользователя.
 */
@Data
@NoArgsConstructor
public class IncomingUserIdDto {

    /**
     * ID пользователя
     */
    @NonNull
    private Long user;
}
