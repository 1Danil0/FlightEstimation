package com.danilermolenko.estimation.forFlights.service;

import com.danilermolenko.estimation.forFlights.communication.AeroWeatherComm;
import com.danilermolenko.estimation.forFlights.communication.YandexComm;
import com.danilermolenko.estimation.forFlights.entity.Point;
import com.danilermolenko.estimation.forFlights.entity.WeatherOnRoute;
import com.danilermolenko.estimation.forFlights.models.aeroweatcomm.AllWeather;
import com.danilermolenko.estimation.forFlights.models.yandexmodels.Weather;
import com.danilermolenko.estimation.forFlights.weather.AirportWeather;
import com.danilermolenko.estimation.forFlights.weather.WeatherInPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class OnRouteWeatherService {
    private final AeroWeatherComm aeroWeatherComm;
    private final YandexComm yandexComm;
    private WeatherOnRoute weatherOnRoute;
    @Autowired
    public OnRouteWeatherService(AeroWeatherComm aeroWeatherComm, YandexComm yandexComm) {
        this.aeroWeatherComm = aeroWeatherComm;
        this.yandexComm = yandexComm;
    }
    public boolean setDeparture(String icao){
        createWeatherOnRoute();
        AirportWeather airportWeather = getAirportWeather(icao);
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
        AirportWeather airportWeather = getAirportWeather(icao);
        if(airportWeather != null){
            weatherOnRoute.setDestination(airportWeather);
            return true;
        }
        return false;
    }
    public boolean addAlternative(String icao){
        createWeatherOnRoute();
        AirportWeather airportWeather = getAirportWeather(icao);
        if(airportWeather != null){
            weatherOnRoute.addAlternative(airportWeather);
            return true;
        }
        return false;
    }
    public boolean addPoint(Point point){
        createWeatherOnRoute();
        WeatherInPoint weatherInPoint = getWeatherInPoint(point);
        if(weatherInPoint != null){
            weatherOnRoute.addPoint(weatherInPoint);
            return true;
        }
        return false;
    }
    public void deletePoint(long id){
        createWeatherOnRoute();
            weatherOnRoute.getPoints().remove(id);
    }
    public void toNull(){
        weatherOnRoute = null;
    }
    private AirportWeather getAirportWeather(String icao){
        AirportWeather airportWeather = null;
        try {
            AllWeather allWeather = aeroWeatherComm.getAllWeather(icao);
            if(allWeather.getResults() != 0) {
                airportWeather = new AirportWeather.Builder()
                        .icao(allWeather.getData()[0].getIcao())
                        .windDirection(allWeather.getData()[0].getWind() == null ? 0 : allWeather.getData()[0].getWind().getDegrees())
                        .windSpeed(allWeather.getData()[0].getWind() == null ? 0 : allWeather.getData()[0].getWind().getSpeed_mph())
                        .ceilingMeters(allWeather.getData()[0].getCeiling() != null ? allWeather.getData()[0].getCeiling().getMeters() : 10000)
                        .visibilityMeters(allWeather.getData()[0].getVisibility() != null ? allWeather.getData()[0].getVisibility().getMeters() : "10000+")
                        .build();
            }
        } catch (URISyntaxException e) {
            return null;
        } catch (IOException e) {
            return null;
        } catch (InterruptedException e) {
            return null;
        }
        return airportWeather;
    }
    private WeatherInPoint getWeatherInPoint(Point point){
        WeatherInPoint weatherInPoint = null;
        try{
            Weather weather = yandexComm.getWeather(point.getLatitude(), point.getLongitude());
            if(weather != null) {
                weatherInPoint = new WeatherInPoint.Builder()
                        .point(point)
                        .name("somename")
                        .wind_dir(weather.getFact().getWind_dir())
                        .wind_speed(weather.getFact().getWind_speed())
                        .temp(weather.getFact().getTemp())
                        .condition(weather.getFact().getCondition())
                        .build();
            }
        } catch (IOException e) {
            return null ;
        } catch (URISyntaxException e) {
            return null;
        } catch (InterruptedException e) {
            return null;
        }
        return weatherInPoint;
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
