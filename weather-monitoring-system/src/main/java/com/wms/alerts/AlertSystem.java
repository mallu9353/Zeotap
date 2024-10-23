package com.wms.alerts;


public class AlertSystem {
    private static final double TEMPERATURE_THRESHOLD = 35.0;

    public void checkAlerts(double currentTemperature) {
        if (currentTemperature > TEMPERATURE_THRESHOLD) {
            System.out.println("Alert: Current temperature exceeds " + TEMPERATURE_THRESHOLD + "°C!");
        }
    }
}
