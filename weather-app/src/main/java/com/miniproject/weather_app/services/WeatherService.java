package com.miniproject.weather_app.services;

import com.miniproject.weather_app.clients.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    @Autowired
    Client client;

    public Object getCityTemp(String cityName)
    {
        Object response = client.callThirdPartyWeatherApi(cityName);
        return response;
    }
}
