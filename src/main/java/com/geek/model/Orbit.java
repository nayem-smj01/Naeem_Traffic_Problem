package com.geek.model;

public class Orbit {

    String name;
    int totalCraters;
    float distance;

    public float getOrbitSpeed() {
        return orbitSpeed;
    }

    public void setOrbitSpeed(float orbitSpeed) {
        this.orbitSpeed = orbitSpeed;
    }

    float orbitSpeed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalCraters() {
        return totalCraters;
    }

    public void setTotalCraters(int totalCraters) {
        this.totalCraters = totalCraters;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Orbit(String name, int totalCraters, float distance) {
        this.name = name;
        this.totalCraters = totalCraters;
        this.distance = distance;
    }
}
