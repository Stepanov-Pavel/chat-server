package org.yourcodereview.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yourcodereview.task2.model.entity.Chat;

import java.util.Set;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    /**
     * Запрос на выборку списка чатов конкретного пользователя со всеми полями, отсортированный по времени создания последнего сообщения в чате (от позднего к раннему)
     *
     * @param userId ID пользователя
     * @return список всех чатов со всеми полями, отсортированный по времени создания последнего сообщения в чате (от позднего к раннему)
     */
    @Query("FROM Chat ch\n" +
            "LEFT JOIN Message ms ON ms.chat.id = ch.id\n" +
            "WHERE ms.author.id = :userId\n" +
            "ORDER BY ms.createdAt DESC"
    )
    Set<Chat> findAllByAuthorMessageIdOrderByMessageCreatedAtDesc(@Param("userId") Long userId);
}
