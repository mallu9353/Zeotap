package com.wms.models;


public class WeatherData {
    private double temperature;
    private String condition;

    // Constructor, getters, and setters
    public WeatherData(double temperature, String condition) {
        this.temperature = temperature;
        this.condition = condition;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getCondition() {
        return condition;
    }
}
