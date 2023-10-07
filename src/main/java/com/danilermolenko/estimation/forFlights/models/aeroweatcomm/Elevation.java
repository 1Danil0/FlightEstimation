package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

public class Elevation {
    private double feet;
    private double meters;
    public Elevation(){}

    public Elevation(double feet, double meters) {
        this.feet = feet;
        this.meters = meters;
    }

    public double getFeet() {
        return feet;
    }

    public double getMeters() {
        return meters;
    }

    @Override
    public String toString() {
        return "Elevation{" +
                "feet=" + feet +
                ", meters=" + meters +
                '}';
    }

    public void setFeet(double feet) {
        this.feet = feet;
    }

    public void setMeters(double meters) {
        this.meters = meters;
    }
}
