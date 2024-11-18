package Commands.MenuCommands;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import Der.Derivative;


public class SaveToFile extends MenuCommand{
    public SaveToFile(List<Derivative> derivatives){
        super(derivatives);
    }

    @Override
    public void execute(){
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("lab_4_8/derivatives.dat"))) {
            oos.writeObject(derivatives);
            System.out.println("Данi успiшно збереженi у файл.");
        } catch (IOException e) {
            System.out.println("Помилка при збереженнi даних: " + e.getMessage());
            logger.error("Помилка при збереженні даних", e);
        }
    }
}
