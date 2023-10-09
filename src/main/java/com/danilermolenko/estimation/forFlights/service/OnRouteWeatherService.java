package com.danilermolenko.estimation.forFlights.service;

import com.danilermolenko.estimation.forFlights.communication.WeatherReceiver;
import com.danilermolenko.estimation.forFlights.entity.Point;
import com.danilermolenko.estimation.forFlights.entity.Route;
import com.danilermolenko.estimation.forFlights.entity.WeatherOnRoute;
import com.danilermolenko.estimation.forFlights.weather.AirportWeather;
import com.danilermolenko.estimation.forFlights.weather.WeatherInPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class OnRouteWeatherService {
    private WeatherOnRoute weatherOnRoute;
    private final WeatherReceiver weatherReceiver;
    @Autowired
    public OnRouteWeatherService(WeatherReceiver weatherReceiver) {
        this.weatherReceiver = weatherReceiver;
    }
    public boolean setDeparture(String icao){
        createWeatherOnRoute();
        AirportWeather airportWeather = weatherReceiver.getAirportWeather(icao);
        if(airportWeather != null) {
            weatherOnRoute.setDeparture(airportWeather);
            return true;
        }
        return false;
    }
    public AirportWeather getDeparture(){
        createWeatherOnRoute();
        return weatherOnRoute.getDeparture();
    }
    public AirportWeather getDestination(){
        createWeatherOnRoute();
        return weatherOnRoute.getDestination();
    }
    public List<AirportWeather> getAlternatives(){
        createWeatherOnRoute();
        return weatherOnRoute.getAlternatives();
    }
    public List<WeatherInPoint> getPoints(){
        createWeatherOnRoute();
        return weatherOnRoute.getPoints();
    }
    public boolean setDestination(String icao){
        createWeatherOnRoute();
        AirportWeather airportWeather = weatherReceiver.getAirportWeather(icao);
        if(airportWeather != null){
            weatherOnRoute.setDestination(airportWeather);
            return true;
        }
        return false;
    }
    public boolean addAlternative(String icao){
        createWeatherOnRoute();
        AirportWeather airportWeather = weatherReceiver.getAirportWeather(icao);
        if(airportWeather != null){
            weatherOnRoute.addAlternative(airportWeather);
            return true;
        }
        return false;
    }
    public WeatherOnRoute getWeatherOnRoute() {
        return weatherOnRoute;
    }

    public boolean addPoint(Point point){
        createWeatherOnRoute();
        WeatherInPoint weatherInPoint = weatherReceiver.getWeatherInPoint(point);
        if(weatherInPoint != null){
            weatherOnRoute.addPoint(weatherInPoint);
            return true;
        }
        return false;
    }
    public void deletePoint(int id){
        createWeatherOnRoute();
        weatherOnRoute.deletePoint(id);
    }
    public void toNull(){
        weatherOnRoute = null;
    }
    public void convertRouteToWeatherOnRoute(Route route){
        weatherOnRoute = new WeatherOnRoute();
        weatherOnRoute.setDeparture(weatherReceiver.getAirportWeather(route.getDeparture()));
        weatherOnRoute.setDestination(weatherReceiver.getAirportWeather(route.getDestination()));
        Iterator<String> alternatives = route.getAlternatives().iterator();
        while (alternatives.hasNext()){
            weatherOnRoute.addAlternative(weatherReceiver.getAirportWeather(alternatives.next()));
        }
        Iterator<Point> points = route.getPoints().iterator();
        while (points.hasNext()){
            Point point = points.next();
            weatherOnRoute.addPoint(weatherReceiver.getWeatherInPoint(new Point(point.getLatitude(), point.getLongitude(), point.getAltitude())));
        }
    }
    private boolean isWeatherOnRouteNull(){
        if(this.weatherOnRoute == null){
            return true;
        }
        return false;
    }
    private void createWeatherOnRoute(){
        if(isWeatherOnRouteNull()){
            this.weatherOnRoute = new WeatherOnRoute();
        }
    }
}
