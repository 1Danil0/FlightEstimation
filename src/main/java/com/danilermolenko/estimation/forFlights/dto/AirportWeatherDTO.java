package com.danilermolenko.estimation.forFlights.dto;

public class AirportWeatherDTO {
    private String icao;

    public AirportWeatherDTO(String icao) {
        this.icao = icao;
    }

    public AirportWeatherDTO() {
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }
}
