package Commands.DerivativeCommands;

import Der.Derivative;
import Obligations.InsuranceObligation;

public class TotalValue extends DerCommand {
    public TotalValue(Derivative der){
        super(der);
    }

    @Override
    public void execute(){
        double totalValue = calculateTotalValue();
        logger.info("Розрахована загальна вартість деривативу: " + totalValue);
        System.out.println("Загальна вартiсть деривативу: " + totalValue);
    }

    private double calculateTotalValue() {
        double totalValue = 0;
        for (InsuranceObligation obligation : derivative.getObligations()) {
            totalValue += obligation.calculateValue();
        }
        return totalValue;
    }
}
