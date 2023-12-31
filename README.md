# Приложение “Облачное хранилище”

# Описание проекта
Задача — разработать REST-сервис. Сервис должен предоставить REST-интерфейс для загрузки файлов и вывода списка уже загруженных файлов пользователя.
Все запросы к сервису должны быть авторизованы. Заранее подготовленное веб-приложение (FRONT) должно подключаться к разработанному сервису без доработок, а также использовать функционал FRONT для авторизации, загрузки и вывода списка файлов пользователя.

# Описание реализации
- Версия Java: 17;
- Приложение разработано с использованием Spring Boot;
- Использован сборщик пакетов Maven;
- Для запуска используется Docker, Docker-Compose.

Данное приложение является сервером, позволяющим пользователям работать с файлами, а именно:
- загружать файлы;
- получать файлы по имени;
- переименовывать файлы;
- удалять файлы;
- просматривать список файлов.

Для работы с файлами пользователь должен залогиниться, чтобы получить идентификационный токен. Этот токен будет передаваться в заголовках во всех последующих запросах.

Информация о файлах, пользователях, а также токенах авторизованных пользователей хранится в БД. Для работы с БД используется СУБД PostgreSQL.

# Пользователи: 
1. login: netology@mail.ru, password: qweasdzxc;
2. login: netology1@mail.ru, password: qweasdzxc.


# Запуск программы

Front доступен по ссылке: http://localhost:8080.

Back доступен по ссылке: http://localhost:8091.

Команда запуска: docker-compose up

