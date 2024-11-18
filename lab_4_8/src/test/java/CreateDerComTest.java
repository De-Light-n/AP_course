import Commands.MenuCommands.CreateDerCom;
import Der.Derivative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateDerComTest {
    private List<Derivative> derivatives;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        derivatives = new ArrayList<>();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testExecute_CreateDerivative() {
        CreateDerCom createDerCom = new CreateDerCom(derivatives);
        createDerCom.execute();

        assertEquals(1, derivatives.size());
        assertTrue(outputStream.toString().contains("Новий дериватив створено та додано до вашого списку"));
    }
}
