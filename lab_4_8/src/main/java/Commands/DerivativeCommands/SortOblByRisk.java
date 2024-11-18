package Commands.DerivativeCommands;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Der.Derivative;
import Obligations.InsuranceObligation;

public class SortOblByRisk extends DerCommand {
    public SortOblByRisk(Derivative der) {
        super(der);
    }

    @Override
    public void execute() {
        logger.info("Зобов’язання відсортовані за рівнем ризику.");
        for(InsuranceObligation obligation : sortObligationsByRisk()){
            System.out.println(obligation);
        }
        System.out.println("Зобов'язання вiдсортованi за рiвнем ризику.");
    }

    private List<InsuranceObligation> sortObligationsByRisk() {
        List<InsuranceObligation> filteredObligations = new ArrayList<>();
        
        for (InsuranceObligation obligation : derivative.getObligations()) {
            filteredObligations.add(obligation);
        }

        return filteredObligations.stream()
                .sorted(Comparator.comparingDouble(InsuranceObligation::getRiskLevel))
                .collect(Collectors.toList());
    }
}
