package ru.psu.librarymvc.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import ru.psu.librarymvc.entity.Publisher;
import ru.psu.librarymvc.repository.PublisherRepository;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("publishers", publisherRepository.findAll());
        return "publishers/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publishers/form";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow();
        model.addAttribute("publisher", publisher);
        return "publishers/form";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute("publisher") Publisher publisher,
                       BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors())
            return "publishers/form";

        if (publisherRepository.existsByNameIgnoreCase(publisher.getName())
                && publisher.getId() == null) {

            bindingResult.rejectValue("name",
                    "error.publisher",
                    "Издательство с таким названием уже существует");

            return "publishers/form";
        }

        publisherRepository.save(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        publisherRepository.deleteById(id);
        return "redirect:/publishers";
    }
}