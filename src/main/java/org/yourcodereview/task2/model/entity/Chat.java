package org.yourcodereview.task2.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Отдельный чат.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "chats")
public class Chat {

    /**
     * уникальный идентификатор чата
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * уникальное имя чата
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * список пользователей в чате, отношение многие-ко-многим
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_chats",
            joinColumns = @JoinColumn(name = "chat_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private List<User> users;
}
