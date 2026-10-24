package ru.aston.hometask3.chain;

public class CreditScoreHandler extends AbstractLoanHandler {

    private static final int MIN_SCORE = 600;

    @Override
    protected boolean check(LoanRequest request) {
        return request.getCreditScore() >= MIN_SCORE;
    }

    @Override
    protected String rejectReason() {
        return "кредитный рейтинг ниже " + MIN_SCORE;
    }
}