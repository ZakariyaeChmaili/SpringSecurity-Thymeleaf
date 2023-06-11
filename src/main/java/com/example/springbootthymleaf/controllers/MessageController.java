package com.example.springbootthymleaf.controllers;


import com.example.springbootthymleaf.entities.Message;
import com.example.springbootthymleaf.services.MessageServiceImp;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
public class MessageController {

    private final MessageServiceImp messageService;

    public MessageController(MessageServiceImp messageService) {
        this.messageService = messageService;
    }


    @GetMapping("/home")
    public String home(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getDetails());
        ;
        System.out.println(auth.getName());
        System.out.println(auth.getCredentials());
        System.out.println(auth.getPrincipal());

        List<Message> messages = this.messageService.findAll();
        System.out.println(messages);
        model.addAttribute("messages", messages);
        model.addAttribute("view", "home");
        return "layout";
    }


    @GetMapping("formMsg")
    public String form(Model model) {
        model.addAttribute("message", new Message());
        model.addAttribute("view", "messages/addMsg");

        return "layout";
    }


    @PostMapping("saveMsg")
    public String save(@Valid Message msg, BindingResult result, Model model) {
        System.out.println(msg);
        System.out.println(model);
        if (result.hasErrors()) {
            if (msg.getId() != null) {
                model.addAttribute("view", "messages/editMsg");
            } else {
                model.addAttribute("view", "messages/addMsg");
            }

            return "layout";
        }

        msg.setDate(new Date());
        this.messageService.save(msg);
        return "redirect:/home";
    }


    @GetMapping("deleteMsg/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.messageService.deleteById(id);
        return "redirect:/home";
    }


    @GetMapping("editMsg/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Message msg = this.messageService.findById(id);
        System.out.println(msg);
        model.addAttribute("message", msg);
        model.addAttribute("view", "messages/editMsg");
        return "layout";
    }


    @PostMapping("updateMsg")
    public String update(@ModelAttribute("msg") Message msg, Model model) {
        System.out.println(msg);
        System.out.println(model);
//        msg.setDate(new Date());
//        MyUser user = new MyUser();
//        user.setId(1L);
//        msg.setUser(user);
//        this.messageService.save(msg);
//        model.addAttribute("view","home");
        return "redirect:/home";
    }

}
