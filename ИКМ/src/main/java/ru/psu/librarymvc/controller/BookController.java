package ru.psu.librarymvc.controller;
import java.util.Optional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;

import ru.psu.librarymvc.entity.Book;
import ru.psu.librarymvc.repository.AuthorRepository;
import ru.psu.librarymvc.repository.BookRepository;
import ru.psu.librarymvc.repository.PublisherRepository;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookController(BookRepository bookRepository,
                          AuthorRepository authorRepository,
                          PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("publishers", publisherRepository.findAll());
        model.addAttribute("authors", authorRepository.findAll()); // <-- для select
        model.addAttribute("isEdit", false);
        return "books/form";
    }

    private String prepareForm(Model model, Book book) {
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("publishers", publisherRepository.findAll());
        model.addAttribute("isEdit", book.getId() != null);
        return "books/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Book book,
                       BindingResult br,
                       Model model) {

        // 1. Проверка валидации
        if (br.hasErrors()) {
            return prepareForm(model, book);
        }

        // 2. Установка связей
        book.setAuthor(
                book.getAuthorId() != null
                        ? authorRepository.findById(book.getAuthorId()).orElse(null)
                        : null
        );

        book.setPublisher(
                book.getPublisherId() != null
                        ? publisherRepository.findById(book.getPublisherId()).orElse(null)
                        : null
        );

        Integer authorId = book.getAuthor() != null
                ? book.getAuthor().getId()
                : null;

        Integer publisherId = book.getPublisher() != null
                ? book.getPublisher().getId()
                : null;

        // 3. Проверка уникальности (title + author + publisher)
        Optional<Book> existing =
                bookRepository.findByTitleAndAuthor_IdAndPublisher_Id(
                        book.getTitle(),
                        authorId,
                        publisherId
                );

        if (existing.isPresent() &&
                (book.getId() == null ||
                        !existing.get().getId().equals(book.getId()))) {

            br.reject("error.book",
                    "Такая книга с этим автором и издателем уже существует");

            return prepareForm(model, book);
        }

        // 4. Сохранение
        try {
            bookRepository.save(book);
        } catch (DataIntegrityViolationException e) {
            br.reject("error.book",
                    "Такая книга с этим автором и издателем уже существует");

            return prepareForm(model, book);
        }

        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        model.addAttribute("book", book);
        model.addAttribute("publishers", publisherRepository.findAll());
        model.addAttribute("isEdit", true); // для шаблона
        return "books/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}