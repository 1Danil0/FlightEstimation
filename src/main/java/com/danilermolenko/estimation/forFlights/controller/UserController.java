package com.danilermolenko.estimation.forFlights.controller;

import com.danilermolenko.estimation.forFlights.dto.UserDTO;
import com.danilermolenko.estimation.forFlights.entity.User;
import com.danilermolenko.estimation.forFlights.service.UserSecurityService;
import com.danilermolenko.estimation.forFlights.service.UserService;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            model.addAttribute("message", "letter was sent to your email");
            return "first-page";
        }
        model.addAttribute("message", "such user is already exists");
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
            model.addAttribute("message", "you have been authorized");
        } else{
            model.addAttribute("message", "you have not been activated");
        }
        return "first-page";
    }
    @GetMapping("/changePassword/step1")
    public String changePassword(){
        return "change-password-page";
    }
    @GetMapping("/changePassword/step2")
    public String changePassword(@RequestParam("email") String email, Model model){
        if(service.changePassword(email)){
            model.addAttribute("message", "you must have received a letter on specified email to change password");
            return "change-password-page";
        }
        model.addAttribute("message", "it is likely you entered a wrong email");
        return "change-password-page";
    }
    @GetMapping("/changePassword/step3/{code}")
    public String password(@PathVariable("code") String code, Model model){
        model.addAttribute("code", code);
        return "password-page";
    }
    @PostMapping("/change")
    public String changePassword(@RequestParam("pass1") String pass1,
                                 @RequestParam("pass2") String pass2,
                                 @RequestParam("code") String code,
                                 Model model){
        if(pass1.equals(pass2)){
            service.changePassword(pass2, code);
            return "redirect:/login";
        }
        model.addAttribute("message", "passwords are not equal");
        return "password-page";
    }
}
