package com.geek.model;

public class Vehicle {

    String name;
    float topSpeed;
    int crossesCraterIn;

    public String getUnsuitedWeather() {
        return unsuitedWeather;
    }

    public void setUnsuitedWeather(String unsuitedWeather) {
        this.unsuitedWeather = unsuitedWeather;
    }

    String unsuitedWeather;

    public Vehicle(){};

    public Vehicle(String name, float topSpeed, int crossesCraterIn, String unsuitedWeather) {
        this.name = name;
        this.topSpeed = topSpeed;
        this.crossesCraterIn = crossesCraterIn;
        this.unsuitedWeather = unsuitedWeather;
    }

    public Vehicle(String name, float topSpeed, int crossesCraterIn) {
        this.name = name;
        this.topSpeed = topSpeed;
        this.crossesCraterIn = crossesCraterIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(float topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getCrossesCraterIn() {
        return crossesCraterIn;
    }

    public void setCrossesCraterIn(int crossesCraterIn) {
        this.crossesCraterIn = crossesCraterIn;
    }

}
