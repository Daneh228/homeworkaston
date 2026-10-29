package ru.aston.hometask3.adapter;

import java.math.BigDecimal;
import java.util.Objects;

public class PaymentGatewayAdapter implements PaymentProcessor {

    private final LegacyPaymentGateway gateway;

    public PaymentGatewayAdapter(LegacyPaymentGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway, "gateway must not be null");
    }

    @Override
    public void pay(String payerName, double amountRub) {
        Objects.requireNonNull(payerName, "payerName must not be null");
        if (amountRub <= 0) {
            throw new IllegalArgumentException("Сумма оплаты должна быть больше нуля");
        }

        long kopecks = BigDecimal.valueOf(amountRub).movePointRight(2).longValueExact();
        int code = gateway.makeTransaction(payerName, kopecks);

        if (code != 0) {
            throw new IllegalStateException("Шлюз отклонил платёж, код " + code);
        }
        System.out.println("Платёж на " + amountRub + " руб. успешно проведён");
    }
}