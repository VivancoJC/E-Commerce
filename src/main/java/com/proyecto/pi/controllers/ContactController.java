package com.proyecto.pi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.pi.repositories.CartPropsRepository;
import com.proyecto.pi.repositories.CategoryRepository;

@Controller
public class ContactController {

    final CategoryRepository catRepo;
    final CartPropsRepository cartPropsRepo;

    public ContactController(CategoryRepository catRepo, CartPropsRepository cartPropsRepo) {
        this.catRepo = catRepo;
        this.cartPropsRepo = cartPropsRepo;
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("catlist", catRepo.findAll());
        return "contact";
    }

}
