package com.example.springbootthymleaf.controllers;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @RequestMapping("/login")
    public  String loginPage(Model model){
        model.addAttribute("view","login");
        return "layout";
    }

//    @PostMapping("login")
//    public String login(@ModelAttribute("user")MyUser user, Model model){
//        System.out.println(user);
//        Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword(),null);
//        authenticationManager.authenticate(auth);
//        System.out.println(auth);
//        SecurityContextHolder.getContext().setAuthentication(auth);
//
//    return "redirect:/home";
//    }
}
