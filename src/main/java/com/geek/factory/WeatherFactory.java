package com.geek.factory;

import com.geek.model.Weather;

public class WeatherFactory {
    public static Weather createWeather(String weatherType) {
        if (weatherType == null || weatherType.isBlank() || weatherType.isEmpty())
            return null;

        switch (weatherType) {
            case "SUNNY": {
                return new Weather("SUNNY", -10);
            }

            case "RAINY": {
                return new Weather("RAINY", 20 );
            }

            case "WINDY": {
                return new Weather("WINDY", 0);
            }

            default:
                return null;
        }
    }

}
