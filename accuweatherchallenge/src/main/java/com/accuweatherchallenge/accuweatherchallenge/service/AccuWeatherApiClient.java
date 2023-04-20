package com.accuweatherchallenge.accuweatherchallenge.service;


import com.accuweatherchallenge.accuweatherchallenge.model.WeatherData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class AccuWeatherApiClient {
    @Value("${accuweather.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;
    private final String BASE_URL = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/";

    public WeatherData getWeatherData(String locationKey) {




        String url = BASE_URL + locationKey + "?apikey=" + apiKey;

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode responseBody = response.getBody();

        JsonNode headline =  responseBody.get("Headline");


        WeatherData weatherData = new WeatherData();
        weatherData.setWeatherText(headline.get("Text").toString());

        return weatherData;


    }
}
