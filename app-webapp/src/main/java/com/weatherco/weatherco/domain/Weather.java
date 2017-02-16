package com.weatherco.weatherco.domain;

import com.weatherco.weatherco.utils.Utils;


public class Weather {

    private String cityName;
    
    private String description;
    
    private double temperature;
    
    private int sunrise;
    
    private int sunset;
    
    private int date;
    
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public double getTemperature() {
        return temperature;
    }

    public double getFarenheitTemperature() {
        return Utils.convertToFarenheit(temperature);
    }

    
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    
    public String getSunrise() {
        //return Utils.getDisplayTime(sunrise);
        return Utils.getDisplayDate(sunrise);
    }

    
    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return Utils.getDisplayDate(sunset);
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }

    public String getDate() {
        return Utils.getDisplayDate(date);
    }
    
    public void setDate(int date) {
        this.date = date;
    }

}
