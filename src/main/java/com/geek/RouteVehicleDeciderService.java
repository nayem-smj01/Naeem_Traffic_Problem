package com.geek;

import com.geek.factory.OrbitFactory;
import com.geek.factory.VehicleFactory;
import com.geek.factory.WeatherFactory;
import com.geek.model.Orbit;
import com.geek.model.Vehicle;
import com.geek.model.Weather;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class decides which Orbit and Vehicle is best suited for given input
 */
public class RouteVehicleDeciderService {

    protected String evaluate(List<String> params) {
        if (params.isEmpty() || params.size() < 3)
            return null;

        // Stores sorted results
        Map<Float, String> resultsMap = new TreeMap<>();
        String weatherType = params.get(0).toUpperCase();
        // Create Orbits
        Orbit route1 = OrbitFactory.createOrbit("ORBIT1");
        Orbit route2 = OrbitFactory.createOrbit("ORBIT2");
        route1.setOrbitSpeed(Float.parseFloat(params.get(1)));
        route2.setOrbitSpeed(Float.parseFloat(params.get(2)));

        //Create Vehicles
        Vehicle superCar = VehicleFactory.createVehicle("CAR");
        Vehicle tuktuk = VehicleFactory.createVehicle("TUKTUK");
        Vehicle bike = VehicleFactory.createVehicle("BIKE");

        switch (weatherType) {
            case "SUNNY": {
                Weather sunny = WeatherFactory.createWeather(weatherType);

                //Evaluate and store cost for Car
                resultsMap.put(evaluate(sunny, superCar, route1), superCar.getName() + " " + route1.getName());
                resultsMap.put(evaluate(sunny, superCar, route2), superCar.getName() + " " + route2.getName());

                //Evaluate and store cost for Auto
                resultsMap.put(evaluate(sunny, tuktuk, route1), tuktuk.getName() + " " + route1.getName());
                resultsMap.put(evaluate(sunny, tuktuk, route2), tuktuk.getName() + " " + route2.getName());

                //Evaluate and store cost for Bike
                resultsMap.put(evaluate(sunny, bike, route1), sunny.getName() + " " + route1.getName());
                resultsMap.put(evaluate(sunny, bike, route2), sunny.getName() + " " + route2.getName());

                //Since the map is sorted get the 1st value
                return resultsMap.entrySet().stream().findFirst().get().getValue();
            }

            case "RAINY": {

                Weather rainy = WeatherFactory.createWeather(weatherType);
                //Evaluate and store cost for Car
                resultsMap.put(evaluate(rainy, superCar, route1), superCar.getName() + " " + route1.getName());
                resultsMap.put(evaluate(rainy, superCar, route2), superCar.getName() + " " + route2.getName());
                //Evaluate and store cost for Auto
                resultsMap.put(evaluate(rainy, tuktuk, route1), tuktuk.getName() + " " + route1.getName());
                resultsMap.put(evaluate(rainy, tuktuk, route2), tuktuk.getName() + " " + route2.getName());
                //Since the map is sorted get the 1st value
                return resultsMap.entrySet().stream().findFirst().get().getValue();
            }

            case "WINDY": {
                Weather windy = WeatherFactory.createWeather(weatherType);
                //Evaluate and store cost for Car
                resultsMap.put(evaluate(windy, superCar, route1), superCar.getName() + " " + route1.getName());
                resultsMap.put(evaluate(windy, superCar, route2), superCar.getName() + " " + route2.getName());
                //Evaluate and store cost for Bike
                resultsMap.put(evaluate(windy, bike, route1), windy.getName() + " " + route1.getName());
                resultsMap.put(evaluate(windy, bike, route2), windy.getName() + " " + route2.getName());

                //Since the map is sorted get the 1st value
                return resultsMap.entrySet().stream().findFirst().get().getValue();

            }
            default:
                return null;
        }

    }

    /**
     * Logic
     * 1. Final Number of craters = Orbits'Crater + (Quantity of Craters added/removed due to weather condition)
     * 2. total time taken to travel = distance/speed + (timeToCrossSingleCrater * totalCraters)
     *
     * @param weather
     * @param vehicle
     * @param orbit
     * @return Route Cost
     */
    private float evaluate(Weather weather, Vehicle vehicle, Orbit orbit) {

        float distance = orbit.getDistance();
        // Final Number of craters = Orbits'Crater + (Quantity of Craters added/removed due to weather condition)
        int actualCratersNumber = orbit.getTotalCraters() +
                ((weather.getChangeInCraterSize() * orbit.getTotalCraters()) / 100);

        // total time taken to travel = distance/speed + (timeToCrossSingleCrater * totalCraters)
        float calibratedCraterSpeed = TrafficConstants.craterVehicleSpeed.get(vehicle.getName());

        if (orbit.getOrbitSpeed() > vehicle.getTopSpeed()) {
            return distance / vehicle.getTopSpeed() +
                    (calibratedCraterSpeed * actualCratersNumber);
        } else {
            return distance / orbit.getOrbitSpeed() +
                    (calibratedCraterSpeed * actualCratersNumber);
        }
    }
}
