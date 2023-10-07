package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

public class Conditions {
    private String code;
    private String text;

    public Conditions(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public Conditions() {
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Conditions{" +
                "code='" + code + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setText(String text) {
        this.text = text;
    }
}
