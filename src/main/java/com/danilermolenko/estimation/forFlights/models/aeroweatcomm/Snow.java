package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

public class Snow {
    private int inches;
    private int millimeters;

    public Snow(int inches, int millimeters) {
        this.inches = inches;
        this.millimeters = millimeters;
    }

    public Snow() {
    }

    public int getInches() {
        return inches;
    }
    public int getMillimeters() {
        return millimeters;
    }

    @Override
    public String toString() {
        return "Snow{" +
                "inches=" + inches +
                ", millimeters=" + millimeters +
                '}';
    }

    public void setInches(int inches) {
        this.inches = inches;
    }

    public void setMillimeters(int millimeters) {
        this.millimeters = millimeters;
    }
}
