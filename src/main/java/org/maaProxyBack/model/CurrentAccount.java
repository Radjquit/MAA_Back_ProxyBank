package org.maaProxyBack.model;

import jakarta.persistence.Entity;

@Entity
public class CurrentAccount extends Account{
    private double authorizedOverdraft = defaultAuthorizedOverdraft;
    private static double defaultAuthorizedOverdraft = 500;
    
    

    public double getAuthorizedOverdraft() {
        return authorizedOverdraft;
    }

    public void setAuthorizedOverdraft(double authorizedOverdraft) {
        this.authorizedOverdraft = authorizedOverdraft;
    }

    public static double getDefaultAuthorizedOverdraft() {
        return defaultAuthorizedOverdraft;
    }

    public static void setDefaultAuthorizedOverdraft(double defaultAuthorizedOverdraft) {
        CurrentAccount.defaultAuthorizedOverdraft = defaultAuthorizedOverdraft;
    }

    @Override
    public String toString() {
        return super.toString() + "Current";
    }
}
