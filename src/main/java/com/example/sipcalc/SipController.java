package com.example.sipcalc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SipController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("sipRequest", new SipRequest());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateSip(@ModelAttribute SipRequest sipRequest, Model model) {
        // SIP calculation logic
        double monthlyInvestment = sipRequest.getMonthlyInvestment();
        double rateOfInterest = sipRequest.getRateOfInterest() / 100 / 12;
        int numberOfMonths = sipRequest.getInvestmentPeriod() * 12;

        double futureValue = 0;
        for (int i = 0; i < numberOfMonths; i++) {
            futureValue = (futureValue + monthlyInvestment) * (1 + rateOfInterest);
        }

        double totalInvestment = monthlyInvestment * numberOfMonths;
        double estimatedReturns = futureValue - totalInvestment;

        SipResult sipResult = new SipResult(totalInvestment, estimatedReturns, futureValue);
        model.addAttribute("sipResult", sipResult);

        return "index";
    }
}
