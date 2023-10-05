package com.danilermolenko.estimation.forFlights.points;

import com.danilermolenko.estimation.forFlights.models.Weather;

public class WeatherInPoint {
    Point point;
    String name;
    private String wind_dir;
    private double wind_speed;
    private int temp;
    private String condition;
    private WeatherInPoint(){}
    public static WeatherInPoint valueOf(Point point, Weather weather){
        String name = weather.getInfo().getUrl();
        WeatherInPoint weatherInPoint = new WeatherInPoint();
        weatherInPoint.name = name.substring(name.lastIndexOf('/') + 1);
        weatherInPoint.point = point;
        weatherInPoint.wind_dir = weather.getFact().getWind_dir();
        weatherInPoint.wind_speed = weather.getFact().getWind_speed();
        weatherInPoint.temp = weather.getFact().getTemp();
        weatherInPoint.condition = weather.getFact().getCondition();
        return weatherInPoint;
    }

    public String getName() {
        return name;
    }

    public Point getPoint() {
        return point;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public int getTemp() {
        return temp;
    }

    public String getCondition() {
        return condition;
    }
}
