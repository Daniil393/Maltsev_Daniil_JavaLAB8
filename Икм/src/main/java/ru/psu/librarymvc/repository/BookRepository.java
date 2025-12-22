package ru.psu.librarymvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psu.librarymvc.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}