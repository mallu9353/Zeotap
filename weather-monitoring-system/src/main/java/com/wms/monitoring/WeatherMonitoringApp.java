package com.wms.monitoring;



import com.wms.api.WeatherAPI;
import com.wms.processor.DataProcessor;
import com.wms.alerts.AlertSystem;

public class WeatherMonitoringApp {
    public static void main(String[] args) {
        WeatherAPI weatherAPI = new WeatherAPI();
        DataProcessor dataProcessor = new DataProcessor();
        AlertSystem alertSystem = new AlertSystem();

        try {
            // Replace "Delhi" with other city names as needed
            String jsonResponse = weatherAPI.fetchWeatherData("Bengaluru");
            dataProcessor.processWeatherData(jsonResponse);
            double currentTemperature = dataProcessor.getCurrentTemperature();
            System.out.println("Current Temperature: " + currentTemperature + "°C");
            alertSystem.checkAlerts(currentTemperature);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
