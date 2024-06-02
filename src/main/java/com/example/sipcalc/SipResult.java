package com.example.sipcalc;

public class SipResult {
    private double totalInvestment;
    private double estimatedReturns;
    private double futureValue;

    public SipResult(double totalInvestment, double estimatedReturns, double futureValue) {
        this.totalInvestment = totalInvestment;
        this.estimatedReturns = estimatedReturns;
        this.futureValue = futureValue;
    }

    // Getters
    public double getTotalInvestment() {
        return totalInvestment;
    }

    public double getEstimatedReturns() {
        return estimatedReturns;
    }

    public double getFutureValue() {
        return futureValue;
    }
}
