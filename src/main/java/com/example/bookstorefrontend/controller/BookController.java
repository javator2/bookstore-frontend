package com.example.bookstorefrontend.controller;

import com.example.bookstorefrontend.service.BookApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class BookController {

    private final BookApiClient client;

    @Autowired
    public BookController(BookApiClient client) {
        this.client = client;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/showme")
    @ResponseBody public String showme() {
        return "index";
    }

    @GetMapping("/proba")
    public String proba(Model model) {
        model.addAttribute("text", "Proooooba");
        model.addAttribute("drugi", "jakis wpis");
        return "index";
    }

}
