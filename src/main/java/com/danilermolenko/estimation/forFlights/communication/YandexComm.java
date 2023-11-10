package com.danilermolenko.estimation.forFlights.communication;

import com.danilermolenko.estimation.forFlights.models.yandexmodels.Weather;
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
import java.net.http.HttpResponse.BodyHandlers;
@Component
public class YandexComm {
    private final Gson gson;
    @Autowired
    public YandexComm(Gson gson){
        this.gson = gson;
    }
    private static final String HEADER = "X-Yandex-API-Key";
    private static  String KEY = "key";

    private HttpRequest getHttpRequest(String lat, String lon) throws URISyntaxException {
        String url = "https://api.weather.yandex.ru/v2/informers?" + "lat=" + lat + "&lon=" + lon;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header(HEADER, KEY)
                .build();
        return request;
    }
    private HttpResponse<String> getHttpResponse(String lat, String lon) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = getHttpRequest(lat, lon);

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        return response;
    }
    public Weather getWeather(String lat, String lon) throws IOException, InterruptedException, URISyntaxException {
        HttpResponse<String> response = getHttpResponse(lat, lon);
        return gson.fromJson(response.body(), Weather.class);
    }
}
