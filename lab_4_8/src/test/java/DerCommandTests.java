import Der.Derivative;
import Obligations.*;
import Commands.DerivativeCommands.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DerCommandTests {
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
    void testFilterObl() {
        derivative.addObligation(new LifeInsurance(0.1, 5000, 12, "John Doe"));
        derivative.addObligation(new HealthInsurance(0.05, 10000, 24, 30, false));
        derivative.addObligation(new PropertyInsurance(0.2, 15000, 36, "Kyiv", 100000, true));

        String input = "0.05\n0.15\n5000\n15000\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        FilterObl command = new FilterObl(derivative);
        command.execute();

        String output = outputStream.toString();
        assertTrue(output.contains("Знайденi зобов'язання"));
    }

    @Test
    void testDisplayObl() {
        derivative.addObligation(new LifeInsurance(0.1, 5000, 12, "John Doe"));
        derivative.addObligation(new HealthInsurance(0.05, 10000, 24, 30, false));

        DisplayObl command = new DisplayObl(derivative);
        command.execute();

        String output = outputStream.toString();
        assertTrue(output.contains("5000"));
    }

    @Test
    void testRemInsurObl() {
        derivative.addObligation(new LifeInsurance(0.1, 5000, 12, "John Doe"));
        derivative.addObligation(new HealthInsurance(0.05, 10000, 24, 30, false));

        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        RemInsurObl command = new RemInsurObl(derivative);
        command.execute();

        List<InsuranceObligation> obligations = derivative.getObligations();
        assertEquals(1, obligations.size());
        assertTrue(obligations.get(0) instanceof HealthInsurance);
    }

    @Test
    void testSortOblByRisk() {
        derivative.addObligation(new LifeInsurance(0.2, 5000, 12, "John Doe"));
        derivative.addObligation(new HealthInsurance(0.05, 10000, 24, 30, false));
        derivative.addObligation(new PropertyInsurance(0.15, 15000, 36, "Kyiv", 100000, true));

        SortOblByRisk command = new SortOblByRisk(derivative);
        command.execute();

        List<InsuranceObligation> obligations = derivative.getObligations();
        assertEquals(0.2, obligations.get(0).getRiskLevel());
        assertEquals(0.05, obligations.get(1).getRiskLevel());
        assertEquals(0.15, obligations.get(2).getRiskLevel());
    }

    @Test
    void testTotalValue() {
        derivative.addObligation(new LifeInsurance(0.1, 5000, 12, "John Doe"));
        derivative.addObligation(new HealthInsurance(0.05, 10000, 24, 30, false));

        TotalValue command = new TotalValue(derivative);
        command.execute();

        String output = outputStream.toString();
        assertTrue(output.contains("Загальна вартiсть деривативу"));
        assertTrue(output.contains("15075"));
    }
}

