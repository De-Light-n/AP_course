import Der.Derivative;
import Obligations.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Commands.DerivativeCommands.AddInsurObl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddInsurOblTest {
    private Derivative derivative;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        derivative = new Derivative();
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testAddLifeInsurance() {
        String input = "1\n0.05\n10000\n12\nJohn Doe\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        AddInsurObl command = new AddInsurObl(derivative);
        command.execute();

        List<InsuranceObligation> obligations = derivative.getObligations();
        assertEquals(1, obligations.size());
        assertTrue(obligations.get(0) instanceof LifeInsurance);
        LifeInsurance lifeInsurance = (LifeInsurance) obligations.get(0);
        assertEquals(0.05, lifeInsurance.getRiskLevel());
        assertEquals(10000, lifeInsurance.getAmount());
        assertEquals(12, lifeInsurance.getDuration());
        assertEquals("John Doe", lifeInsurance.getBeneficiary());
    }

    @Test
    void testAddHealthInsurance() {
        String input = "2\n0.1\n5000\n24\n35\ntrue\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        AddInsurObl command = new AddInsurObl(derivative);
        command.execute();

        List<InsuranceObligation> obligations = derivative.getObligations();
        assertEquals(1, obligations.size());
        assertTrue(obligations.get(0) instanceof HealthInsurance);
        HealthInsurance healthInsurance = (HealthInsurance) obligations.get(0);
        assertEquals(0.1, healthInsurance.getRiskLevel());
        assertEquals(5000, healthInsurance.getAmount());
        assertEquals(24, healthInsurance.getDuration());
        assertEquals(35, healthInsurance.getAge());
        assertTrue(healthInsurance.hasPreexistingConditions());
    }

    @Test
    void testAddPropertyInsurance() {
        String input = "3\n0.2\n20000\n36\nKyiv\n150000\nfalse\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        AddInsurObl command = new AddInsurObl(derivative);
        command.execute();

        List<InsuranceObligation> obligations = derivative.getObligations();
        assertEquals(1, obligations.size());
        assertTrue(obligations.get(0) instanceof PropertyInsurance);
        PropertyInsurance propertyInsurance = (PropertyInsurance) obligations.get(0);
        assertEquals(0.2, propertyInsurance.getRiskLevel());
        assertEquals(20000, propertyInsurance.getAmount());
        assertEquals(36, propertyInsurance.getDuration());
        assertEquals("Kyiv", propertyInsurance.getPropertyLocation());
        assertEquals(150000, propertyInsurance.getPropertyValue());
        assertFalse(propertyInsurance.isHighRiskArea());
    }

    @Test
    void testInvalidInsuranceType() {
        String input = "4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        AddInsurObl command = new AddInsurObl(derivative);
        command.execute();

        assertTrue(derivative.getObligations().isEmpty());
        assertTrue(outputStream.toString().contains("Неправильно вибраний тип"));
    }
}

