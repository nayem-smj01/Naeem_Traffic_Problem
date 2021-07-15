package com.geek.factory;

import com.geek.WEATHER;
import com.geek.model.Vehicle;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleType) {
        if (vehicleType == null || vehicleType.isBlank() || vehicleType.isEmpty())
            return null;

        switch (vehicleType) {
            case "TUKTUK": {
                return new Vehicle("TUKTUK", 12, 1, WEATHER.WINDY.getWeatherType());
            }

            case "BIKE": {
                return new Vehicle("BIKE", 10, 2, WEATHER.RAINY.getWeatherType());
            }

            case "CAR": {
                return new Vehicle("CAR", 20, 3);
            }

            default:
                return null;
        }
    }

}
