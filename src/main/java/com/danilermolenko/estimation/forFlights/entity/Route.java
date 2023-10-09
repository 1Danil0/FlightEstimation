package com.danilermolenko.estimation.forFlights.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
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
        if(weather.getPoints() != null) {
            route.setPoints(weather.getPoints().stream().map(x -> x.getPoint())
                    .toList());
            route.getPoints().stream().forEach(point -> point.setRoute(route));
        }
        if(weather.getAlternatives() != null) {
            route.setAlternative(weather.getAlternatives().stream().map(x -> x.getIcao()).toList());
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
        return points;
    }

    public String getDestination() {
        return destination;
    }

    public List<String> getAlternatives() {
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

    public void setAlternative(List<String> alternatives) {
        this.alternatives = alternatives;
    }

    public void setUser(User user) {
        this.user = user;
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
        if(this.alternatives.size() != route.alternatives.size()){
            return false;
        }
        if(this.points.size() != route.points.size()){
            return false;
        }
        for(int i = 0; i < this.alternatives.size(); i++){
            if(!this.alternatives.get(i).equals(route.alternatives.get(i))){
               return false;
            }
        }
        for(int i = 0; i < this.points.size(); i++){
            if(!this.points.get(i).equals(route.points.get(i))){
                return false;
            }
        }
        return this.departure.equals(route.departure) && this.destination.equals(route.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, points, destination, alternatives);
    }
}
