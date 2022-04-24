package org.yourcodereview.task2.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Сообщение в чате.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "messages")
public class Message {

    /**
     * уникальный идентификатор сообщения
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ссылка на идентификатор чата, в который было отправлено сообщение
     */
    @ManyToOne
    private Chat chat;

    /**
     * ссылка на идентификатор отправителя сообщения, отношение многие-к-одному
     */
    @ManyToOne
    private User author;

    /**
     * текст отправленного сообщения
     */
    @Column(length = 1000)
    private String text;

    /**
     * время создания
     */
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
