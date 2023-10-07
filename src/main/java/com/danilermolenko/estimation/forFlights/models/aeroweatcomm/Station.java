package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

public class Station {
    private Geometry geometry;
    private String location;
    private String name;
    private String type;

    public Station(Geometry geometry, String location, String name, String type) {
        this.geometry = geometry;
        this.location = location;
        this.name = name;
        this.type = type;
    }

    public Station() {
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Station{" +
                "geometry=" + geometry +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
