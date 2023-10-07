package com.danilermolenko.estimation.forFlights.entity;

import com.danilermolenko.estimation.forFlights.weather.AirportWeather;
import com.danilermolenko.estimation.forFlights.weather.WeatherInPoint;

import java.util.ArrayList;
import java.util.List;

public class WeatherOnRoute {
    private AirportWeather departure;
    private AirportWeather destination;
    private List<AirportWeather> alternatives;
    private List<WeatherInPoint> points;

    public WeatherOnRoute() {
    }

    public AirportWeather getDeparture() {
        return departure;
    }

    public void setDeparture(AirportWeather departure) {
        this.departure = departure;
    }

    public AirportWeather getDestination() {
        return destination;
    }

    public void setDestination(AirportWeather destination) {
        this.destination = destination;
    }

    public List<AirportWeather> getAlternatives() {
        return alternatives;
    }

    public void addAlternative(AirportWeather airportWeather) {
        if(alternatives == null){
            alternatives = new ArrayList<>();
        }
        alternatives.add(airportWeather);
    }

    public List<WeatherInPoint> getPoints() {
        return points;
    }

    public void addPoint(WeatherInPoint weatherInPoint) {
        if(points == null){
            points = new ArrayList<>();
        }
        points.add(weatherInPoint);
    }
}
