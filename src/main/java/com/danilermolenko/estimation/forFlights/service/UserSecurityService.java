package com.danilermolenko.estimation.forFlights.service;

import com.danilermolenko.estimation.forFlights.dao.UserDAO;
import com.danilermolenko.estimation.forFlights.dto.UserDTO;
import com.danilermolenko.estimation.forFlights.entity.Role;
import com.danilermolenko.estimation.forFlights.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Set;

@Service
public class UserSecurityService implements UserDetailsService {
    private final UserDAO userDAO;
    @Autowired
    public UserSecurityService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByLogin(username);
    }
}
