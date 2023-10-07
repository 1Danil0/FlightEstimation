//package com.danilermolenko.estimation.forFlights;
//
//import com.danilermolenko.estimation.forFlights.communication.AeroWeatherComm;
//import com.danilermolenko.estimation.forFlights.models.aeroweatcomm.AllWeather;
//import com.danilermolenko.estimation.forFlights.models.aeroweatcomm.Data;
//import com.google.gson.Gson;
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.Unirest;
//import com.mashape.unirest.http.exceptions.UnirestException;
//import okhttp3.*;
//
//import java.io.IOException;
//import java.net.SocketTimeoutException;
//import java.net.URISyntaxException;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) throws IOException, UnirestException {
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter code of aerodrom: ");
//        String code = scanner.next();
//        scanner.close();
//
//
//        Gson gson = new Gson();
//        AeroWeatherComm aeroWeatherComm = new AeroWeatherComm(gson);
//
//        Data[] data = null;
//        AllWeather allWeather = null;
//
//        try {
//            allWeather= aeroWeatherComm.getAllWeather(code);
//            System.out.println(allWeather.getData()[0].getIcao());
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(allWeather);
//
////        OkHttpClient httpClient = new OkHttpClient().newBuilder().build();
////        MediaType mediaType = MediaType.parse("application/json");
////        RequestBody body = RequestBody.create(mediaType, "");
////        try {
////            Request request = new Request.Builder()
////                    .url("https://api.checkwx.com/metar/" + code + "/decoded")
////                    .addHeader("X-API-Key", "d4329002797b4dac833e8548b5")
////                    .build();
////            Response response = httpClient.newCall(request).execute();
////            AllWeather allWeather1 = gson.fromJson(String.valueOf(response.body()), AllWeather.class);
////            System.out.println(allWeather1);
////        } catch (SocketTimeoutException e){
////            System.out.println(e.getCause());
////        }
//
////        Unirest.setTimeouts(0, 0);
////        HttpResponse<String> response = Unirest
////                .get("https://api.checkwx.com/metar/" + code + "/decoded")
////                .header("X-API-Key", "d4329002797b4dac833e8548b5")
////                .asString();
////        System.out.println(response.getBody());
//    }
//}
