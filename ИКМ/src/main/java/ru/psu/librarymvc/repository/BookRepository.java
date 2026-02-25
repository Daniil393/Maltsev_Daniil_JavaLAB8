package ru.psu.librarymvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psu.librarymvc.entity.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

    // Проверка уникальности по title + author
    boolean existsByTitleAndAuthor_Id(String title, Integer authorId);

    // Безопасный поиск книги по title + author
    Optional<Book> findByTitleAndAuthor_Id(String title, Integer authorId);

    Optional<Book> findByTitleAndAuthor_IdAndPublisher_Id(
            String title,
            Integer authorId,
            Integer publisherId
    );
}