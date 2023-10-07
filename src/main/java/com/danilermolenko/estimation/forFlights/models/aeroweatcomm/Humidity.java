package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

public class Humidity {
    private int percent;

    public Humidity(int percent) {
        this.percent = percent;
    }

    public Humidity() {
    }

    public int getPercent() {
        return percent;
    }

    @Override
    public String toString() {
        return "Humidity{" +
                "percent=" + percent +
                '}';
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
