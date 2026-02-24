package com.lab02.task2;

public class Partner {
    private final String companyEmail;
    private final String companyName;

    public Partner(String companyEmail, String companyName) {
        this.companyEmail = companyEmail;
        this.companyName = companyName;
    }

    public String getCompanyEmail() { return companyEmail; }
    public String getCompanyName() { return companyName; }
}