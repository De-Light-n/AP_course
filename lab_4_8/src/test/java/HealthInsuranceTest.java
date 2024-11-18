import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Obligations.HealthInsurance;

public class HealthInsuranceTest {

    private HealthInsurance insurance;

    @BeforeEach
    public void setUp() {
        insurance = new HealthInsurance(0.2, 5000, 12, 45, false);
    }

    @Test
    public void testCalculateValue_NoPreexistingConditions_YoungAge() {
        double expectedValue = 5000 * (1 + 0.2 * 0.05);
        assertEquals(expectedValue, insurance.calculateValue(), 0.01);
    }

    @Test
    public void testCalculateValue_PreexistingConditions_YoungAge() {
        insurance.setPreexistingConditions(true);
        double expectedValue = 5000 * (1 + 0.2 * 0.05) * 1.5;
        assertEquals(expectedValue, insurance.calculateValue(), 0.01);
    }

    @Test
    public void testCalculateValue_NoPreexistingConditions_OlderAge() {
        insurance.setAge(55);
        double expectedValue = 5000 * (1 + 0.2 * 0.05) * 1.2;
        assertEquals(expectedValue, insurance.calculateValue(), 0.01);
    }

    @Test
    public void testCalculateValue_PreexistingConditions_OlderAge() {
        insurance.setAge(55);
        insurance.setPreexistingConditions(true);
        double expectedValue = 5000 * (1 + 0.2 * 0.05) * 1.2 * 1.5;
        assertEquals(expectedValue, insurance.calculateValue(), 0.01);
    }

    @Test
    public void testGetAge() {
        assertEquals(45, insurance.getAge());
    }

    @Test
    public void testSetAge() {
        insurance.setAge(60);
        assertEquals(60, insurance.getAge());
    }

    @Test
    public void testHasPreexistingConditions() {
        assertFalse(insurance.hasPreexistingConditions());
    }

    @Test
    public void testSetPreexistingConditions() {
        insurance.setPreexistingConditions(true);
        assertTrue(insurance.hasPreexistingConditions());
    }

    @Test
    public void testGetRiskLevel() {
        assertEquals(0.2, insurance.getRiskLevel());
    }

    @Test
    public void testSetRiskLevel() {
        insurance.setRiskLevel(0.3);
        assertEquals(0.3, insurance.getRiskLevel());
    }

    @Test
    public void testGetAmount() {
        assertEquals(5000, insurance.getAmount(), 0.01);
    }

    @Test
    public void testSetAmount() {
        insurance.setAmount(6000);
        assertEquals(6000, insurance.getAmount(), 0.01);
    }

    @Test
    public void testGetDuration() {
        assertEquals(12, insurance.getDuration());
    }

    @Test
    public void testSetDuration() {
        insurance.setDuration(24);
        assertEquals(24, insurance.getDuration());
    }

    @Test
    public void testGetType() {
        assertEquals("Health", insurance.getType());
    }
}
