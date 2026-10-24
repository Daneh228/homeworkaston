package ru.aston.hometask3.strategy;

import java.util.Objects;

public class CardPayment implements PaymentStrategy {

    private static final int CARD_NUMBER_LENGTH = 16;
    private static final double COMMISSION_RATE = 0.01;

    private final String cardNumber;
    private final String holderName;

    public CardPayment(String cardNumber, String holderName) {
        Objects.requireNonNull(cardNumber, "Номер карты не может быть пустой");
        Objects.requireNonNull(holderName, "Имя владельца карты не может быть пустым");

        String digits = cardNumber.replace(" ", "");
        if (!digits.matches("\\d{" + CARD_NUMBER_LENGTH + "}")) {
            throw new IllegalArgumentException("Номер карты должен состоять из " + CARD_NUMBER_LENGTH + " цифр");
        }

        if (holderName.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.cardNumber = digits;
        this.holderName = holderName;
    }

    @Override
    public void pay(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма оплаты должна быть больше 0");
        }

        double total = amount + amount * COMMISSION_RATE;

        System.out.println("Оплата картой " + maskedNumber() + " (" + holderName + ") " + amount + " комиссия " +
                amount * COMMISSION_RATE + " = " + total);

    }

    private String maskedNumber() {
        return "**** **** **** " + cardNumber.substring((CARD_NUMBER_LENGTH) - 4);
    }
}
