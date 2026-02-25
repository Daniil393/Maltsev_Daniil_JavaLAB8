package ru.psu.librarymvc.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    // Список авторов
    @GetMapping
    public String list(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/list";
    }

    // Форма создания
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("author", new Author());
        return "authors/form";
    }

    // Сохранение (и создание, и редактирование)
    @PostMapping
    public String save(@Valid @ModelAttribute Author author, BindingResult bindingResult,
                       Model model) {

        if (bindingResult.hasErrors()) {
            return "authors/form";
        }

        if (authorRepository.existsByNameIgnoreCase(author.getName()) && author.getId() == null) {
            bindingResult.rejectValue("name", "error.author",
                    "Автор с таким именем уже существует");
            return "authors/form";
        }

        authorRepository.save(author);
        return "redirect:/authors";
    }

    // Форма редактирования
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Автор не найден: " + id));

        model.addAttribute("author", author);
        return "authors/form";
    }

    // Удаление
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }
}