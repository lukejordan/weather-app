package com.weatherco.controller;

import java.net.URI;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.weatherco.service.WeatherService;

@RestController
public class WeatherController {

    private static Logger LOGGER = Logger.getLogger(WeatherController.class
            .getName());

    @Autowired
    private WeatherService weatherService;

    @RequestMapping(value = "/weather2/{location}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity getWeatherRest(
            @PathVariable("location") final String location, ModelMap model) {

        LOGGER.info("In test service");

        String response = "default response";

        if (weatherService != null) {
            response = weatherService.retrieveWeather(location);

        }
        else {
            LOGGER.info("Customer repo is null");
        }

        URI location2 = URI.create("http://localhost/moo");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location2);
        responseHeaders.set("MyResponseHeader", "MyValue");

        ResponseEntity<String> responseObj = new ResponseEntity<String>(
                response, responseHeaders, HttpStatus.OK);

        return responseObj;
    }

    @RequestMapping(value = "/persist", method = RequestMethod.POST)
    public ResponseEntity submitWeather() {

        LOGGER.info("test submitted");

        if (weatherService != null) {

        }
        else {
            LOGGER.info("Customer repo is null");
        }

        ResponseEntity response = new ResponseEntity(null, HttpStatus.OK);

        return response;
    }

}
