package ru.aston.hometask3.adapter;

public interface PaymentProcessor {

    void pay(String payerName, double amountRub);
}