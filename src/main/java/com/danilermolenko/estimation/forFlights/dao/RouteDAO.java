package com.danilermolenko.estimation.forFlights.dao;

import com.danilermolenko.estimation.forFlights.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteDAO extends JpaRepository<Route, Long> {

}
