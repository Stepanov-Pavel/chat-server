package org.yourcodereview.task2.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Пользователь приложения.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "users")
@ToString(of = "id")
public class User {

    /**
     * уникальный идентификатор пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * уникальное имя пользователя
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * время создания пользователя
     */
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
