package com.danilermolenko.estimation.forFlights.service;

import com.danilermolenko.estimation.forFlights.dao.UnregisteredRouteDAO;
import com.danilermolenko.estimation.forFlights.entity.Point;
import com.danilermolenko.estimation.forFlights.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnregisteredRouteService {
    private final UnregisteredRouteDAO unregisteredRouteDAO;
    @Autowired
    public UnregisteredRouteService(UnregisteredRouteDAO unregisteredRouteDAO) {
        this.unregisteredRouteDAO = unregisteredRouteDAO;
    }
    public void setDeparture(String departure){
        unregisteredRouteDAO.setDeparture(departure);
    }
    public void setDestination(String destination){
        unregisteredRouteDAO.setDestination(destination);
    }
    public void addPoint(Point point){
        unregisteredRouteDAO.addPoint(point);
    }
    public void addAlternative(String alternative){
        unregisteredRouteDAO.addAlternative(alternative);
    }
    public Route getRoute(){
        return unregisteredRouteDAO.getRoute();
    }
    public void deletePoint(long id){
        if(id < unregisteredRouteDAO.getRoute().getPoints().size()) {
            unregisteredRouteDAO.getRoute().getPoints().remove(id);
        }
    }
    public void toNull(){
        unregisteredRouteDAO.toNull();
    }
}
