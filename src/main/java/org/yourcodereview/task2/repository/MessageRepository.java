package org.yourcodereview.task2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yourcodereview.task2.model.entity.Message;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    /**
     * Запрос на выборку списка всех сообщений чата со всеми полями, отсортированный по времени создания сообщения (от раннего к позднему)
     *
     * @param chatId ID чата
     * @return список всех сообщений чата со всеми полями, отсортированный по времени создания сообщения (от раннего к позднему)
     */
    List<Message> findAllByChatIdOrderByCreatedAtDesc(Long chatId);
}
