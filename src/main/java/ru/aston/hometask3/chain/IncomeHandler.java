package ru.aston.hometask3.chain;

public class IncomeHandler extends AbstractLoanHandler {

    private static final int MAX_MONTHS_OF_INCOME = 12;

    @Override
    protected boolean check(LoanRequest request) {
        return request.getAmount() <= request.getMonthlyIncome() * MAX_MONTHS_OF_INCOME;
    }

    @Override
    protected String rejectReason() {
        return "сумма кредита больше годового дохода";
    }
}