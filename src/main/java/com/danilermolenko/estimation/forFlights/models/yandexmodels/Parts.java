package com.danilermolenko.estimation.forFlights.models.yandexmodels;

public class Parts {

    private String part_name;
    private int temp_min;
    private int temp_max;
    private int temp_avg;
    private int feels_like;
    private String icon;
    private String condition;
    private String daytime;
    private boolean polar;
    private double wind_speed;
    private double wind_gust;
    private String wind_dir;
    private int pressure_nm;
    private int pressure_pa;
    private int humidity;
    private int prec_nm;
    private int prec_period;
    private int prec_prob;

    public Parts(String part_name, int temp_min, int temp_max, int temp_avg, int feels_like, String icon, String condition, String daytime, boolean polar, int wind_speed, int wind_gust, String wind_dir, int pressure_nm, int pressure_pa, int humidity, int prec_nm, int prec_period, int prec_prob) {
        this.part_name = part_name;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.temp_avg = temp_avg;
        this.feels_like = feels_like;
        this.icon = icon;
        this.condition = condition;
        this.daytime = daytime;
        this.polar = polar;
        this.wind_speed = wind_speed;
        this.wind_gust = wind_gust;
        this.wind_dir = wind_dir;
        this.pressure_nm = pressure_nm;
        this.pressure_pa = pressure_pa;
        this.humidity = humidity;
        this.prec_nm = prec_nm;
        this.prec_period = prec_period;
        this.prec_prob = prec_prob;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public int getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(int temp_min) {
        this.temp_min = temp_min;
    }

    public int getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(int temp_max) {
        this.temp_max = temp_max;
    }

    public int getTemp_avg() {
        return temp_avg;
    }

    public void setTemp_avg(int temp_avg) {
        this.temp_avg = temp_avg;
    }

    public int getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(int feels_like) {
        this.feels_like = feels_like;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    public boolean isPolar() {
        return polar;
    }

    public void setPolar(boolean polar) {
        this.polar = polar;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(int wind_speed) {
        this.wind_speed = wind_speed;
    }

    public double getWind_gust() {
        return wind_gust;
    }

    public void setWind_gust(int wind_gust) {
        this.wind_gust = wind_gust;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public int getPressure_nm() {
        return pressure_nm;
    }

    public void setPressure_nm(int pressure_nm) {
        this.pressure_nm = pressure_nm;
    }

    public int getPressure_pa() {
        return pressure_pa;
    }

    public void setPressure_pa(int pressure_pa) {
        this.pressure_pa = pressure_pa;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPrec_nm() {
        return prec_nm;
    }

    public void setPrec_nm(int prec_nm) {
        this.prec_nm = prec_nm;
    }

    public int getPrec_period() {
        return prec_period;
    }

    public void setPrec_period(int prec_period) {
        this.prec_period = prec_period;
    }

    public int getPrec_prob() {
        return prec_prob;
    }

    public void setPrec_prob(int prec_prob) {
        this.prec_prob = prec_prob;
    }
}
