package com.danilermolenko.estimation.forFlights.controller;

import com.danilermolenko.estimation.forFlights.dto.UserDTO;
import com.danilermolenko.estimation.forFlights.entity.User;
import com.danilermolenko.estimation.forFlights.service.UserSecurityService;
import com.danilermolenko.estimation.forFlights.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService service;
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    @GetMapping("/login")
    public String login(){
        return "first-page";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration-page";
    }

    @PostMapping("/registration")
    public String registration(UserDTO userDTO, Model model){
        if(service.save(userDTO)){
            return "redirect:/login";
        }
        model.addAttribute("error", "such user is already exists");
        return "registration-page";
    }
    @GetMapping("/user/{id}")
    public String userPage(@PathVariable("id") long id, Model model){
        User user = service.findUserById(id);
        if(user != null){
            model.addAttribute("user", user);
            return "user-page";
        }
        return "redirect:/points";
    }
    @GetMapping("/activate/{code}")
    public String activate(@PathVariable("code") String code, Model model){
        if(service.activateUser(code)){
            model.addAttribute("message", "you have been activated");
        } else{
            model.addAttribute("message", "you have not been activated");
        }
        return "first-page";
    }
}
