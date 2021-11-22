package com.proyecto.pi.controllers;

import com.proyecto.pi.entities.Product;
import com.proyecto.pi.repositories.CartPropsRepository;
import com.proyecto.pi.repositories.CategoryRepository;
import com.proyecto.pi.repositories.ProductRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class DetailController {

    final ProductRepository proRepo;
    final CategoryRepository catRepo;
    final CartPropsRepository cartPropsRepo;

    public DetailController(ProductRepository proRepo, CategoryRepository catRepo, CartPropsRepository cartPropsRepo) {
        this.proRepo = proRepo;
        this.catRepo = catRepo;
        this.cartPropsRepo = cartPropsRepo;
    }


    @GetMapping("/detail{tpid}")
    public String detail(Model model, @RequestParam(value = "id", required = true) String tpid) {
        model.addAttribute("catlist", catRepo.findAll());
        int pid = Integer.parseInt(tpid);
        Optional<Product> oProduct = proRepo.findById(pid);
        if (oProduct.isPresent()) {
            oProduct.ifPresent(item -> model.addAttribute("detail", item));
            return "detail";
        } else {
            return "redirect:/404";
        }
    }
}
