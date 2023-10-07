package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

public class Temperature {
    private int celsius;
    private int fahrenheit;

    public Temperature(int celsius, int fahrenheit) {
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }

    public Temperature() {
    }

    public int getCelsius() {
        return celsius;
    }

    public int getFahrenheit() {
        return fahrenheit;
    }

    @Override
    public String toString() {
        return "Temperature{" +
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
