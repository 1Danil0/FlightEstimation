package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

public class Barometer {
    private double hg;
    private double hpa;
    private double kpa;
    private double mb;

    public Barometer() {
    }

    public Barometer(double hg, double hpa, double kpa, double mb) {
        this.hg = hg;
        this.hpa = hpa;
        this.kpa = kpa;
        this.mb = mb;
    }

    public double getHg() {
        return hg;
    }

    public double getHpa() {
        return hpa;
    }

    public double getKpa() {
        return kpa;
    }

    public double getMb() {
        return mb;
    }

    @Override
    public String toString() {
        return "Barometer{" +
                "hg=" + hg +
                ", hpa=" + hpa +
                ", kpa=" + kpa +
                ", mb=" + mb +
                '}';
    }

    public void setHg(double hg) {
        this.hg = hg;
    }

    public void setHpa(double hpa) {
        this.hpa = hpa;
    }

    public void setKpa(double kpa) {
        this.kpa = kpa;
    }

    public void setMb(double mb) {
        this.mb = mb;
    }
}
