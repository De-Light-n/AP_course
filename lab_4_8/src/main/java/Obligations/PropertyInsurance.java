package Obligations;

public class PropertyInsurance extends InsuranceObligation {
    private String propertyLocation; 
    private double propertyValue;    
    private boolean isHighRiskArea;  

    public PropertyInsurance(double riskLevel, double amount, int duration, String propertyLocation, double propertyValue, boolean isHighRiskArea) {
        super(riskLevel, amount, duration, "Property");
        this.propertyLocation = propertyLocation;
        this.propertyValue = propertyValue;
        this.isHighRiskArea = isHighRiskArea;
    }

    public String getPropertyLocation() {
        return propertyLocation;
    }

    public void setPropertyLocation(String propertyLocation) {
        this.propertyLocation = propertyLocation;
    }

    public double getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(double propertyValue) {
        this.propertyValue = propertyValue;
    }

    public boolean isHighRiskArea() {
        return isHighRiskArea;
    }

    public void setHighRiskArea(boolean isHighRiskArea) {
        this.isHighRiskArea = isHighRiskArea;
    }

    // Метод для обчислення вартості страхового зобов’язання для страхування майна
    @Override
    public double calculateValue() {
        double baseValue = amount * (1 + riskLevel * 0.03); 
        if (isHighRiskArea) {
            baseValue *= 1.3; 
        }
        return baseValue;
    }
}
