package Obligations;


import java.io.Serializable;

public abstract class InsuranceObligation implements Serializable{
    protected double riskLevel; 
    protected double amount;    
    protected int duration;     
    protected String type;      

    public InsuranceObligation(double riskLevel, double amount, int duration, String type) {
        this.riskLevel = riskLevel;
        this.amount = amount;
        this.duration = duration;
        this.type = type;
    }

    public double getRiskLevel() {
        return riskLevel;
    }

    public double getAmount() {
        return amount;
    }

    public int getDuration() {
        return duration;
    }

    public String getType() {
        return type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRiskLevel(double riskLevel) {
        this.riskLevel = riskLevel;
    }

    public abstract double calculateValue();

    public String toString(){
        return "Тип: " + this.getType() +
        ", Рiвень ризику: " + this.getRiskLevel() +
        ", Сума: " + this.getAmount() +
        ", Термiн дiї(в мiсяцях): " + this.getDuration() +
        ", Вартiсть: " + this.calculateValue();
    }
}

