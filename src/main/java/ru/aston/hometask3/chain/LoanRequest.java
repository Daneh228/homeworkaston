package ru.aston.hometask3.chain;

import java.util.Objects;

public final class LoanRequest {

    private final String clientName;
    private final int age;
    private final double monthlyIncome;
    private final int creditScore;
    private final double amount;

    public LoanRequest(String clientName, int age, double monthlyIncome, int creditScore, double amount) {
        this.clientName = Objects.requireNonNull(clientName, "clientName must not be null");
        this.age = age;
        this.monthlyIncome = monthlyIncome;
        this.creditScore = creditScore;
        this.amount = amount;
    }

    public String getClientName() { return clientName; }

    public int getAge() { return age; }

    public double getMonthlyIncome() { return monthlyIncome; }

    public int getCreditScore() { return creditScore; }

    public double getAmount() { return amount; }
}