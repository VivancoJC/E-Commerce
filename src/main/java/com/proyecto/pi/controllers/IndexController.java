package com.proyecto.pi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.pi.repositories.CartPropsRepository;
import com.proyecto.pi.repositories.CategoryRepository;
import com.proyecto.pi.repositories.ProductRepository;

@Controller
public class IndexController {

    final ProductRepository proRepo;
    final CategoryRepository catRepo;
    final CartPropsRepository cartPropsRepo;

    public IndexController(ProductRepository proRepo, CategoryRepository catRepo, CartPropsRepository cartPropsRepo) {
        this.proRepo = proRepo;
        this.catRepo = catRepo;
        this.cartPropsRepo = cartPropsRepo;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("catlist", catRepo.findAll());
        model.addAttribute("menlist", proRepo.findByCid(1));
        model.addAttribute("womenlist", proRepo.findByCid(2));
        model.addAttribute("kidslist", proRepo.findByCid(3));
        model.addAttribute("allproduct", proRepo.findAll());
        return "index";
    }






}
