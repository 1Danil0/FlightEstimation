package com.danilermolenko.estimation.forFlights.weather;

import com.danilermolenko.estimation.forFlights.entity.Point;
import com.danilermolenko.estimation.forFlights.models.yandexmodels.Weather;

public class WeatherInPoint {
    private Point point;
    private String name;
    private String wind_dir;
    private double wind_speed;
    private int temp;
    private String condition;
    private WeatherInPoint(Builder builder){
        this.point = builder.point;
        this.name = builder.name;
        this.wind_dir = builder.wind_dir;
        this.wind_speed = builder.wind_speed;
        this.temp = builder.temp;
        this.condition = builder.condition;
    }
    public static class Builder{
        private Point point;
        private String name;
        private String wind_dir;
        private double wind_speed;
        private int temp;
        private String condition;
        public Builder point(Point point){
            this.point = point;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder wind_dir(String wind_dir){
            this.wind_dir = wind_dir;
            return this;
        }
        public Builder wind_speed(double wind_speed){
            this.wind_speed = wind_speed;
            return this;
        }
        public Builder temp(int temp){
            this.temp = temp;
            return this;
        }
        public Builder condition(String condition){
            this.condition = condition;
            return this;
        }
        public WeatherInPoint build(){
            return new WeatherInPoint(this);
        }
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
