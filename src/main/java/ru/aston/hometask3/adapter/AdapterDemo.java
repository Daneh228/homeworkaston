package ru.aston.hometask3.adapter;

public class AdapterDemo {

    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentGatewayAdapter(new LegacyPaymentGateway());

        processor.pay("Oleg Ivanov", 1000.50);

        try {
            processor.pay("Oleg Ivanov", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}