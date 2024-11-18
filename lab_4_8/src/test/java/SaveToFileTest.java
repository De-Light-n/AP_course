import Commands.MenuCommands.SaveToFile;
import Der.Derivative;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SaveToFileTest {
    private List<Derivative> derivatives;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() throws IOException {
        derivatives = new ArrayList<>();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Files.createDirectories(Paths.get("lab_4_8"));

        Derivative derivative = new Derivative();
        derivatives.add(derivative);
    }

    @Test
    void testExecute_SaveToFile() throws IOException, ClassNotFoundException {
        SaveToFile saveToFileCommand = new SaveToFile(derivatives);
        saveToFileCommand.execute();

        assertTrue(outputStream.toString().contains("Данi успiшно збереженi у файл."),
                   "Повинно відобразитися повідомлення про успішне збереження даних.");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lab_4_8/derivatives.dat"))) {
            @SuppressWarnings("unchecked")
            List<Derivative> loadedDerivatives = (List<Derivative>) ois.readObject();
            assertEquals(derivatives.size(), loadedDerivatives.size(), "Кількість збережених деривативів повинна збігатися.");
        }
    }
}
