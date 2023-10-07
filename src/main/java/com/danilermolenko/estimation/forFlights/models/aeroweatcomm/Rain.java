package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

public class Rain {
    private double inches;
    private double millimeters;
    private double total_inches;
    private double total_millimeters;

    public Rain(double inches, double millimeters, double total_inches, double total_millimeters) {
        this.inches = inches;
        this.millimeters = millimeters;
        this.total_inches = total_inches;
        this.total_millimeters = total_millimeters;
    }

    public Rain() {
    }

    public double getInches() {
        return inches;
    }

    public double getMillimeters() {
        return millimeters;
    }

    public double getTotal_inches() {
        return total_inches;
    }

    public double getTotal_millimeters() {
        return total_millimeters;
    }

    @Override
    public String toString() {
        return "Rain{" +
                "inches=" + inches +
                ", millimeters=" + millimeters +
                ", total_inches=" + total_inches +
                ", total_millimeters=" + total_millimeters +
                '}';
    }

    public void setInches(double inches) {
        this.inches = inches;
    }

    public void setMillimeters(double millimeters) {
        this.millimeters = millimeters;
    }

    public void setTotal_inches(double total_inches) {
        this.total_inches = total_inches;
    }

    public void setTotal_millimeters(double total_millimeters) {
        this.total_millimeters = total_millimeters;
    }
}
