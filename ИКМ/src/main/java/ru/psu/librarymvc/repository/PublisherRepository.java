package ru.psu.librarymvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.psu.librarymvc.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    boolean existsByNameIgnoreCase(String name);
}