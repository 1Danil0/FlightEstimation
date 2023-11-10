package com.danilermolenko.estimation.forFlights.entity;

import com.danilermolenko.estimation.forFlights.weather.AirportWeather;
import com.danilermolenko.estimation.forFlights.weather.WeatherInPoint;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "departure")
    private String departure;
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "route")
    private List<Point> points;
    @Column(name = "destination")
    private String destination;
    @ElementCollection
    @CollectionTable(name = "route_alternative", joinColumns = @JoinColumn(name = "route_id"))
    private List<String> alternatives;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private User user;

    public Route() {
    }
    public static Route valueOf(WeatherOnRoute weather){
        Route route = new Route();
        route.setDeparture(weather.getDeparture().getIcao());
        route.setDestination(weather.getDestination().getIcao());
        route.setPoints(new ArrayList<>());
        if(weather.getPoints() != null) {
            Iterator<WeatherInPoint> points = weather.getPoints().iterator();
            while (points.hasNext()){
                Point point = points.next().getPoint();
                route.addPoint(new Point(point.getLatitude(), point.getLongitude(), point.getAltitude()));
            }
        }
        route.setAlternatives(new ArrayList<>());
        if(weather.getAlternatives() != null) {
            Iterator<AirportWeather> alternatives = weather.getAlternatives().iterator();
            while (alternatives.hasNext()){
                String alternative = alternatives.next().getIcao();
                route.addAlternative(alternative);
            }
        }
        return route;
    }

    public Route(String departure, List<Point> points, String destination, List<String> alternatives, User user) {
        this.departure = departure;
        this.points = points;
        this.destination = destination;
        this.alternatives = alternatives;
        this.user = user;
    }

    public String getDeparture() {
        return departure;
    }

    public List<Point> getPoints() {
        if(points == null){
            return new ArrayList<>();
        }
        return points;
    }

    public String getDestination() {
        return destination;
    }

    public List<String> getAlternatives() {
        if(alternatives == null){
            return new ArrayList<>();
        }
        return alternatives;
    }

    public User getUser() {
        return user;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setAlternatives(List<String> alternatives) {
        this.alternatives = alternatives;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }
    public void addPoint(Point point){
        if(points == null){
            points = new ArrayList<>();
        }
        points.add(point);
        point.setRoute(this);
    }
    public void addAlternative(String alternative){
        if(alternatives == null){
            alternatives = new ArrayList<>();
        }
        alternatives.add(alternative);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", points=" + points +
                ", destination='" + destination + '\'' +
                ", alternatives=" + alternatives +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(departure, route.departure)
                && Objects.equals(points, route.points)
                && Objects.equals(destination, route.destination)
                && Objects.equals(alternatives, route.alternatives);
    }
    @Override
    public int hashCode() {
        return Objects.hash(departure, points, destination, alternatives);
    }
}
