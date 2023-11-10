package com.danilermolenko.estimation.forFlights.calculator;

import com.danilermolenko.estimation.forFlights.entity.Point;

public class Calculator {
    public double findDistance(Point point1, Point point2){
        double lat1 = Double.parseDouble(point1.getLatitude());
        double lat2 = Double.parseDouble(point1.getLongitude());
        double lon1 = Double.parseDouble(point2.getLatitude());
        double lon2 = Double.parseDouble(point2.getLongitude());
        double x = Math.sqrt(Math.pow(Math.sin((lat2 - lat1) / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin((lon2 - lon1)/ 2), 2));
        System.out.println(x);
        double mpu = 2 * Math.asin(x);
        mpu = 6400 * mpu * Math.PI / 180;
        return mpu;
    }
}
