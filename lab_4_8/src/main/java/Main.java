import Interface.UserInterface;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Commands.Command;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Command.class);
        
        try {
            UserInterface ui = new UserInterface();
            ui.start();        
        } catch (Exception e) {
            logger.error("Виникла критична помилка");
        }
    }
}

