package com.miniproject.weather_app.controllers;

import com.miniproject.weather_app.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;
    @GetMapping("/temp")
    public Object getCityTemp(@RequestParam String cityName)
    {
        return weatherService.getCityTemp(cityName);
    }
}
