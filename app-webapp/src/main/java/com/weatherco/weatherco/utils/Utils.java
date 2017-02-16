package com.weatherco.weatherco.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.weatherco.AppConstants;

public class Utils {

    public static String getDisplayDate(int unixDate) {
        Date date = new Date(unixDate * 1000L); // *1000 is to convert seconds
                                                // to milliseconds
        SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.DATE_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone(AppConstants.TIMEZONE));
        // sdf.setTimeZone(TimeZone.getTimeZone("GMT-4"));

        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public static String getDisplayTime(int unixDate) {
        Date date = new Date(unixDate * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.TIME_FORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone(AppConstants.TIMEZONE));

        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public static double convertToFarenheit(double celciusTemperature) {
        return celciusTemperature
                * AppConstants.CELCIUS_TO_FARENHEIT_CONVERSION_MULTIPLIER;
    }
}
