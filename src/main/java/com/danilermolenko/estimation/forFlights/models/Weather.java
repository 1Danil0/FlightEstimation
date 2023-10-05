package com.danilermolenko.estimation.forFlights.models;

public class Weather {
    private long now;
    private String now_dt;
    private Info info;
    private Fact fact;
    private Forecast forecast;
    public Weather(){}

    public Weather(long now, String now_dt, Info info, Fact fact, Forecast forecast) {
        this.now = now;
        this.now_dt = now_dt;
        this.info = info;
        this.fact = fact;
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "now=" + now +
                ", now_dt='" + now_dt + '\'' +
                ", info=" + info +
                ", fact=" + fact +
                ", forecast=" + forecast +
                '}';
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public String getNow_dt() {
        return now_dt;
    }

    public void setNow_dt(String now_dt) {
        this.now_dt = now_dt;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Fact getFact() {
        return fact;
    }

    public void setFact(Fact fact) {
        this.fact = fact;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
