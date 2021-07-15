package com.geek.model;

public class Weather {

    String name;
    // In percent
    int changeInCraterSize;

    public Weather(String name, int changeInCraterSize) {
        this.name = name;
        this.changeInCraterSize = changeInCraterSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChangeInCraterSize() {
        return changeInCraterSize;
    }

    public void setChangeInCraterSize(int changeInCraterSize) {
        this.changeInCraterSize = changeInCraterSize;
    }
}
