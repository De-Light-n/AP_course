package Obligations;


public class LifeInsurance extends InsuranceObligation{
    private String beneficiary; 

    public LifeInsurance(double riskLevel, double amount, int duration, String beneficiary) {
        super(riskLevel, amount, duration, "Life");
        this.beneficiary = beneficiary;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    @Override
    public double calculateValue() {
        return amount * (1 + riskLevel * 0.1); 
    }
}
