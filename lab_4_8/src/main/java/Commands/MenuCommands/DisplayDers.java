package Commands.MenuCommands;

import java.util.List;

import Der.Derivative;

public class DisplayDers extends MenuCommand{
    public DisplayDers(List<Derivative> derivatives){
        super(derivatives);
    }

    @Override
    public void execute(){
        if (this.derivatives.isEmpty()) {
            System.out.println("Немає деривативiв для показу.");
            return;
        }

        int i = 0;
        for (Derivative derivative : this.derivatives) {
            System.out.println("Дериватив " + (i + 1) + ":");
            System.out.println(derivative);
            System.out.println("---------------");
            i+=1;
        }
    }
}
