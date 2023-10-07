package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

public class Clouds {
    private double base_feet_agl;
    private double base_meters_agl;
    private String code;
    private double feet;
    private double meters;
    private String text;

    public Clouds() {
    }

    public Clouds(double base_feet_agl, double base_meters_agl, String code, double feet, double meters, String text) {
        this.base_feet_agl = base_feet_agl;
        this.base_meters_agl = base_meters_agl;
        this.code = code;
        this.feet = feet;
        this.meters = meters;
        this.text = text;
    }

    public double getBase_feet_agl() {
        return base_feet_agl;
    }

    public double getBase_meters_agl() {
        return base_meters_agl;
    }

    public String getCode() {
        return code;
    }

    public double getFeet() {
        return feet;
    }

    public double getMeters() {
        return meters;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "base_feet_agl=" + base_feet_agl +
                ", base_meters_agl=" + base_meters_agl +
                ", code='" + code + '\'' +
                ", feet=" + feet +
                ", meters=" + meters +
                ", text='" + text + '\'' +
                '}';
    }

    public void setBase_feet_agl(double base_feet_agl) {
        this.base_feet_agl = base_feet_agl;
    }

    public void setBase_meters_agl(double base_meters_agl) {
        this.base_meters_agl = base_meters_agl;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setFeet(double feet) {
        this.feet = feet;
    }

    public void setMeters(double meters) {
        this.meters = meters;
    }

    public void setText(String text) {
        this.text = text;
    }
}
