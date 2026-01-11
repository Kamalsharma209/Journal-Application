package com.example.journalApp.service;

import com.example.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    private static final  String apiKey = "55e72d58496b3308cf51cc9bd0093f37";

    private static final String API ="ttp://api.weatherstack.com/current?access_key=API_KEY&query=CITY";


    private RestTemplate restTemplate;

    public WeatherResponse getWeather(String city){
        String finalAPI= API.replace("CITY","city").replace("API_KEY",apiKey);
        ResponseEntity<WeatherResponse> resposnse = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = resposnse.getBody();
        return body;
    }
}
