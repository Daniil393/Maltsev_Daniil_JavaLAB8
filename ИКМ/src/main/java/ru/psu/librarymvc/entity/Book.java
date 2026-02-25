package ru.psu.librarymvc.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import ru.psu.librarymvc.validation.MaxCurrentYear;

import java.util.Objects;

@Entity
@Table(name = "books",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"title", "author_id", "publisher_id"})})
public class Book {

    @Column(name = "quantity")
    @Min(value = 0, message = "Количество книг не может быть отрицательным")
    @Max(value = 40, message = "В библиотеке зарегистрировано только 40 экземпляров каждой книги")
    private Integer quantity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Название книги обязательно")
    private String title;

    @NotNull(message = "Год публикации обязателен")
    @Min(value = 1000, message = "Некорректный год публикации")
    @MaxCurrentYear
    @Column(nullable = false)
    private Integer publicationYear;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @Transient
    private Integer authorId;

    @Transient
    private Integer publisherId;

    public Book() {
    }

    // --- getters and setters ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
        this.authorId = author != null ? author.getId() : null;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
        this.publisherId = publisher != null ? publisher.getId() : null;
    }

    public Integer getAuthorId() {
        if (authorId == null && author != null) {
            return author.getId();
        }
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getPublisherId() {
        if (publisherId == null && publisher != null) {
            return publisher.getId();
        }
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}
