package com.danilermolenko.estimation.forFlights.entity;

import com.danilermolenko.estimation.forFlights.weather.AirportWeather;
import com.danilermolenko.estimation.forFlights.weather.WeatherInPoint;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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
    public void setAlternatives(List<AirportWeather> alternatives){
        this.alternatives = alternatives;
    }
    public void setPoints(List<WeatherInPoint> points){
        this.points = points;
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
    public void deletePoint(int id){
        if(id < points.size()) {
            points.remove(id);
        }
    }

    @Override
    public String toString() {
        return "WeatherOnRoute{" +
                "departure=" + departure +
                ", destination=" + destination +
                ", alternatives=" + alternatives +
                ", points=" + points +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        WeatherOnRoute that = (WeatherOnRoute) o;
//        return Objects.equals(departure, that.departure) && Objects.equals(destination, that.destination) && Objects.equals(alternatives, that.alternatives) && Objects.equals(points, that.points);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(departure, destination, alternatives, points);
//    }
}
