package com.danilermolenko.estimation.forFlights.communication;

import com.danilermolenko.estimation.forFlights.models.Weather;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
@Component
public class Communication {
    private final String HEADER = "X-Yandex-API-Key";
    private  final String KEY = "0bd5a0ad-b6d5-40c2-86ab-bebcf07940b0";


    private HttpRequest getHttpRequest(String lat, String lon) throws URISyntaxException {
        String url = "https://api.weather.yandex.ru/v2/informers?" + "lat=" + lat + "&lon=" + lon;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header(HEADER, KEY)
                .build();
        return request;
    }
    public Weather getWeather(String lat, String lon) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest request = getHttpRequest(lat, lon);

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), Weather.class);
    }

}
