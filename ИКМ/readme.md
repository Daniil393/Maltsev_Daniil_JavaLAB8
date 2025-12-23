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
│   │   ├── AlbumManagerApplication.java   
│   │   ├── controller/
│   │   │   ├── AuthorController.java      
│   │   │   ├── PublisherController.java   
│   │   │   ├── HomeController.java         
│   │   │   └── BookController.java         
│   │   ├── entity/
│   │   │   ├── Author.java                
│   │   │   ├── Book.java                   
│   │   │   └── Publisher.java            
│   │   └── repository/
│   │       ├── AuthorRepository.java      
│   │       ├── BookRepository.java        
│   │       └── PublisherRepository.java    
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
│       └── application.properties         
```
