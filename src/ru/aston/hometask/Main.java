package ru.aston.hometask;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Oleg","Ivanov",19);
        System.out.println("Создал обычный класс: " + person);
        ImmutableClass immutableClass = new ImmutableClass("Test",person);
        System.out.println("Вывод неизменяемого поля из иммутабельного класса: " +immutableClass.getName());
        System.out.println("Вывод в иммутабельном классе изменяемого класса: " + immutableClass.getPerson());
        person.setAge(43);
        person.setName("David");
        System.out.println("Измененный класс: " + person);
        System.out.println("Иммутабельный тем временем остался прежним: " + immutableClass.getPerson());
        Person person1 = immutableClass.getPerson();
        person1.setName("Petr");
        System.out.println("person1 после SetName: " + person1);
        System.out.println("Иммутабельный класс после изменения person1: " + immutableClass.getPerson());
    }
}