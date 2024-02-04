package com.dev.afromusic.controller;

import com.dev.afromusic.models.Registration;
import com.dev.afromusic.models.UserEntity;
import com.dev.afromusic.service.UserService;
import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model){
        Registration user = new Registration();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") Registration user,
                           BindingResult result, Model model) {
        UserEntity existingUserEmail = userService.findByEmail(user.getEmail());
        if (existingUserEmail != null && existingUserEmail.getEmail() != null &&
                !existingUserEmail.getEmail().isEmpty()){
            return "redirect:/register?fail";
        }

            UserEntity existingUserUsername = userService.findByUsername(user.getUsername());
            if (existingUserUsername != null && existingUserUsername.getUsername() != null && !existingUserUsername.getUsername().isEmpty()) {
                return "redirect:/register?fail";
            }
                if (result.hasErrors()) {
                    model.addAttribute("user", user);
                    return "register";
                }

                userService.saveUser(user);
                return "redirect:/artists?success";

        }

        @GetMapping("/login")
    public String logInpage(){
        return "login";
        }

        @GetMapping("/")
    public String local(){
        return "login";
        }
    }

