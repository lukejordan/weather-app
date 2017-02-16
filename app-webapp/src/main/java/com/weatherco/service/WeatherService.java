package com.weatherco.service;

import com.weatherco.domain.Weather;

public interface WeatherService {

    public String retrieveWeather(String location);

    public Weather retrieveWeatherForCity(String location);

}
