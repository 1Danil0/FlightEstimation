package com.danilermolenko.estimation.forFlights.controller;

import com.danilermolenko.estimation.forFlights.dto.AirportWeatherDTO;
import com.danilermolenko.estimation.forFlights.entity.Point;
import com.danilermolenko.estimation.forFlights.entity.Route;
import com.danilermolenko.estimation.forFlights.entity.User;
import com.danilermolenko.estimation.forFlights.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class MainController {
    private final RouteService routeService;
    private final UserService userService;
    private final OnRouteWeatherService onRouteWeatherService;
    @Autowired
    public MainController(RouteService routeService, UserService userService, OnRouteWeatherService onRouteWeatherService) {
        this.routeService = routeService;
        this.userService = userService;
        this.onRouteWeatherService = onRouteWeatherService;
    }

    private void setVariables(Model model, Principal principal){
        model.addAttribute("user", userService.getUserFromPrincipal(principal));
        model.addAttribute("departure", onRouteWeatherService.getDeparture());
        model.addAttribute("destination", onRouteWeatherService.getDestination());
        model.addAttribute("alternatives", onRouteWeatherService.getAlternatives());
        model.addAttribute("points", onRouteWeatherService.getPoints());
    }
    @GetMapping("/points")
    public String setRoute(Model model, Principal principal){
        setVariables(model, principal);
        return "main-page";
    }
    @PostMapping("/saveDepAero")
    public String saveDepAero(AirportWeatherDTO airportWeatherDTO, Model model, Principal principal){
        if(onRouteWeatherService.setDeparture(airportWeatherDTO.getIcao())){
            return "redirect:/points";
        }
        setVariables(model, principal);
        model.addAttribute("errorDepAero", "you may entered a wrong ICAO code of Departure or it is a connection problem");
        return "main-page";
    }
    @PostMapping("/saveDestAero")
    public String saveDestAero(AirportWeatherDTO airportWeatherDTO, Model model, Principal principal){
        if(onRouteWeatherService.setDestination(airportWeatherDTO.getIcao())){
            return "redirect:/points";
        }
        setVariables(model, principal);
        model.addAttribute("errorDestAero", "you may entered a wrong ICAO code of Destination or it is a connection problem");
        return "main-page";
    }
    @PostMapping("/saveAlternative")
    public String saveAlternative(AirportWeatherDTO airportWeatherDTO, Model model, Principal principal){
        if(onRouteWeatherService.addAlternative(airportWeatherDTO.getIcao())){
            return "redirect:/points";
        }
        setVariables(model, principal);
        model.addAttribute("errorAltnAero", "you may entered a wrong ICAO code of Alternative or it is a connection problem");
        return "main-page";
    }
    @PostMapping("/add")
    public String addPoint(Point point) {
        onRouteWeatherService.addPoint(point);
        return "redirect:/points";
    }
    @PostMapping("/delete/point/{id}")
    public String delete(@PathVariable("id") int id){
        onRouteWeatherService.deletePoint(id);
        return "redirect:/points";
    }
    @GetMapping("/calculate")
    public String estimate(Model model, Principal principal){
        User user = userService.getUserFromPrincipal(principal);
        Route route = Route.valueOf(onRouteWeatherService.getWeatherOnRoute());
        if(user.getUsername() != null && !user.getRoutes().contains(route)) {
            user.addRoute(route);
            userService.save(user);
        }
        setVariables(model, principal);
        return "calculated-page";
    }
    @GetMapping("/correct")
    public String correct(){
        return "redirect:/points";
    }
    @GetMapping("/newRoute")
    public String createNewRoute(){
        onRouteWeatherService.toNull();
        return "redirect:/points";
    }
    @GetMapping("/load/route/{id}")
    public String estimate(@PathVariable("id") int id, Principal principal){
        User user = userService.getUserFromPrincipal(principal);
        onRouteWeatherService.convertRouteToWeatherOnRoute(user.getRoutes().get(id));
        return "redirect:/points";
    }
    @GetMapping("/show/route/{id}")
    public String showAvailableRoute(@PathVariable("id") int id, Principal principal, Model model){
        User user = userService.getUserFromPrincipal(principal);
        model.addAttribute("route", user.getRoutes().get(id));
        return "route-page";
    }
    @GetMapping("/delete/route/{id}")
    public String deleteRoute(@PathVariable("id") int id, Principal principal){
        User user = userService.getUserFromPrincipal(principal);
        user.getRoutes().remove(id);
        routeService.deleteById(id);
        userService.save(user);
        return "redirect:/user/{id}";
    }
}