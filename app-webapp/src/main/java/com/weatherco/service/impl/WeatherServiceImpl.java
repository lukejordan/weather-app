package com.weatherco.service.impl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weatherco.AppConfig;
import com.weatherco.domain.Weather;
import com.weatherco.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private AppConfig appConfig;

    @Override
    public String retrieveWeather(String location) {
        // TODO Auto-generated method stub
        System.out.println("You should never sysout ;). Test location: "
                + location);
        return "mock return";
    }

    public Weather retrieveWeatherForCity(String location) {

        System.out.println("url:" + appConfig.getApiUrl());

        String locationToSearch = "";
        if (location != null && location.length() > 0) {
            System.out.println("Location to search for: " + location);
            locationToSearch = location;
        }

        String uri = appConfig.getApiUrl() + "?q=" + locationToSearch
                + "&units=metric&APPID=" + appConfig.getApiKey();
        // System.out.println("realUrl" + uri);

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        JSONObject jsonObj = new JSONObject(result);
        String cityName = jsonObj.getString("name");

        JSONArray weatherArray = jsonObj.getJSONArray("weather");

        Weather weather = new Weather();

        if (weatherArray.length() > 0) {
            JSONObject weatherObject = weatherArray.getJSONObject(0);
            String description = weatherObject.getString("main");
            weather.setDescription(description);
        }

        JSONObject main = jsonObj.getJSONObject("main");
        JSONObject sys = jsonObj.getJSONObject("sys");

        int sunriseTime = sys.getInt("sunrise");
        int sunsetTime = sys.getInt("sunset");

        double temperature = main.getDouble("temp");

        int dateInUtc = jsonObj.getInt("dt");

        weather.setCityName(cityName);
        weather.setDate(dateInUtc);

        weather.setSunrise(sunriseTime);
        weather.setSunset(sunsetTime);
        weather.setTemperature(temperature);

        return weather;
    }

}
