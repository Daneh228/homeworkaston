package ru.aston.hometask3.adapter;

public class LegacyPaymentGateway {

    public int makeTransaction(String account, long amountInKopecks) {
        System.out.println("[Legacy] Транзакция: счёт=" + account + ", сумма=" + amountInKopecks + " коп.");
        return amountInKopecks > 0 ? 0 : 1;   // 0 - успех, 1 - ошибка
    }
}