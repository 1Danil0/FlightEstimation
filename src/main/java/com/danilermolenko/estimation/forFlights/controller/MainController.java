package com.danilermolenko.estimation.forFlights.controller;

import com.danilermolenko.estimation.forFlights.dto.AirportWeatherDTO;
import com.danilermolenko.estimation.forFlights.entity.Point;
import com.danilermolenko.estimation.forFlights.entity.User;
import com.danilermolenko.estimation.forFlights.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.Principal;

@Controller
public class MainController {
    private final RouteService routeService;
    private final UnregisteredRouteService unregisteredRouteService;
    private final UserService userService;
    private final OnRouteWeatherService onRouteWeatherService;
    @Autowired
    public MainController(RouteService routeService, UnregisteredRouteService unregisteredRouteService, UserService userService, OnRouteWeatherService onRouteWeatherService) {
        this.routeService = routeService;
        this.unregisteredRouteService = unregisteredRouteService;
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
            unregisteredRouteService.setDeparture(airportWeatherDTO.getIcao());
            return "redirect:/points";
        }
        setVariables(model, principal);
        model.addAttribute("errorDepAero", "you may entered a wrong ICAO code of Departure or it is a connection problem");
        return "main-page";
    }
    @PostMapping("/saveDestAero")
    public String saveDestAero(AirportWeatherDTO airportWeatherDTO, Model model, Principal principal){
        if(onRouteWeatherService.setDestination(airportWeatherDTO.getIcao())){
            unregisteredRouteService.setDestination(airportWeatherDTO.getIcao());
            return "redirect:/points";
        }
        setVariables(model, principal);
        model.addAttribute("errorDestAero", "you may entered a wrong ICAO code of Destination or it is a connection problem");
        return "main-page";
    }
    @PostMapping("/saveAlternative")
    public String saveAlternative(AirportWeatherDTO airportWeatherDTO, Model model, Principal principal){
        if(onRouteWeatherService.addAlternative(airportWeatherDTO.getIcao())){
            unregisteredRouteService.addAlternative(airportWeatherDTO.getIcao());
            return "redirect:/points";
        }
        setVariables(model, principal);
        model.addAttribute("errorAltnAero", "you may entered a wrong ICAO code of Alternative or it is a connection problem");
        return "main-page";
    }
    @PostMapping("/add")
    public String addPoint(Point point) throws IOException, URISyntaxException, InterruptedException {
        if(onRouteWeatherService.addPoint(point)){
            unregisteredRouteService.addPoint(point);
        }
        return "redirect:/points";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        onRouteWeatherService.deletePoint(id);
        unregisteredRouteService.deletePoint(id);
        return "redirect:/points";
    }
    @GetMapping("/show")
    public String estimate(Model model,Principal principal){
        User user = userService.getUserFromPrincipal(principal);
        if(user.getUsername() != null){
            user.addRoute(unregisteredRouteService.getRoute());
            userService.save(user);
        }
        unregisteredRouteService.toNull();
        onRouteWeatherService.toNull();
        model.addAttribute("departure", onRouteWeatherService.getDeparture());
        model.addAttribute("points", onRouteWeatherService.getPoints());
        return "route-page";
    }
}
