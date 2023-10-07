package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

import java.util.Arrays;

public class Data {
    private Barometer barometer;
    private Ceiling ceiling;
    private Clouds[] clouds;
    private Conditions[] conditions;
    private DewPoint dewPoint;
    private Elevation elevation;
    private String flightCategory;
    private Humidity humidity;
    private String icao;
    private String observed;
    private Snow snow;
    private Station station;
    private Temperature temperature;
    private Rain rain;
    private String row_text;
    private Visibility visibility;
    private Wind wind;



    public Data() {
    }

    public Data(Barometer barometer, Ceiling ceiling, Clouds[] clouds, Conditions[] conditions, DewPoint dewPoint, Elevation elevation, String flightCategory, Humidity humidity, String icao, String observed, Snow snow, Station station, Temperature temperature, Rain rain, String row_text, Visibility visibility, Wind wind) {
        this.barometer = barometer;
        this.ceiling = ceiling;
        this.clouds = clouds;
        this.conditions = conditions;
        this.dewPoint = dewPoint;
        this.elevation = elevation;
        this.flightCategory = flightCategory;
        this.humidity = humidity;
        this.icao = icao;
        this.observed = observed;
        this.snow = snow;
        this.station = station;
        this.temperature = temperature;
        this.rain = rain;
        this.row_text = row_text;
        this.visibility = visibility;
        this.wind = wind;
    }

    public Ceiling getCeiling() {
        return ceiling;
    }

    public Barometer getBarometer() {
        return barometer;
    }

    public Clouds[] getClouds() {
        return clouds;
    }

    public Conditions[] getConditions() {
        return conditions;
    }

    public DewPoint getDewPoint() {
        return dewPoint;
    }

    public Elevation getElevation() {
        return elevation;
    }

    public String getFlightCategory() {
        return flightCategory;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public String getIcao() {
        return icao;
    }

    public String getObserved() {
        return observed;
    }

    public Snow getSnow() {
        return snow;
    }

    public Station getStation() {
        return station;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public Rain getRain() {
        return rain;
    }

    public String getRow_text() {
        return row_text;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    @Override
    public String toString() {
        return "Data{" +
                "barometer=" + barometer +
                ", ceiling=" + ceiling +
                ", clouds=" + Arrays.toString(clouds) +
                ", conditions=" + Arrays.toString(conditions) +
                ", dewPoint=" + dewPoint +
                ", elevation=" + elevation +
                ", flightCategory='" + flightCategory + '\'' +
                ", humidity=" + humidity +
                ", icao='" + icao + '\'' +
                ", observed='" + observed + '\'' +
                ", snow=" + snow +
                ", station=" + station +
                ", temperature=" + temperature +
                ", rain=" + rain +
                ", row_text='" + row_text + '\'' +
                ", visibility=" + visibility +
                ", wind=" + wind +
                '}';
    }

    public void setBarometer(Barometer barometer) {
        this.barometer = barometer;
    }

    public void setCeiling(Ceiling ceiling) {
        this.ceiling = ceiling;
    }

    public void setClouds(Clouds[] clouds) {
        this.clouds = clouds;
    }

    public void setConditions(Conditions[] conditions) {
        this.conditions = conditions;
    }

    public void setDewPoint(DewPoint dewPoint) {
        this.dewPoint = dewPoint;
    }

    public void setElevation(Elevation elevation) {
        this.elevation = elevation;
    }

    public void setFlightCategory(String flightCategory) {
        this.flightCategory = flightCategory;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public void setObserved(String observed) {
        this.observed = observed;
    }

    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public void setRow_text(String row_text) {
        this.row_text = row_text;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
