package com.danilermolenko.estimation.forFlights.dao;

import com.danilermolenko.estimation.forFlights.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserDAO extends JpaRepository<User, Long> {
    User findByLogin(String username);
    User findByActivationCode(String code);
    User findByEmail(String email);
}
