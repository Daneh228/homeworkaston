package ru.aston.hometask3.decorator;

public class SimpleCoffee implements Coffee {

    private static final double BASE_COST = 100.0;

    @Override
    public String getDescription() {
        return "Эспрессо";
    }

    @Override
    public double getCost() {
        return BASE_COST;
    }
}
