package ru.aston.hometask3.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DocumentServiceProxy implements DocumentService {

    private final DocumentService realService;
    private final Set<String> restrictedDocuments;
    private final Set<String> admins;
    private final Map<String, String> cache = new HashMap<>();

    public DocumentServiceProxy(DocumentService realService,
                                Set<String> restrictedDocuments,
                                Set<String> admins) {
        this.realService = Objects.requireNonNull(realService, "realService must not be null");
        this.restrictedDocuments = Set.copyOf(restrictedDocuments);
        this.admins = Set.copyOf(admins);
    }

    @Override
    public String readDocument(String documentId, String user) {
        Objects.requireNonNull(documentId, "documentId must not be null");
        Objects.requireNonNull(user, "user must not be null");

        if (restrictedDocuments.contains(documentId) && !admins.contains(user)) {
            System.out.println("[Прокси] Доступ запрещён: " + user + " -> " + documentId);
            throw new SecurityException("У пользователя " + user + " нет доступа к " + documentId);
        }

        String cached = cache.get(documentId);
        if (cached != null) {
            System.out.println("[Прокси] Документ " + documentId + " взят из кэша");
            return cached;
        }

        String content = realService.readDocument(documentId, user);
        cache.put(documentId, content);
        return content;
    }
}