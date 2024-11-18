package Commands.DerivativeCommands;

import Der.Derivative;

public class DisplayObl extends DerCommand{
    public DisplayObl(Derivative der){
        super(der);
    }

    @Override
    public void execute(){
        System.out.println(derivative);
    }
}
