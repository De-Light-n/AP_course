package Commands.MenuCommands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import Der.Derivative;


public class LoadFile extends MenuCommand {
    public LoadFile(List<Derivative> derivatives) {
        super(derivatives);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void execute() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lab_4_8/derivatives.dat"))) {
            List<Derivative> loadedDerivatives = (List<Derivative>) ois.readObject();
            this.derivatives.clear();
            this.derivatives.addAll(loadedDerivatives);
            
            System.out.println("Данi успiшно завантаженi з файлу.");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено. Створiть новий дериватив перед завантаженням.");
            logger.error("Файл для завантаження не знайдено", e);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка при завантаженнi даних: " + e.getMessage());
            logger.error("Помилка при завантаженні даних", e);
        } catch (Exception e) {
            logger.error("Невідома помилка", e);
        }
    }
}

