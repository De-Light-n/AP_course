import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Interface.UserInterface;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserInterfaceTest {
    private UserInterface ui;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        ui.closeScanner();
        System.setIn(System.in);
    }

    @Test
    void testStart_NoDerivativesAvailable() {
        System.setIn(new ByteArrayInputStream("3\n6\n".getBytes()));
        ui = new UserInterface();
        ui.start();
        assertTrue(outputStream.toString().contains("Немає деривативiв"));
    }

    @Test
    void testStart_InvalidChoice() {
        System.setIn(new ByteArrayInputStream("9\n6\n".getBytes()));
        ui = new UserInterface();
        ui.start();
        assertTrue(outputStream.toString().contains("Неправильний вибiр"));
    }

    @Test
    void testExitOption() {
        System.setIn(new ByteArrayInputStream("6\n".getBytes()));
        ui = new UserInterface();
        ui.start();
        assertTrue(outputStream.toString().contains("До побачення!"));
    }
}
