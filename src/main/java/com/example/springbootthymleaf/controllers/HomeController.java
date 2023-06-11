package com.example.springbootthymleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home(Model model) {
//        model.addAttribute("view", "test");
        return "redirect:/home";
    }

//    @GetMapping("home")
//    public String test(Model model){
//
//        model.addAttribute("view","home");
//        return "layout";
//    }


}
