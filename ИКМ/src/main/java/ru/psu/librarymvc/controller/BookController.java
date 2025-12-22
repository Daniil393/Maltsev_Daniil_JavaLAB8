package ru.psu.librarymvc.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
        Book book = new Book();
        // чтобы в форме корректно работали поля authorId/publisherId
        model.addAttribute("book", book);
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("publishers", publisherRepository.findAll());
        return "books/form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Book book, BindingResult br, Model model) {
        if (br.hasErrors()) {
            model.addAttribute("authors", authorRepository.findAll());
            model.addAttribute("publishers", publisherRepository.findAll());
            return "books/form";
        }

        // Если в Book используются transient authorId/publisherId (рекомендованный подход),
        // подтягиваем реальные сущности по id и устанавливаем их в book
        if (book.getAuthorId() != null) {
            authorRepository.findById(book.getAuthorId()).ifPresent(book::setAuthor);
        } else {
            book.setAuthor(null);
        }

        if (book.getPublisherId() != null) {
            publisherRepository.findById(book.getPublisherId()).ifPresent(book::setPublisher);
        } else {
            book.setPublisher(null);
        }

        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Book book = bookRepository.findById(id).orElseThrow();
        // заполняем transient id, чтобы в форме был выбран текущий автор/издатель
        if (book.getAuthor() != null) {
            book.setAuthorId(book.getAuthor().getId());
        }
        if (book.getPublisher() != null) {
            book.setPublisherId(book.getPublisher().getId());
        }

        model.addAttribute("book", book);
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("publishers", publisherRepository.findAll());
        return "books/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}