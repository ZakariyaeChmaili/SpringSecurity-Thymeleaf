package com.example.springbootthymleaf.controllers;

import com.example.springbootthymleaf.entities.Livre;
import com.example.springbootthymleaf.services.LivreServiceI;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LivreController {
    private final LivreServiceI livreServiceI;

    public LivreController(LivreServiceI livreServiceI) {
        this.livreServiceI = livreServiceI;
    }

    @GetMapping("home")
    public String getAll(Model model) {
        model.addAttribute("livres", livreServiceI.findAll());
        model.addAttribute("view", "home");
        return "layout";
    }

    @GetMapping("formAdd")
    public String formAdd(Model model) {
        model.addAttribute("livre", new Livre());
        model.addAttribute("view", "livres/addLivre");
        return "layout";
    }

    @GetMapping("formUpdate/{isbn}")
    public String formUpdate(@PathVariable Long isbn, Model model) {
        model.addAttribute("livre", livreServiceI.getBookByIsbn(isbn));
        model.addAttribute("view", "livres/editLivre");
        return "layout";
    }


    @PostMapping("saveLivre")
    public String save(Livre livre, Model model) {
        System.out.println(livre);
        System.out.println(model);
            livreServiceI.addBook(livre);
        return "redirect:/home";
    }


    @PostMapping("updateLivre")
    public String update(Livre livre, Model model) {
        System.out.println(livre);
        livreServiceI.updateBook(livre);
        return "redirect:/home";
    }


    @GetMapping("deleteLivre/{isbn}")
    public String delete(@PathVariable Long isbn, Model model) {
        System.out.println(isbn);
        livreServiceI.deleteBook(isbn);
        return "redirect:/home";
    }




}
