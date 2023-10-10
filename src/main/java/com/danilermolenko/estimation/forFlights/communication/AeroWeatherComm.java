package com.danilermolenko.estimation.forFlights.communication;

import com.danilermolenko.estimation.forFlights.models.aeroweatcomm.AllWeather;
import com.danilermolenko.estimation.forFlights.models.aeroweatcomm.Data;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Component
public class AeroWeatherComm {
    private final Gson gson;
    @Autowired
    public AeroWeatherComm(Gson gson) {
        this.gson = gson;
    }

    private static String KEY = "d4329002797b4dac833e8548b5";
    private static final String URL = "https://api.checkwx.com/metar/";
    private static final String HEADER = "X-API-Key";
    private static final String SUFFIX = "/decoded";

    private HttpRequest getHttpRequest(String code) throws URISyntaxException {
        StringBuilder builder = new StringBuilder();
        builder.append(URL + code + SUFFIX);
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI(builder.toString()))
                .header(HEADER, KEY)
                .build();
        return getRequest;
    }
    private HttpResponse<String> getHttpResponse(String code) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest getRequest = getHttpRequest(code);

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(
                getRequest, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    public AllWeather getAllWeather(String code) throws URISyntaxException, IOException, InterruptedException {
        HttpResponse<String> response = getHttpResponse(code);
        return gson.fromJson(response.body(), AllWeather.class);
    }
}
