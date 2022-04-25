package org.yourcodereview.task2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yourcodereview.task2.exception.CreateChatException;
import org.yourcodereview.task2.exception.CreateMessageException;
import org.yourcodereview.task2.exception.CreateUserException;
import org.yourcodereview.task2.model.dto.ExceptionMessageDto;

@RestControllerAdvice
public class ExceptionHandlerController {

    /**
     * Обработчик исключений при создании Юзера
     *
     * @param exception CreateUserException
     * @return HTTP-код ошибки + описание ошибки
     */
    @ExceptionHandler(CreateUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionMessageDto getMessageFromCreateUserException(CreateUserException exception) {
        return new ExceptionMessageDto(exception.getMessage());
    }

    /**
     * Обработчик исключений при создании Чата
     *
     * @param exception CreateChatException
     * @return HTTP-код ошибки + описание ошибки
     */
    @ExceptionHandler(CreateChatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionMessageDto getMessageFromCreateChatException(CreateChatException exception) {
        return new ExceptionMessageDto(exception.getMessage());
    }

    /**
     * Обработчик исключений при создании Сообщения
     *
     * @param exception CreateMessageException
     * @return HTTP-код ошибки + описание ошибки
     */
    @ExceptionHandler(CreateMessageException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionMessageDto getMessageFromCreateChatException(CreateMessageException exception) {
        return new ExceptionMessageDto(exception.getMessage());
    }
}
