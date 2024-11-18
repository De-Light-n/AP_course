import org.junit.jupiter.api.Test;

import Obligations.LifeInsurance;

import static org.junit.jupiter.api.Assertions.*;

class LifeInsuranceTest {

    @Test
    void testCalculateValue() {

        LifeInsurance insuranceLowRisk = new LifeInsurance(0.1, 1000.0, 12, "John Doe");
        double expectedValueLowRisk = 1000.0 * (1 + 0.1 * 0.1); 
        assertEquals(expectedValueLowRisk, insuranceLowRisk.calculateValue(), 0.01);


        LifeInsurance insuranceHighRisk = new LifeInsurance(0.5, 1000.0, 12, "Jane Doe");
        double expectedValueHighRisk = 1000.0 * (1 + 0.5 * 0.1);
        assertEquals(expectedValueHighRisk, insuranceHighRisk.calculateValue(), 0.01);
    }

    @Test
    void testGetBeneficiary() {
        LifeInsurance insurance = new LifeInsurance(0.2, 2000.0, 24, "Alice");
        assertEquals("Alice", insurance.getBeneficiary());
    }
}
