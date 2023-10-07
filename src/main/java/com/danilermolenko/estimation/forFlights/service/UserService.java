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

@Service
public class UserService {
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
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
            user.setName(userDTO.getName());
            user.setSurname(userDTO.getSurname());
            user.setLogin(userDTO.getLogin());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setEmail(userDTO.getEmail());
            user.setActive(true);
            user.setRole(Set.of(Role.USER));
            userDAO.save(user);
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
}
