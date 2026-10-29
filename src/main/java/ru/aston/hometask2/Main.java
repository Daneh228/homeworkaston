package ru.aston.hometask2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Student> students = readStudents();
        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getRelease() > 2000)
                .limit(3)
                .map(Book::getRelease)
                .findFirst().ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Книга, выпущенная после 2000 года, не найдена")
                );
    }

    private static List<Student> readStudents() throws IOException {
        try (InputStream in = Main.class.getResourceAsStream("/students.json")){
            if (in == null){
                throw new IOException("Файл students.json не найден");
            }
            Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
            Type listType = new TypeToken<List<Student>>() {}.getType();
            return new Gson().fromJson(reader, listType);
        }
    }
}
