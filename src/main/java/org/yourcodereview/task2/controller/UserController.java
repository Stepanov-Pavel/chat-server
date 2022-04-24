package org.yourcodereview.task2.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yourcodereview.task2.model.dto.IncomingUserDataDto;
import org.yourcodereview.task2.service.UserService;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Добавить нового пользователя
     *
     * @param incomingUserDataDto Имя входящего пользователя
     * @return id созданного пользователя
     */
    @PostMapping("/add")
    public ResponseEntity<Long> makeUser(@RequestBody IncomingUserDataDto incomingUserDataDto) {
        return ResponseEntity.ok(userService.createUser(incomingUserDataDto.getUsername()));
    }
}
