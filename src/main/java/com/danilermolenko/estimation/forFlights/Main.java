package com.danilermolenko.estimation.forFlights;

import com.danilermolenko.estimation.forFlights.calculator.Calculator;
import com.danilermolenko.estimation.forFlights.communication.AeroWeatherComm;
import com.danilermolenko.estimation.forFlights.entity.Point;
import com.danilermolenko.estimation.forFlights.entity.Route;
import com.danilermolenko.estimation.forFlights.models.aeroweatcomm.AllWeather;
import com.danilermolenko.estimation.forFlights.models.aeroweatcomm.Data;
import com.google.gson.Gson;


import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
//        Calculator calculator = new Calculator();
//        System.out.println(calculator.findDistance(0, 0, 2, 2));

//        Route route1 = new Route();
//        route1.setDeparture("UWKE");
//        route1.setDestination("UUEE");
//        route1.setAlternatives(List.of("ULLI"));
//        route1.setPoints(List.of(new Point("1", "1" ,1 )));
//
//        Route route2 = new Route();
//        route2.setDeparture("UWKE");
//        route2.setDestination("UUEE");
//        route2.setAlternatives(List.of("ULLI"));
//        route2.setPoints(List.of(new Point("1", "1" ,1 )));
//
//        System.out.println(route2.equals(route1));

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter code of aerodrom: ");
//        String code = scanner.next();
//        scanner.close();
//
//
        Gson gson = new Gson();
        AeroWeatherComm aeroWeatherComm = new AeroWeatherComm(gson);

        Data[] data = null;
        AllWeather allWeather = null;

        try {
            allWeather= aeroWeatherComm.getAllWeather("UWKE");
            System.out.println(allWeather.getData()[0].getIcao());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(allWeather);

//        OkHttpClient httpClient = new OkHttpClient().newBuilder().build();
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "");
//        try {
//            Request request = new Request.Builder()
//                    .url("https://api.checkwx.com/metar/" + code + "/decoded")
//                    .addHeader("X-API-Key", "d4329002797b4dac833e8548b5")
//                    .build();
//            Response response = httpClient.newCall(request).execute();
//            AllWeather allWeather1 = gson.fromJson(String.valueOf(response.body()), AllWeather.class);
//            System.out.println(allWeather1);
//        } catch (SocketTimeoutException e){
//            System.out.println(e.getCause());
//        }

//        Unirest.setTimeouts(0, 0);
//        HttpResponse<String> response = Unirest
//                .get("https://api.checkwx.com/metar/" + code + "/decoded")
//                .header("X-API-Key", "d4329002797b4dac833e8548b5")
//                .asString();
//        System.out.println(response.getBody());
    }
}
