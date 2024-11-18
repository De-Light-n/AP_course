import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut); 
    }

    @Test
    void testMain_StartsUserInterface() {
        System.setIn(new ByteArrayInputStream("6\n".getBytes()));

        Main.main(new String[]{});
        
        String output = outputStream.toString();
        assertTrue(output.contains("Ласкаво просимо до Системи управлiння страховими деривативами!"));
        assertTrue(output.contains("До побачення!"));
    }
}

