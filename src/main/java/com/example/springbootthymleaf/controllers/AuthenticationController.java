package com.example.springbootthymleaf.controllers;


import com.example.springbootthymleaf.entities.UserEntity;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("view", "login");
        return "layout";
    }

    @PostMapping("login")
    public String login(@ModelAttribute("user") UserEntity user, Model model, HttpServletRequest request) {
        System.out.println(user);
        Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), null);
        authenticationManager.authenticate(auth);
        System.out.println(auth);
        request.setAttribute("user", user);

        return "redirect:/home";
    }


    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/home";
    }
}
