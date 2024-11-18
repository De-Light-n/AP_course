package Commands.DerivativeCommands;

import java.util.List;

import Der.Derivative;
import Obligations.InsuranceObligation;

public class RemInsurObl extends DerCommand{
    public RemInsurObl(Derivative der){
        super(der);
    }

    @Override
    public void execute(){
        System.out.println(derivative);
        System.out.print("Введiть iндекс зобов'язання для видалення:");
        int index = parseInt(scanner.nextLine()) - 1;

        List<InsuranceObligation> obligations = derivative.getObligations();
        if (index >= 0 && index < obligations.size()) {
            logger.info("Видалення зобов’язання : " + obligations.get(index));
            derivative.removeObligation(obligations.get(index));
        } else {
            System.out.println("Неправильний iндекс зобов'язання.");
        }
        logger.info("Зобов’язання видалено");
    }
}
