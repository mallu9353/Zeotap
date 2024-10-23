package com.wms.processor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DataProcessor {
    private double currentTemperature;

    public void processWeatherData(String jsonResponse) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject main = jsonObject.getAsJsonObject("main");
        currentTemperature = main.get("temp").getAsDouble() - 273.15; // Convert from Kelvin to Celsius
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }
}
