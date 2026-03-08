package com.miniproject.weather_app.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Client {

    @Value("${weather.api.base:https://api.weatherapi.com/v1/current.json}")
    private String apiBase;

    @Value("${weather.api.key:}")
    private String apiKey;

    public Object callThirdPartyWeatherApi(String cityName)
    {
        // Build the endpoint from configured base and key
        String endPoint = String.format("%s?key=%s&q=%s", apiBase, apiKey, cityName);

    RequestEntity<Void> request = RequestEntity.get(endPoint).build(); // our request is created here

    RestTemplate restTemplate = new RestTemplate();

    ResponseEntity<Object> response = restTemplate.exchange(endPoint, HttpMethod.GET, request, Object.class);

        // here request is executed just like send button on postman

        return response.getBody();
    }
}
