package ru.aston.hometask3.chain;

import java.util.Objects;

public abstract class AbstractLoanHandler implements LoanHandler {

    private LoanHandler next;

    @Override
    public LoanHandler setNext(LoanHandler next) {
        this.next = Objects.requireNonNull(next, "next must not be null");
        return next;
    }

    @Override
    public void handle(LoanRequest request) {
        Objects.requireNonNull(request, "request must not be null");
        if (!check(request)) {
            System.out.println("Заявка отклонена (" + getClass().getSimpleName() + "): " + rejectReason());
            return;
        }
        System.out.println("Проверка пройдена: " + getClass().getSimpleName());
        if (next != null) {
            next.handle(request);
        } else {
            System.out.println("Заявка клиента " + request.getClientName() + " ОДОБРЕНА");
        }
    }

    protected abstract boolean check(LoanRequest request);

    protected abstract String rejectReason();
}