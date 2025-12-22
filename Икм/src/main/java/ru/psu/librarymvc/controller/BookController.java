package ru.psu.librarymvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        model.addAttribute("book", new Book());
        return "books/form";
    }

    @PostMapping
    public String save(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute(
                "book",
                bookRepository.findById(id).orElseThrow()
        );
        return "books/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}