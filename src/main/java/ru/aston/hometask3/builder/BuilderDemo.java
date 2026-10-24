package ru.aston.hometask3.builder;

public class BuilderDemo {

    public static void main(String[] args) {
        CarBuilder builder = new SportsCarBuilder();
        AutomotiveEngineer engineer = new AutomotiveEngineer(builder);
        Car car = engineer.manufactureCar();
        System.out.println("Созданнная машина: ");
        System.out.println("======================================================================");
        System.out.println(car);
        System.out.println("======================================================================");
    }
}
