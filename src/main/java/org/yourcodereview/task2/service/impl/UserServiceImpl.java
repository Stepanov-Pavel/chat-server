package org.yourcodereview.task2.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.yourcodereview.task2.exception.CreateUserException;
import org.yourcodereview.task2.model.entity.User;
import org.yourcodereview.task2.repository.UserRepository;
import org.yourcodereview.task2.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * Создание нового пользователя
     * @param username Имя нового пользователя
     * @return id нового пользователя сохраненного в БД
     */
    @Override
    public Long createUser(String username) {
        User incomingUser = new User();
        incomingUser.setUsername(username);

        User savedUser;
        try {
            savedUser = userRepository.save(incomingUser);
        } catch (DataIntegrityViolationException e) {
            throw new CreateUserException(e.getCause().getCause().getMessage());
        }

        return savedUser.getId();
    }
}
