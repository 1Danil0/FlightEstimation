package com.danilermolenko.estimation.forFlights.entity;

public class ResultInfo {
    private Point point1;
    private Point point2;
    private int assignedCoarse;
    private int factCoarse;
    private int distance;

    public ResultInfo() {
    }


    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public int getAssignedCoarse() {
        return assignedCoarse;
    }

    public void setAssignedCoarse(int assignedCoarse) {
        this.assignedCoarse = assignedCoarse;
    }

    public int getFactCoarse() {
        return factCoarse;
    }

    public void setFactCoarse(int factCoarse) {
        this.factCoarse = factCoarse;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
