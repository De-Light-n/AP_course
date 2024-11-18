import Commands.MenuCommands.DisplayDers;
import Der.Derivative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DisplayDersTest {
    private List<Derivative> derivatives;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        derivatives = new ArrayList<>();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testExecute_NoDerivatives() {
        DisplayDers displayDers = new DisplayDers(derivatives);
        displayDers.execute();

        assertTrue(outputStream.toString().contains("Немає деривативiв для показу"),
                   "Повинно відобразитися повідомлення, що немає деривативів для показу.");
    }

    @Test
    void testExecute_WithDerivatives() {
        Derivative derivative = new Derivative();
        derivatives.add(derivative);

        DisplayDers displayDers = new DisplayDers(derivatives);
        displayDers.execute();

        assertTrue(outputStream.toString().contains("Дериватив 1:"),
                   "Повинно відобразитися повідомлення з інформацією про перший дериватив.");
    }
}
