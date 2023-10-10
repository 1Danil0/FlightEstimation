package com.danilermolenko.estimation.forFlights.communication;

import com.danilermolenko.estimation.forFlights.entity.Point;
import com.danilermolenko.estimation.forFlights.models.aeroweatcomm.AllWeather;
import com.danilermolenko.estimation.forFlights.models.yandexmodels.Weather;
import com.danilermolenko.estimation.forFlights.weather.AirportWeather;
import com.danilermolenko.estimation.forFlights.weather.RouteWeatherGetable;
import com.danilermolenko.estimation.forFlights.weather.WeatherInPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
public class WeatherReceiver implements RouteWeatherGetable {
    private final AeroWeatherComm aeroWeatherComm;
    private final YandexComm yandexComm;
    @Autowired
    public WeatherReceiver(AeroWeatherComm aeroWeatherComm, YandexComm yandexComm) {
        this.aeroWeatherComm = aeroWeatherComm;
        this.yandexComm = yandexComm;
    }

    @Override
    public AirportWeather getAirportWeather(String icao){
        AirportWeather airportWeather = null;
        try {
            AllWeather allWeather = aeroWeatherComm.getAllWeather(icao);
            if(allWeather.getResults() != 0) {
                airportWeather = new AirportWeather.Builder()
                        .icao(allWeather.getData()[0].getIcao())
                        .windDirection(allWeather.getData()[0].getWind() == null ? 0 : allWeather.getData()[0].getWind().getDegrees())
                        .windSpeed(allWeather.getData()[0].getWind() == null ? 0 : allWeather.getData()[0].getWind().getSpeed_mps())
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

    @Override
    public WeatherInPoint getWeatherInPoint(Point point){
        WeatherInPoint weatherInPoint = null;
        try{
            Weather weather = yandexComm.getWeather(point.getLatitude(), point.getLongitude());
            if(weather != null) {
                weatherInPoint = new WeatherInPoint.Builder()
                        .point(point)
                        .name("somename")
                        .wind_dir(weather.getFact() != null ? weather.getFact().getWind_dir() : "no data")
                        .wind_speed(weather.getFact() != null ?  weather.getFact().getWind_speed() : 0)
                        .temp(weather.getFact() != null ? weather.getFact().getTemp() : 0)
                        .condition(weather.getFact() != null ? weather.getFact().getCondition() : "no data")
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
}
