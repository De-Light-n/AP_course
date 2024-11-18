package Obligations;

public class HealthInsurance extends InsuranceObligation {
    private int age;
    private boolean hasPreexistingConditions; 

    public HealthInsurance(double riskLevel, double amount, int duration, int age, boolean hasPreexistingConditions) {
        super(riskLevel, amount, duration, "Health");
        this.age = age;
        this.hasPreexistingConditions = hasPreexistingConditions;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean hasPreexistingConditions() {
        return hasPreexistingConditions;
    }

    public void setPreexistingConditions(boolean hasPreexistingConditions) {
        this.hasPreexistingConditions = hasPreexistingConditions;
    }

    @Override
    public double calculateValue() {
        double baseValue = amount * (1 + riskLevel * 0.05); 
        if (age > 50) {
            baseValue *= 1.2; 
        }
        if (hasPreexistingConditions) {
            baseValue *= 1.5; 
        }
        return baseValue;
    }
}
