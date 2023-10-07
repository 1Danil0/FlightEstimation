package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

public class Wind {
    private int degrees;
    private int speed_kph;
    private int speed_kts;
    private int speed_mph;
    private int speed_mps;
    private int gust_kts;
    private int gust_kph;
    private int gust_mph;
    private int gust_mps;

    public Wind(int degrees, int speed_kph, int speed_kts, int speed_mph, int speed_mps, int gust_kts, int gust_kph, int gust_mph, int gust_mps) {
        this.degrees = degrees;
        this.speed_kph = speed_kph;
        this.speed_kts = speed_kts;
        this.speed_mph = speed_mph;
        this.speed_mps = speed_mps;
        this.gust_kts = gust_kts;
        this.gust_kph = gust_kph;
        this.gust_mph = gust_mph;
        this.gust_mps = gust_mps;
    }

    public Wind() {
    }

    public int getDegrees() {
        return degrees;
    }

    public int getSpeed_kph() {
        return speed_kph;
    }

    public int getSpeed_kts() {
        return speed_kts;
    }

    public int getSpeed_mph() {
        return speed_mph;
    }

    public int getSpeed_mps() {
        return speed_mps;
    }

    public int getGust_kts() {
        return gust_kts;
    }

    public int getGust_kph() {
        return gust_kph;
    }
    public int getGust_mph() {
        return gust_mph;
    }
    public int getGust_mps() {
        return gust_mps;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "degrees=" + degrees +
                ", speed_kph=" + speed_kph +
                ", speed_kts=" + speed_kts +
                ", speed_mph=" + speed_mph +
                ", speed_mps=" + speed_mps +
                ", gust_kts=" + gust_kts +
                ", gust_kph=" + gust_kph +
                ", gust_mph=" + gust_mph +
                ", gust_mps=" + gust_mps +
                '}';
    }

    public void setDegrees(int degrees) {
        this.degrees = degrees;
    }

    public void setSpeed_kph(int speed_kph) {
        this.speed_kph = speed_kph;
    }

    public void setSpeed_kts(int speed_kts) {
        this.speed_kts = speed_kts;
    }

    public void setSpeed_mph(int speed_mph) {
        this.speed_mph = speed_mph;
    }

    public void setSpeed_mps(int speed_mps) {
        this.speed_mps = speed_mps;
    }

    public void setGust_kts(int gust_kts) {
        this.gust_kts = gust_kts;
    }

    public void setGust_kph(int gust_kph) {
        this.gust_kph = gust_kph;
    }

    public void setGust_mph(int gust_mph) {
        this.gust_mph = gust_mph;
    }

    public void setGust_mps(int gust_mps) {
        this.gust_mps = gust_mps;
    }
}
