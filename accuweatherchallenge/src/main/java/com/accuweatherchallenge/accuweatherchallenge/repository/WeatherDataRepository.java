package com.accuweatherchallenge.accuweatherchallenge.repository;

import com.accuweatherchallenge.accuweatherchallenge.model.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
}


