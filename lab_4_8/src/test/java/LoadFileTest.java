import Commands.MenuCommands.LoadFile;
import Der.Derivative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoadFileTest {
    private List<Derivative> derivatives;
    private File tempFile;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() throws IOException {
        derivatives = new ArrayList<>();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        tempFile = File.createTempFile("test_derivatives", ".dat");
        tempFile.deleteOnExit();

        List<Derivative> testDerivatives = new ArrayList<>();
        testDerivatives.add(new Derivative());
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tempFile))) {
            oos.writeObject(testDerivatives);
        }
    }

    @Test
    void testExecute_LoadFromFile() {
        System.setProperty("derivatives.file.path", tempFile.getAbsolutePath());

        LoadFile loadFileCommand = new LoadFile(derivatives);
        loadFileCommand.execute();

        assertTrue(outputStream.toString().contains("Данi успiшно завантаженi з файлу."),
                   "Повинно відобразитися повідомлення про успішне завантаження даних.");
        assertEquals(1, derivatives.size(), "Повинно бути завантажено один дериватив.");
    }
}
