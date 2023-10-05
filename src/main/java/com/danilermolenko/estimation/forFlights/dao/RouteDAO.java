package com.danilermolenko.estimation.forFlights.dao;

import com.danilermolenko.estimation.forFlights.points.Point;
import com.danilermolenko.estimation.forFlights.points.WeatherInPoint;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class RouteDAO {
    List<WeatherInPoint> route;
    public void addPointToRoute(WeatherInPoint point){
        if(route == null){
            route = new ArrayList<>();
        }
        route.add(point);
    }
    public List<WeatherInPoint> getRoute(){
        if(route == null){
            return new ArrayList<>();
        }
        return route;
    }
    public void deletePoint(int id){
        route.remove(id);
    }

}
