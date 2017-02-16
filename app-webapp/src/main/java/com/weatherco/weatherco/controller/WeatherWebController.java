package com.weatherco.weatherco.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.weatherco.weatherco.domain.Weather;
import com.weatherco.weatherco.service.WeatherService;

@Controller
public class WeatherWebController {

    private static Logger LOGGER = Logger.getLogger(WeatherWebController.class
            .getName());

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/weather/{location}", method = RequestMethod.GET)
    public String testRetrieveFromDb(
            @PathVariable("location") final String location, ModelMap model) {

        LOGGER.info("In test service");

        if (weatherService != null) {
            Weather weather = weatherService.retrieveWeatherForCity(location);
            model.put("weather", weather);
        }
        else {
            LOGGER.error("Should ideally throw exception here. 404, not found.");
        }

        return "search-results";
    }

    @RequestMapping(value = "/weather", method = RequestMethod.POST)
    public String testPersist(@RequestBody String locationParam, ModelMap model) {
        // public String testPersist(@ModelAttribute String location, ModelMap
        // model) {

        LOGGER.info("In test service, location:" + locationParam);
        String location = locationParam.replace("location=", "").replace("+",
                " ");

        if (weatherService != null) {
            Weather weather = weatherService.retrieveWeatherForCity(location);
            model.put("weather", weather);
        }
        else {
            LOGGER.error("Should ideally throw exception here. 404, not found.");
        }

        return "search-results";
    }

}
