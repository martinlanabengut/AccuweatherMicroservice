package com.accuweatherchallenge.accuweatherchallenge.controller;

import com.accuweatherchallenge.accuweatherchallenge.model.WeatherData;
import com.accuweatherchallenge.accuweatherchallenge.service.WeatherService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{locationKey}")
    public WeatherData getWeatherData(@PathVariable String locationKey) {
        return weatherService.getWeatherData(locationKey);
    }

}

