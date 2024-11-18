package Commands;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Command {
    protected static Logger logger = LoggerFactory.getLogger(Command.class);
    protected Scanner scanner;

    public abstract void execute();
    //не потрібно передавати інтерфейс
    public Command(){
        scanner = new Scanner(System.in);
    }

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            System.out.println("Помилка: не вдалося перетворити '" + input + "' на int. Встановлення 0 за замовчуванням");
            return 0;
        }
    }

    public static double parseDouble(String input) {
        try {
            return Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            System.out.println("Помилка: не вдалося перетворити '" + input + "' на double. Встановлення 0 за замовчуванням");
            return 0.0;
        }
    }

    public static boolean parseBoolean(String input) {
        return Boolean.parseBoolean(input.trim());
    }
}
