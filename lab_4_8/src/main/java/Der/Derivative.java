package Der;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Obligations.*;

public class Derivative implements Serializable{

    private List<InsuranceObligation> obligations; 

    public Derivative() {
        this.obligations = new ArrayList<>();
    }

    public void addObligation(InsuranceObligation obligation) {
        obligations.add(obligation);
    }

    public void removeObligation(InsuranceObligation obligation) {
        obligations.remove(obligation);
    }

    public List<InsuranceObligation> getObligations() {
        return obligations;
    }

    public void setObligations(List<InsuranceObligation> obligations){
        this.obligations = obligations;
    }

    public String toString() {
        String result = "Облiгацiї:\n";
        for (InsuranceObligation obligation : obligations) {
            result += obligation.toString() + "\n";
        }
        return result;
    }
}
