package com.geek;

public enum WEATHER {
    RAINY("Rainy"),
    WINDY("Windy"),
    SUNNY("Sunny");

    public String getWeatherType() {
        return weatherType;
    }

    WEATHER(String weatherType) {
        this.weatherType = weatherType;
    }

    String weatherType;
}
