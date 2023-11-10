package com.danilermolenko.estimation.forFlights.service;

import com.danilermolenko.estimation.forFlights.calculator.Calculator;
import com.danilermolenko.estimation.forFlights.entity.Point;
import com.danilermolenko.estimation.forFlights.entity.ResultInfo;
import com.danilermolenko.estimation.forFlights.entity.WeatherOnRoute;

import java.util.ArrayList;
import java.util.List;

public class ResultInfoService {
    private Calculator calculator;
    public List<ResultInfo> extractResultInfoFromWeatherOnRoute(WeatherOnRoute weatherOnRoute){
        List<ResultInfo> resultInfoList = new ArrayList<>();
        if(weatherOnRoute.getPoints().isEmpty()){
            Point point1 = new Point();
//            ResultInfo resultInfo = calculateResultInfo()
//            resultInfoList.
        }
        return null;
    }
    public ResultInfo calculateResultInfo(Point point1, Point point2){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setPoint1(point1);
        resultInfo.setPoint2(point2);
        resultInfo.setDistance((int)calculator.findDistance(point1, point2));
        return resultInfo;
    }
}
