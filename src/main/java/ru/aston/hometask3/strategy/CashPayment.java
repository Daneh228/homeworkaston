package ru.aston.hometask3.strategy;


public class CashPayment implements PaymentStrategy{

    private static final double COMMISSION_RATE = 0.02;

    private final double cash;

    public CashPayment(double cash) {
        if (cash <= 0) {
            throw new IllegalArgumentException("Чтобы совершить покупку нужно больше денег");
        }
        this.cash = cash;
    }


    @Override
    public void pay(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма оплаты должна быть больше 0");
        }
        double total = amount + amount * COMMISSION_RATE;
        if (cash < total) {
            throw new IllegalArgumentException(String.format(
                    "Недостаточно наличных: нужно %.2f, внесено %.2f", total, cash));
        }
        double change = cash - total;
        System.out.printf(
                "Оплата наличными: %.2f (комиссия %.2f), внесено: %.2f, сдача: %.2f%n",
                total, amount * COMMISSION_RATE, cash, change);

    }
}
