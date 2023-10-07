package com.danilermolenko.estimation.forFlights.models.aeroweatcomm;

import java.util.Arrays;

public class AllWeather {
    private Data[] data;
    private int results;

    public AllWeather() {
    }

    public AllWeather(Data[] data, int results) {
        this.data = data;
        this.results = results;
    }

    public Data[] getData() {
        return data;
    }

    public int getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "AllWeather{" +
                "data=" + Arrays.toString(data) +
                ", results=" + results +
                '}';
    }

    public void setData(Data[] data) {
        this.data = data;
    }

    public void setResults(int results) {
        this.results = results;
    }
}
