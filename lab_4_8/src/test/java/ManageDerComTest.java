import Commands.MenuCommands.ManageDerCom;
import Der.Derivative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ManageDerComTest {
    private List<Derivative> derivatives;
    private Derivative derivative;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        derivatives = new ArrayList<>();
        derivative = new Derivative();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testExecute_NoDerivatives() {
        ManageDerCom manageDerCom = new ManageDerCom(derivatives);
        manageDerCom.execute();

        assertTrue(outputStream.toString().contains("Немає доступних деривативiв"),
                   "Повинно відобразитися повідомлення про відсутність деривативів.");
    }

    @Test
    void testExecute_InvalidChoice() {
        derivatives.add(derivative);

        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
        ManageDerCom manageDerCom = new ManageDerCom(derivatives);
        manageDerCom.execute();

        assertTrue(outputStream.toString().contains("Неправильний вибiр"),
                   "Повинно відобразитися повідомлення про неправильний вибір.");
    }

    @Test
    void testExecute_AddInsurObl() {
        derivatives.add(derivative);

        System.setIn(new ByteArrayInputStream("1\n7\n".getBytes()));
        ManageDerCom manageDerCom = new ManageDerCom(derivatives);
        manageDerCom.execute();

        assertTrue(outputStream.toString().contains("Додати страхове зобов'язання"),
                   "Повинно відобразитися повідомлення про додавання страхового зобов'язання.");
    }
}
