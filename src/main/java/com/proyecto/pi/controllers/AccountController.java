package com.proyecto.pi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.pi.entities.Users;
import com.proyecto.pi.repositories.CartPropsRepository;
import com.proyecto.pi.repositories.CategoryRepository;
import com.proyecto.pi.repositories.UsersRepository;
import com.proyecto.pi.util.LoginControl;


@Controller
public class AccountController {

    String error_msg = "";
    final LoginControl loginControl;
    final UsersRepository userRepo;
    int uid = 0;
    final CategoryRepository catRepo;
    final CartPropsRepository cartPropsRepo;

    public AccountController(CategoryRepository catRepo, UsersRepository userRepo, CartPropsRepository cartPropsRepo, LoginControl loginControl) {
        this.userRepo = userRepo;
        this.catRepo = catRepo;
        this.loginControl = loginControl;
        this.cartPropsRepo = cartPropsRepo;
    }

    @GetMapping("/account")
    public String account(Model model) {
        model.addAttribute("catlist", catRepo.findAll());
        if (!error_msg.equals("")) {
            model.addAttribute("error_msg", error_msg);
        }
        error_msg = "";
        return "account";
    }

    @PostMapping("/userlogin")
    public String userlogin(Users user) {
        if (loginControl.userControl(user) != null) {
            return "redirect:/account";
        }
        error_msg = "Mail or Password Wrong!";
        return "redirect:/account";
    }

    @PostMapping("/userRegister")
    public String userRegister(Users user) {
        if (uid != 0) {
            user.setUid(uid);
        }
        userRepo.saveAndFlush(user);
        uid = 0;
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String userLogin(){
        loginControl.logout();
        return "redirect:/";
    }
}
