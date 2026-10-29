package ru.aston.hometask3.decorator;

public class SugarDecorator extends CoffeeDecorator {

    private static final double SUGAR_COST = 10.0;

    private final int quantity;

    public SugarDecorator(Coffee coffee) {
        this(coffee, 1);
    }

    public SugarDecorator(Coffee coffee, int quantity) {
        super(coffee);
        if (quantity < 1) {
            throw new IllegalArgumentException("quantity must be at least 1");
        }
        this.quantity = quantity;
    }

    @Override
    public String getDescription() {
        String addon = quantity > 1 ? "сахар x" + quantity : "сахар";
        return super.getDescription() + ", " + addon;
    }

    @Override
    public double getCost() {
        return super.getCost() + SUGAR_COST * quantity;
    }
}