package com.weatherco.weatherco.service;

import com.weatherco.weatherco.domain.Weather;

public interface WeatherService {

    public String retrieveWeather(String location);

    public Weather retrieveWeatherForCity(String location);

}
