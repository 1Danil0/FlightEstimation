package com.danilermolenko.estimation.forFlights.controller;

import com.danilermolenko.estimation.forFlights.points.Point;
import com.danilermolenko.estimation.forFlights.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class Contr {
    private final RouteService service;
    @Autowired
    public Contr(RouteService service) {
        this.service = service;
    }


    @GetMapping("/points")
    public String setRoute(Model model){
        model.addAttribute("points", service.getRoute());
        return "main-page";
    }
    @PostMapping("/add")
    public String addPoint(Point point) throws IOException, URISyntaxException, InterruptedException {
        service.addPoint(point);
        return "redirect:/points";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        service.deletePoint(id);
        return "redirect:/points";
    }
    @GetMapping("/show")
    public String estimate(Model model){
        model.addAttribute("points", service.getRoute());
        return "route-page";
    }
}
