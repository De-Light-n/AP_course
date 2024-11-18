package Commands.MenuCommands;

import java.util.List;

import Der.Derivative;

public class CreateDerCom extends MenuCommand{
    public CreateDerCom(List<Derivative> derivatives){
        super(derivatives);
    }

    @Override
    public void execute(){
        Derivative derivative = new Derivative();
        this.derivatives.add(derivative);
        System.out.println("Новий дериватив створено та додано до вашого списку.");
    }
}
