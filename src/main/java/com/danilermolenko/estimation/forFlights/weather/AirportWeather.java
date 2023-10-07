package com.danilermolenko.estimation.forFlights.weather;

public class AirportWeather {
    private String icao;
    private int windDirection;
    private int windSpeed;
    private double ceilingMeters;
    private String visibilityMeters;
    public AirportWeather(Builder builder){
        this.icao = builder.icao;
        this.windDirection = builder.windDirection;
        this.windSpeed = builder.windSpeed;
        this.ceilingMeters = builder.ceilingMeters;
        this.visibilityMeters = builder.visibilityMeters;
    }
    public static class Builder{
        private String icao;
        private int windDirection;
        private int windSpeed;
        private double ceilingMeters;
        private String visibilityMeters;
        public Builder icao(String icao){
            this.icao = icao;
            return this;
        }

        public Builder windDirection(int windDirection){
            this.windDirection = windDirection;
            return this;
        }
        public Builder windSpeed(int windSpeed){
            this.windSpeed = windSpeed;
            return this;
        }
        public Builder ceilingMeters(double ceilingMeters){
            this.ceilingMeters = ceilingMeters;
            return this;
        }
        public Builder visibilityMeters(String visibilityMeters){
            this.visibilityMeters = visibilityMeters;
            return this;
        }
        public AirportWeather build(){
            return new AirportWeather(this);
        }
    }

    public String getIcao() {
        return icao;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public double getCeilingMeters() {
        return ceilingMeters;
    }

    public String getVisibilityMeters() {
        return visibilityMeters;
    }
}
