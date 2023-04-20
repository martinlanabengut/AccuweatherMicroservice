package com.accuweatherchallenge.accuweatherchallenge.service;

import com.accuweatherchallenge.accuweatherchallenge.model.WeatherData;
import com.accuweatherchallenge.accuweatherchallenge.repository.WeatherDataRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherService {
    @Autowired
    private WeatherDataRepository weatherDataRepository;
    @Autowired
    private AccuWeatherApiClient accuWeatherApiClient;
    public WeatherData getWeatherData(String locationKey) {
        WeatherData weatherData = accuWeatherApiClient.getWeatherData(locationKey);


        weatherDataRepository.save(weatherData);
        return weatherData;
    }


}


