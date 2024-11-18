package Interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Commands.Command;
import Commands.MenuCommands.*;
import Der.Derivative;

import java.util.HashMap;
import java.util.Map;

public class UserInterface {
    private static Logger logger = LoggerFactory.getLogger(Command.class);

    private List<Derivative> userDerivatives;
    
    private Scanner scanner;

    private Map<Integer, MenuCommand> menuCommands;

    public UserInterface() {
        userDerivatives = new ArrayList<>();
        scanner = new Scanner(System.in);
        menuCommands = new HashMap<>();
        menuCommands.put(1, new CreateDerCom(this.userDerivatives));
        menuCommands.put(2, new ManageDerCom(this.userDerivatives));
        menuCommands.put(3, new DisplayDers(this.userDerivatives));
        menuCommands.put(4, new SaveToFile(this.userDerivatives));
        menuCommands.put(5, new LoadFile(this.userDerivatives));
    }

    public void start() {
        System.out.println("Ласкаво просимо до Системи управлiння страховими деривативами!");
        logger.info("Початок програми");
        boolean exit = false;
        while (!exit) {
            System.out.println("\nБудь ласка, виберiть опцiю:");
            System.out.println("1. Створити новий дериватив");
            System.out.println("2. Керувати iснуючим деривативом");
            System.out.println("3. Показати всi деривативи");
            System.out.println("4. Зберегти данi");
            System.out.println("5. Завантажити данi");
            System.out.println("6. Вихiд");

            System.out.print("Вибiр:");
            try {
                logger.info("Перед вибором");
                int choice = scanner.nextInt();
                logger.info("Вибiр: " + choice);

                if (choice == 6) {
                    exit = true;
                    logger.info("Користувач завершив роботу.");
                } else if (menuCommands.containsKey(choice)) {
                    menuCommands.get(choice).execute();
                } else {
                    System.out.println("Неправильний вибiр, спробуйте ще раз.");
                    logger.warn("Користувач ввів неправильний вибір: " + choice);
                }
            } catch (Exception e) {
                System.out.println("Помилка введення, спробуйте ще раз.");
                logger.error("Помилка введення", e);
            }
        }

        System.out.println("До побачення!");
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }    
}
