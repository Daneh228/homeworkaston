package ru.aston.hometask3.chain;

public class ChainDemo {

    public static void main(String[] args) {
        LoanHandler chain = new AgeHandler();
        chain.setNext(new CreditScoreHandler())
                .setNext(new IncomeHandler());

        System.out.println("--- Хороший клиент ---");
        chain.handle(new LoanRequest("Oleg", 30, 100_000, 750, 500_000));

        System.out.println("--- Слишком молодой ---");
        chain.handle(new LoanRequest("Petr", 19, 100_000, 750, 500_000));

        System.out.println("--- Низкий рейтинг ---");
        chain.handle(new LoanRequest("Ivan", 35, 100_000, 500, 500_000));

        System.out.println("--- Слишком большая сумма ---");
        chain.handle(new LoanRequest("Anna", 40, 50_000, 800, 5_000_000));
    }
}