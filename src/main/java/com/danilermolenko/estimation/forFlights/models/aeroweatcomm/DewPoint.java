package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

public class DewPoint {
    private int celsius;
    private int fahrenheit;

    public DewPoint() {
    }

    public DewPoint(int celsius, int fahrenheit) {
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }

    public int getCelsius() {
        return celsius;
    }

    public int getFahrenheit() {
        return fahrenheit;
    }

    @Override
    public String toString() {
        return "DewPoint{" +
                "celsius=" + celsius +
                ", fahrenheit=" + fahrenheit +
                '}';
    }

    public void setCelsius(int celsius) {
        this.celsius = celsius;
    }

    public void setFahrenheit(int fahrenheit) {
        this.fahrenheit = fahrenheit;
    }
}
