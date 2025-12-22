# Итоговая работа по дисциплине "Язык программирования Java". ИКНТ, Мальцев Даниил ИТ18 - группа LAB8.

<img width="1920" height="1037" alt="image" src="https://github.com/user-attachments/assets/8c7799d4-044c-42e8-9165-6e7ba6a1962b" />

Проект представляет из себя Spring Boot Web MVC приложение для управления виртуальной библиотекой с 3 таблицами БД (postgreSQL).

## Функциональность
   - Просмотр списка книг - таблица с колонками: ID; Название; Автор; Издательство; Год публикации.
   - Добавление книги - форма с полями: название, автор, издательство, год публикации; Также удаление и редактирование книг.
   - Просмотр списка авторов, добавление, редактирование и удаление.
   - Просмотр списка издательств, добавление, редактирование и удаление.

## Структура проекта
```
src/
├── main/
│   ├── java/ru/psu/librarymvc/
│   │   ├── AlbumManagerApplication.java    # главный класс
│   │   ├── controller/
│   │   │   ├── AuthorController.java       # контроллер авторов
│   │   │   ├── PublisherController.java    # контроллер издательств
│   │   │   ├── HomeController.java         # контроллер главной страницы
│   │   │   └── BookController.java         # контроллер книг
│   │   ├── entity/
│   │   │   ├── Author.java                 # класс с сущностью автора
│   │   │   ├── Book.java                   # класс с сущностью книги
│   │   │   └── Publisher.java              # класс с сущностью издательства
│   │   └── repository/
│   │       ├── AuthorRepository.java       # репозиторий для работы с БД
│   │       ├── BookRepository.java         # репозиторий для работы с БД
│   │       └── PublisherRepository.java    # репозиторий для работы с БД
│   │   
│   │       
│   └── resources/
│       ├── static
│       │   
│       ├── templates/authors/
│       │   ├── list.html                   
│       │   └── form.html                   
│       │
│       ├── templates/home_page/                 
│       │   └── index.html
│       │
│       ├── templates/books/
│       │   ├── list.html                   
│       │   └── form.html
│       │
│       ├── templates/publishers/
│       │   ├── list.html                   
│       │   └── form.html
│       │
│       └── application.properties          # конфигурация
```
