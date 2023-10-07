package com.danilermolenko.estimation.forFlights.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "routes")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "departure")
    private String departure;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "route_points",
    joinColumns = @JoinColumn(name = "route_id"),
    inverseJoinColumns = @JoinColumn(name = "point_id"))
    private List<Point> points;
    @Column(name = "destination")
    private String destination;
    @ElementCollection
    @CollectionTable(name = "route_alternative", joinColumns = @JoinColumn(name = "route_id"))
    private List<String> alternatives;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private User user;

    public Route() {
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

    public void addPoint(Point point) {
        if(this.points == null){
            this.points = new ArrayList<>();
        }
        this.points.add(point);
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void addAlternative(String alternative) {
        if(this.alternatives == null){
            this.alternatives = new ArrayList<>();
        }
        this.alternatives.add(alternative);
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
                ", user=" + user +
                '}';
    }
}
