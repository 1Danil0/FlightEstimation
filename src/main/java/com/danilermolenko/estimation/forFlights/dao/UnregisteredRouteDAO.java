package com.danilermolenko.estimation.forFlights.dao;

import com.danilermolenko.estimation.forFlights.entity.Point;
import com.danilermolenko.estimation.forFlights.entity.Route;
import org.springframework.stereotype.Component;

@Component
public class UnregisteredRouteDAO {
    private Route route;

    public void setDeparture(String departure){
        setRoute();
        route.setDeparture(departure);
    }
    public void addAlternative(String alternative){
        setRoute();
        route.addAlternative(alternative);
    }
    public void setDestination(String destination){
        setRoute();
        route.setDestination(destination);
    }
    public void addPoint(Point point){
        setRoute();
        route.addPoint(point);
    }
    public Route getRoute(){
        setRoute();
        return this.route;
    }
    private void setRoute(){
        if(route == null){
            route = new Route();
        }
    }

    public void toNull() {
        route = null;
    }
}
