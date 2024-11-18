package Commands.DerivativeCommands;

import Der.Derivative;
import Commands.Command;

public abstract class DerCommand extends Command{
    protected Derivative derivative;
    
    public DerCommand(Derivative derivative){
        super();
        this.derivative = derivative;
    }
}
