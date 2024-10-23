package com.wms.monitoring;


import com.wms.alerts.AlertSystem;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlertSystemTest {
    @Test
    public void testCheckAlerts() {
        AlertSystem alertSystem = new AlertSystem();
        alertSystem.checkAlerts(36.0); // Should trigger alert
        // You can add additional logic to verify alert output if needed
    }
}
