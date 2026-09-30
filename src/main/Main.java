package main;

import FirstHomeWork.ImmutableClass;
import FirstHomeWork.Person;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Oleg","Ivanov",19);
        System.out.println(person);
        ImmutableClass immutableClass = new ImmutableClass("Test",person);
        System.out.println(immutableClass.getName());
        System.out.println(immutableClass.getPerson());
        person.setAge(43);
        person.setName("David");
        System.out.println(person);
        System.out.println(immutableClass.getPerson());
        Person person1 = immutableClass.getPerson();
        person1.setName("KMSAUTO");
        System.out.println(person1);
        System.out.println(immutableClass.getPerson());
    }
}