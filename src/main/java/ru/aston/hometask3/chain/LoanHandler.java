package ru.aston.hometask3.chain;

public interface LoanHandler {

    LoanHandler setNext(LoanHandler next);

    void handle(LoanRequest request);
}