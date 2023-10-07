package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

public class Visibility {
    private String meters;
    private float meters_float;
    private String miles;
    private float miles_float;

    public Visibility() {
    }

    public Visibility(String meters, float meters_float, String miles, float miles_float) {
        this.meters = meters;
        this.meters_float = meters_float;
        this.miles = miles;
        this.miles_float = miles_float;
    }

    public String getMeters() {
        return meters;
    }

    public float getMeters_float() {
        return meters_float;
    }

    public String getMiles() {
        return miles;
    }

    public float getMiles_float() {
        return miles_float;
    }

    @Override
    public String toString() {
        return "Visibility{" +
                "meters='" + meters + '\'' +
                ", meters_float=" + meters_float +
                ", miles='" + miles + '\'' +
                ", miles_float=" + miles_float +
                '}';
    }

    public void setMeters(String meters) {
        this.meters = meters;
    }

    public void setMeters_float(float meters_float) {
        this.meters_float = meters_float;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    public void setMiles_float(float miles_float) {
        this.miles_float = miles_float;
    }
}
