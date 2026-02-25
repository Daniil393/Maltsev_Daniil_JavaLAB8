package ru.psu.librarymvc.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.time.LocalDate;
import jakarta.validation.constraints.Pattern;

import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import ru.psu.librarymvc.entity.Book;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true)
    @NotBlank(message = "Имя автора обязательно")
    @Pattern(
            regexp = "^[A-Za-zА-Яа-яЁё\\s\\-]+$",
            message = "Имя автора может содержать только буквы"
    )
    private String name;

    @Column(name = "birth_date")
    @NotNull(message = "Дата рождения автора обязательна")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            this.name = name;
            return;
        }

        name = name.trim().replaceAll("\\s+", " ");

        StringBuilder result = new StringBuilder();
        for (String part : name.split(" ")) {
            if (!part.isBlank()) {
                String normalized = part.substring(0, 1).toUpperCase() + part.substring(1).toLowerCase();
                result.append(normalized).append(" ");
            }
        }
        this.name = result.toString().trim();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}