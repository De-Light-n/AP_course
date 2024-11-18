
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Der.Derivative;
import Obligations.*;

import java.util.ArrayList;
import java.util.List;

public class DerivativeTest {
    private Derivative derivative;
    private HealthInsurance healthInsurance;
    private PropertyInsurance propertyInsurance;

    @BeforeEach
    public void setUp() {
        derivative = new Derivative();
        healthInsurance = new HealthInsurance(0.2, 1000, 1, 30, false);
        propertyInsurance = new PropertyInsurance(0.1, 2000, 1, "City Center", 50000, false);
    }

    @Test
    public void testAddObligation() {
        derivative.addObligation(healthInsurance);
        assertTrue(derivative.getObligations().contains(healthInsurance));
    }

    @Test
    public void testRemoveObligation() {
        derivative.addObligation(healthInsurance);
        derivative.removeObligation(healthInsurance);
        assertFalse(derivative.getObligations().contains(healthInsurance));
    }

     @Test
    public void testGetObligations() {
        derivative.addObligation(healthInsurance);
        derivative.addObligation(propertyInsurance);
        List<InsuranceObligation> obligations = derivative.getObligations();
        assertEquals(2, obligations.size(), "Кількість зобов'язань повинна бути 2.");
        assertTrue(obligations.contains(healthInsurance), "Список зобов'язань повинен містити медичне страхування.");
        assertTrue(obligations.contains(propertyInsurance), "Список зобов'язань повинен містити страхування майна.");
    }

    @Test
    public void testSetObligations() {
        List<InsuranceObligation> newObligations = new ArrayList<>();
        newObligations.add(healthInsurance);
        derivative.setObligations(newObligations);
        assertEquals(1, derivative.getObligations().size(), "Кількість зобов'язань повинна бути 1 після встановлення нового списку.");
        assertTrue(derivative.getObligations().contains(healthInsurance), "Список зобов'язань повинен містити тільки медичне страхування.");
    }

    @Test
    public void testToString() {
        derivative.addObligation(healthInsurance);
        derivative.addObligation(propertyInsurance);
        String result = derivative.toString();
        assertTrue(result.contains("Облiгацiї:"), "Рядкове представлення повинно містити заголовок 'Облiгацiї:'.");
        assertTrue(result.contains(healthInsurance.toString()), "Рядкове представлення повинно містити інформацію про медичне страхування.");
        assertTrue(result.contains(propertyInsurance.toString()), "Рядкове представлення повинно містити інформацію про страхування майна.");
    }

    // @Test
    // public void testCalculateTotalValue() {
    //     derivative.addObligation(healthInsurance);
    //     derivative.addObligation(propertyInsurance);
    //     double expected = healthInsurance.calculateValue() + propertyInsurance.calculateValue();
    //     assertEquals(expected, derivative.calculateTotalValue(), 0.01);
    // }

    // @Test
    // public void testSortObligationsByRisk() {
    //     HealthInsurance highRiskInsurance = new HealthInsurance(0.5, 1200, 1, 40, false);
    //     derivative.addObligation(highRiskInsurance);
    //     derivative.addObligation(propertyInsurance);
    //     derivative.addObligation(healthInsurance);
    //     derivative.sortObligationsByRisk();

    //     List<InsuranceObligation> sortedObligations = derivative.sortObligationsByRisk();
    //     assertTrue(sortedObligations.get(0).getRiskLevel() <= sortedObligations.get(1).getRiskLevel());
    //     assertTrue(sortedObligations.get(1).getRiskLevel() <= sortedObligations.get(2).getRiskLevel());
    // }

    // @Test
    // public void testFindObligations() {
    //     derivative.addObligation(healthInsurance);
    //     derivative.addObligation(propertyInsurance);
    //     List<InsuranceObligation> result = derivative.findObligations(0.1, 0.3, 500, 2500);

    //     assertTrue(result.contains(healthInsurance));
    //     assertTrue(result.contains(propertyInsurance));
    // }

    // @Test
    // public void testFindObligations_NoMatchingObligations() {
    //     derivative.addObligation(healthInsurance);
    //     derivative.addObligation(propertyInsurance);
    //     List<InsuranceObligation> result = derivative.findObligations(0.3, 0.4, 3000, 5000);
    //     assertTrue(result.isEmpty());
    // }
}
