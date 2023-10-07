package com.danilermolenko.estimation.forFlights.models.yandexmodels;

public class Forecast {
    private String date;
    private int date_ts;
    private int week;
    private String sunrise;
    private String sunset;
    private int moon_code;
    private String moon_text;
    private Parts[] parts;
    public Forecast(){}

    public Forecast(String date, int date_ts, int week, String sunrise, String sunset, int moon_code, String moon_text, Parts[] parts) {
        this.date = date;
        this.date_ts = date_ts;
        this.week = week;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.moon_code = moon_code;
        this.moon_text = moon_text;
        this.parts = parts;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDate_ts() {
        return date_ts;
    }

    public void setDate_ts(int date_ts) {
        this.date_ts = date_ts;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public int getMoon_code() {
        return moon_code;
    }

    public void setMoon_code(int moon_code) {
        this.moon_code = moon_code;
    }

    public String getMoon_text() {
        return moon_text;
    }

    public void setMoon_text(String moon_text) {
        this.moon_text = moon_text;
    }

    public Parts[] getParts() {
        return parts;
    }

    public void setParts(Parts[] parts) {
        this.parts = parts;
    }
}
