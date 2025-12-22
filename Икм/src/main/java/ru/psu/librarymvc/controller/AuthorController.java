package ru.psu.librarymvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.psu.librarymvc.entity.Author;
import ru.psu.librarymvc.repository.AuthorRepository;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("author", new Author());
        return "authors/form";
    }

    @PostMapping
    public String save(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("author",
                authorRepository.findById(id).orElseThrow());
        return "authors/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }
}