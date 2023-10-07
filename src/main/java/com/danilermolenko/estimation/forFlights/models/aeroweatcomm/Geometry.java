package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

import java.util.Arrays;

public class Geometry {
    private double[] coordinates;
    private String type;

    public Geometry(double[] coordinates, String type) {
        this.coordinates = coordinates;
        this.type = type;
    }

    public Geometry() {
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "coordinates=" + Arrays.toString(coordinates) +
                ", type='" + type + '\'' +
                '}';
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public void setType(String type) {
        this.type = type;
    }
}
