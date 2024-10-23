package com.wms.monitoring;


import com.wms.api.WeatherAPI;
import org.junit.Test;
import static org.junit.Assert.*;

public class WeatherAPITest {
    @Test
    public void testFetchWeatherData() {
        WeatherAPI weatherAPI = new WeatherAPI();
        try {
            String response = weatherAPI.fetchWeatherData("Bengaluru");
            assertNotNull(response);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
}
