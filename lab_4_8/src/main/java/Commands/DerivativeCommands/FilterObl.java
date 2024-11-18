package Commands.DerivativeCommands;

import java.util.ArrayList;
import java.util.List;

import Der.Derivative;
import Obligations.InsuranceObligation;

public class FilterObl extends DerCommand {
    public FilterObl(Derivative der){
        super(der);
    }

    @Override
    public void execute() {
        System.out.print("Введiть мiнiмальний рiвень ризику: ");
        double minRisk = parseDouble(scanner.nextLine());
        System.out.print("Введiть максимальний рiвень ризику: ");
        double maxRisk = parseDouble(scanner.nextLine());
        System.out.print("Введiть мiнiмальну суму: ");
        double minAmount = parseDouble(scanner.nextLine());
        System.out.print("Введiть максимальну суму: ");
        double maxAmount = parseDouble(scanner.nextLine());
    
        List<InsuranceObligation> filteredObligations = findObligations(minRisk, maxRisk, minAmount, maxAmount);
        System.out.println("Знайденi зобов'язання:");
        for (InsuranceObligation obligation : filteredObligations) {
            System.out.println(obligation);
        }
        
        logger.info("Знайдено зобов’язання за заданими параметрами: " + filteredObligations.size() + " зобов’язань.");
    }
    

    private List<InsuranceObligation> findObligations(double minRisk, double maxRisk, double minAmount, double maxAmount) {
        List<InsuranceObligation> filteredObligations = new ArrayList<>();
        for (InsuranceObligation obligation : this.derivative.getObligations()) {
            if (obligation.getRiskLevel() >= minRisk && obligation.getRiskLevel() <= maxRisk &&
                obligation.getAmount() >= minAmount && obligation.getAmount() <= maxAmount) {
                filteredObligations.add(obligation);
            }
        }
        return filteredObligations;
    }
}
