package ru.aston.hometask3.proxy;

import java.util.Map;
import java.util.NoSuchElementException;

public class RealDocumentService implements DocumentService {

    private static final long LOADING_DELAY_MS = 1000;

    private final Map<String, String> storage = Map.of(
            "doc-1", "Отчёт за квартал",
            "doc-2", "Договор с поставщиком",
            "doc-3", "Секретный план развития"
    );

    @Override
    public String readDocument(String documentId, String user) {
        System.out.println("[Хранилище] Загрузка документа " + documentId + "...");
        try {
            Thread.sleep(LOADING_DELAY_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Загрузка прервана", e);
        }
        String content = storage.get(documentId);
        if (content == null) {
            throw new NoSuchElementException("Документ не найден: " + documentId);
        }
        return content;
    }
}