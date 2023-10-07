package com.danilermolenko.estimation.forFlights.service;

import com.danilermolenko.estimation.forFlights.dao.RouteDAO;
import com.danilermolenko.estimation.forFlights.entity.Point;
import com.danilermolenko.estimation.forFlights.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    private Route route;
    private final RouteDAO routeDAO;
    @Autowired
    public RouteService(RouteDAO routeDAO) {
        this.routeDAO = routeDAO;
    }
    public void save(Route route){
        if(route != null) {
            routeDAO.save(route);
        }
        this.route = null;
    }
    public void setDeparture(String departure){
        createRoute();
        route.setDeparture(departure);
    }
    public void addPoint(Point point){
        createRoute();
        route.addPoint(point);
    }
    public void setDestination(String destination){
        createRoute();
        route.setDestination(destination);
    }
    public void addAlternative(String alternative){
        createRoute();
        route.addAlternative(alternative);
    }
    public void deletePoint(long id){
        if(id < route.getPoints().size()) {
            route.getPoints().remove(id);
        }
    }
    private boolean isRouteNull(){
        if(this.route == null){
            return true;
        }
        return false;
    }
    private void createRoute(){
        if(isRouteNull()){
            route = new Route();
        }
    }
    public Route getRoute(){
        return this.route;
    }
}
