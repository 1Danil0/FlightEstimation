package com.danilermolenko.estimation.forFlights.service;

import com.danilermolenko.estimation.forFlights.communication.Communication;
import com.danilermolenko.estimation.forFlights.dao.RouteDAO;
import com.danilermolenko.estimation.forFlights.models.Weather;
import com.danilermolenko.estimation.forFlights.points.Point;
import com.danilermolenko.estimation.forFlights.points.WeatherInPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class RouteService {
    private final RouteDAO routeDAO;
    private final Communication communication;
    @Autowired
    public RouteService(RouteDAO routeDAO, Communication communication) {
        this.routeDAO = routeDAO;
        this.communication = communication;
    }
    public void addPoint(Point point) throws IOException, URISyntaxException, InterruptedException {
        Weather weather = communication.getWeather(point.getLat(), point.getLon());
        WeatherInPoint weatherInPoint = WeatherInPoint.valueOf(point, weather);
        routeDAO.addPointToRoute(weatherInPoint);
    }
    public List<WeatherInPoint> getRoute(){
        return routeDAO.getRoute();
    }
    public void deletePoint(int id){
        routeDAO.deletePoint(id);
    }
}
