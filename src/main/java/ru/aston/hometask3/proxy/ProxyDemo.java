package ru.aston.hometask3.proxy;

import java.util.Set;

public class ProxyDemo {

    public static void main(String[] args) {
        DocumentService service = new DocumentServiceProxy(
                new RealDocumentService(),
                Set.of("doc-3"),
                Set.of("admin"));

        System.out.println("--- Первое чтение (из хранилища) ---");
        System.out.println(service.readDocument("doc-1", "oleg"));

        System.out.println("--- Повторное чтение (из кэша) ---");
        System.out.println(service.readDocument("doc-1", "oleg"));

        System.out.println("--- Секретный документ, обычный пользователь ---");
        try {
            service.readDocument("doc-3", "oleg");
        } catch (SecurityException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("--- Секретный документ, админ ---");
        System.out.println(service.readDocument("doc-3", "admin"));
    }
}