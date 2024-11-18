import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Obligations.PropertyInsurance;

public class PropertyInsuranceTest {
    private PropertyInsurance propertyInsurance;

    @BeforeEach
    public void setUp() {
        propertyInsurance = new PropertyInsurance(0.1, 2000, 1, "City Center", 50000, false);
    }

    @Test
    public void testGetPropertyLocation() {
        assertEquals("City Center", propertyInsurance.getPropertyLocation());
    }

    @Test
    public void testSetPropertyLocation() {
        propertyInsurance.setPropertyLocation("Suburb");
        assertEquals("Suburb", propertyInsurance.getPropertyLocation());
    }

    @Test
    public void testGetPropertyValue() {
        assertEquals(50000, propertyInsurance.getPropertyValue());
    }

    @Test
    public void testSetPropertyValue() {
        propertyInsurance.setPropertyValue(75000);
        assertEquals(75000, propertyInsurance.getPropertyValue());
    }

    @Test
    public void testIsHighRiskArea() {
        assertFalse(propertyInsurance.isHighRiskArea());
    }

    @Test
    public void testSetHighRiskArea() {
        propertyInsurance.setHighRiskArea(true);
        assertTrue(propertyInsurance.isHighRiskArea());
    }

    @Test
    public void testCalculateValue_NotHighRiskArea() {
        double expected = 2000 * (1 + 0.1 * 0.03);
        assertEquals(expected, propertyInsurance.calculateValue(), 0.01);
    }

    @Test
    public void testCalculateValue_HighRiskArea() {
        propertyInsurance.setHighRiskArea(true);
        double expected = 2000 * (1 + 0.1 * 0.03) * 1.3;
        assertEquals(expected, propertyInsurance.calculateValue(), 0.01);
    }
}
