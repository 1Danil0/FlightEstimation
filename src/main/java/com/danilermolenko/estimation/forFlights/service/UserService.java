package com.danilermolenko.estimation.forFlights.service;

import com.danilermolenko.estimation.forFlights.dao.UserDAO;
import com.danilermolenko.estimation.forFlights.dto.UserDTO;
import com.danilermolenko.estimation.forFlights.entity.Role;
import com.danilermolenko.estimation.forFlights.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {
    private final UserDAO userDAO;
    private final MailSender mailSender;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserDAO userDAO, MailSender mailSender, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.mailSender = mailSender;
        this.passwordEncoder = passwordEncoder;
    }
    public User getUserFromPrincipal(Principal principal){
        if(principal == null){
            return new User();
        }
        return userDAO.findByLogin(principal.getName());
    }
    public boolean save(User user){
        if(user != null){
            userDAO.save(user);
            return true;
        }
        return false;
    }
    public boolean save(UserDTO userDTO){
        if(userDAO.findByLogin(userDTO.getLogin()) == null){
            User user = new User();
            user.setActivationCode(UUID.randomUUID().toString());
            user.setName(userDTO.getName());
            user.setSurname(userDTO.getSurname());
            user.setLogin(userDTO.getLogin());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setEmail(userDTO.getEmail());
            user.setActive(false);
            user.setRole(Set.of(Role.USER));
            userDAO.save(user);
            if(!user.getEmail().isEmpty()){
                String message = String.format("Hi, %s!\nWelcome to Flight Calculator. Please visit next link to complete authorization: http://localhost:8080/activate/%s"
                        , user.getUsername(), user.getActivationCode());
                mailSender.sent(user.getEmail(), "Activation code", message);
            }
            return true;
        }
        return false;
    }
    public User findUserById(long id){
        Optional<User> user = userDAO.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }
    public boolean activateUser(String code){
        User user = userDAO.findByActivationCode(code);
        if(user == null){
            return false;
        }
        user.setActivationCode(null);
        user.setActive(true);
        userDAO.save(user);
        return true;
    }
}
