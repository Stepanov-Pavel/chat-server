Разработан chat-server (msg-backend), предоставляющий HTTP API для работы с чатами и сообщениями пользователя.

Детали реализации:
 - Код написан ан Java 11.
 - В качестве хранилища данных можно использован PostgreSQL 12.
 - В качестве ORM использован Hibernate 5.
 - При перезапуске сервера добавленные данные сохраняются.
 - Сервер доступен на порту 9000.

Инструкция по запуску приложения:
Необходимо иметь локально установленный сервер PostgreSQL на порту 5432. Имя базы данных на сервере БД долно быть **chat_server**. Логин: postgres. Пароль: postgres.

Реализованы следующие API методы обрабатывающие HTTP POST запросы c телом, содержащим все необходимые параметры в JSON:
**Добавление нового пользователя**
Запрос:
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"username": "user_1"}' \
  http://localhost:9000/users/add
Ответ: id созданного пользователя.


**Создание нового чата между пользователями**
Количество пользователей в чате не ограничено.
Запрос:
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"name": "chat_1", "users": ["<USER_ID_1>", "<USER_ID_2>"]}' \
  http://localhost:9000/chats/add
Ответ: id созданного чата или HTTP-код ошибки или HTTP-код ошибки + описание ошибки.


**Отправка сообщения в чат от лица пользователя**
Запрос:
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"chat": "<CHAT_ID>", "author": "<USER_ID>", "text": "hi"}' \
  http://localhost:9000/messages/add
Ответ: id созданного сообщения.


**Получить список чатов конкретного пользователя**
Запрос:
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"user": "<USER_ID>"}' \
  http://localhost:9000/chats/get
Ответ: cписок всех чатов со всеми полями, отсортированный по времени создания последнего сообщения в чате (от позднего к раннему).


**Получить список сообщений в конкретном чате**
Запрос:
curl --header "Content-Type: application/json" \
  --request POST \
  --data '{"chat": "<CHAT_ID>"}' \
  http://localhost:9000/messages/get
Ответ: список всех сообщений чата со всеми полями, отсортированный по времени создания сообщения (от раннего к позднему).
