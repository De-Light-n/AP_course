import org.junit.jupiter.api.Test;

import Obligations.InsuranceObligation;

import static org.junit.jupiter.api.Assertions.*;

class InsuranceObligationTest {

    static class TestInsuranceObligation extends InsuranceObligation {
        public TestInsuranceObligation(double riskLevel, double amount, int duration, String type) {
            super(riskLevel, amount, duration, type);
        }

        @Override
        public double calculateValue() {
            return amount * (1 + riskLevel * 0.05); 
        }
    }

    @Test
    void testGetters() {
        InsuranceObligation obligation = new TestInsuranceObligation(0.2, 1000.0, 12, "Test");

        assertEquals(0.2, obligation.getRiskLevel());
        assertEquals(1000.0, obligation.getAmount());
        assertEquals(12, obligation.getDuration());
        assertEquals("Test", obligation.getType());
    }

    @Test
    void testSetters() {
        InsuranceObligation obligation = new TestInsuranceObligation(0.1, 500.0, 6, "Sample");

        obligation.setAmount(1500.0);
        assertEquals(1500.0, obligation.getAmount());

        obligation.setDuration(24);
        assertEquals(24, obligation.getDuration());

        obligation.setRiskLevel(0.3);
        assertEquals(0.3, obligation.getRiskLevel());
    }

    @Test
    void testCalculateValue() {
        InsuranceObligation obligation = new TestInsuranceObligation(0.1, 1000.0, 12, "Sample");
        double expectedValue = 1000.0 * (1 + 0.1 * 0.05);
        assertEquals(expectedValue, obligation.calculateValue(), 0.01);
    }

    @Test
    void testToString() {
        InsuranceObligation obligation = new TestInsuranceObligation(0.15, 2000.0, 18, "Test");
        String expectedString = "Тип: Test, Рiвень ризику: 0.15, Сума: 2000.0, Термiн дiї(в мiсяцях): 18, Вартiсть: " + obligation.calculateValue();
        
        assertEquals(expectedString, obligation.toString());
    }
}

