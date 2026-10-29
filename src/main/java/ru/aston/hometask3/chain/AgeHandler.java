package ru.aston.hometask3.chain;

public class AgeHandler extends AbstractLoanHandler {

    private static final int MIN_AGE = 21;
    private static final int MAX_AGE = 65;

    @Override
    protected boolean check(LoanRequest request) {
        return request.getAge() >= MIN_AGE && request.getAge() <= MAX_AGE;
    }

    @Override
    protected String rejectReason() {
        return "возраст должен быть от " + MIN_AGE + " до " + MAX_AGE;
    }
}