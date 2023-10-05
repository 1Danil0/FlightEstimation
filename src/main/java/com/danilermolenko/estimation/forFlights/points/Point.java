package com.danilermolenko.estimation.forFlights.points;

public class Point {
    private String lat;
    private String lon;

    public Point(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Point() {
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
