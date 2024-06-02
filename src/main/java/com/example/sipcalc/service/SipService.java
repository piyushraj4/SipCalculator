package com.example.sipcalc.service;

import org.springframework.stereotype.Service;

@Service
public class SipService {

    public double calculateSip(double monthlyInvestment, double annualInterestRate, int years) {
        double monthlyRate = annualInterestRate / 12 / 100;
        int months = years * 12;
        double futureValue = 0;
        
        for (int i = 0; i < months; i++) {
            futureValue += monthlyInvestment * Math.pow(1 + monthlyRate, months - i);
        }

        return Math.ceil(futureValue);
    }
}
