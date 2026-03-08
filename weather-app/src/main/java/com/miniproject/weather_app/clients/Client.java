package com.miniproject.weather_app.clients;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Client {

    public Object callThirdPartyWeatherApi(String cityName)
    {
//        7b9a081bbe1e451692081706260803
        String endPoint = "https://api.weatherapi.com/v1/current.json?key=7b9a081bbe1e451692081706260803&q="+ cityName;

        RequestEntity request = RequestEntity.get(endPoint).build(); // our request is created here

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity response = restTemplate.exchange(endPoint, HttpMethod.GET, request, Object.class);

        // here request is executed just like send button on postman

        return response.getBody();
    }
}
