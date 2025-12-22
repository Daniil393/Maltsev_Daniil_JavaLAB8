package ru.psu.librarymvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String save(@ModelAttribute Publisher formPublisher) {

        Publisher publisher;

        if (formPublisher.getId() != null) {
            // РЕДАКТИРОВАНИЕ
            publisher = publisherRepository
                    .findById(formPublisher.getId())
                    .orElseThrow();
        } else {
            // СОЗДАНИЕ
            publisher = new Publisher();
        }

        publisher.setName(formPublisher.getName());
        publisher.setCity(formPublisher.getCity());

        publisherRepository.save(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        publisherRepository.deleteById(id);
        return "redirect:/publishers";
    }
}