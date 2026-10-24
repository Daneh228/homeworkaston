package ru.aston.hometask3.decorator;

import java.util.Objects;

public class CoffeeDecorator implements Coffee {

    private final Coffee coffee;

    protected CoffeeDecorator(Coffee coffee) {
        this.coffee = Objects.requireNonNull(coffee, "coffee must not be null");
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}
