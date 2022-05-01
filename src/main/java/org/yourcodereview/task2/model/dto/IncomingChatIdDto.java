package org.yourcodereview.task2.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Входящий ID чата.
 */
@Data
@NoArgsConstructor
public class IncomingChatIdDto {

    /**
     * ID чата
     */
    @NonNull
    private Long chat;
}
