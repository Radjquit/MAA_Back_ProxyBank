package org.maaProxyBack.model;

import jakarta.persistence.Entity;

@Entity
public class SavingAccount extends Account{
    private double interestRate = defaultInterestRate;
    private static double defaultInterestRate = 0.03;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public static double getDefaultInterestRate() {
        return defaultInterestRate;
    }

    public static void setDefaultInterestRate(double defaultInterestRate) {
        SavingAccount.defaultInterestRate = defaultInterestRate;
    }

    @Override
    public String toString() {
        return super.toString() + "Saving";
    }
}
