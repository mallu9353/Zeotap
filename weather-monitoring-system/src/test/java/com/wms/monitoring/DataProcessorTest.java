package com.wms.monitoring;


import com.wms.processor.DataProcessor;
import org.junit.Test;
import static org.junit.Assert.*;

public class DataProcessorTest {
    @Test
    public void testProcessWeatherData() {
        DataProcessor dataProcessor = new DataProcessor();
        String jsonResponse = "{ \"main\": { \"temp\": 303.15 } }"; // Sample response
        dataProcessor.processWeatherData(jsonResponse);
        assertEquals(30.0, dataProcessor.getCurrentTemperature(), 0.01);
    }
}
