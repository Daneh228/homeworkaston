package ru.aston.hometask3.strategy;

public class StrategyDemo {

    public static void main(String[] args) {
        PaymentService service = new PaymentService(
                new CardPayment("1234 5678 9012 3456", "Oleg Ivanov"));
        service.checkout(1000);

        service.setStrategy(new CashPayment(1100));
        service.checkout(1000);

        // стратегия лямбдой (интерфейс функциональный)
        service.setStrategy(amount -> System.out.println("Оплата бонусами: " + amount));
        service.checkout(1000);
    }
}