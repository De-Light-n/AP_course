package Commands.MenuCommands;

import java.util.List;

import Commands.Command;
import Der.Derivative;

public abstract class MenuCommand extends Command{
    protected List<Derivative> derivatives;

    public MenuCommand(List<Derivative> derivatives){
        super();
        this.derivatives = derivatives;
    }
}
