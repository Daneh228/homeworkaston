package ru.aston.hometask3.decorator;

public class MilkDecorator extends CoffeeDecorator {

    private static final double MILK_COST = 30.0;

    private final int quantity;

    public MilkDecorator(Coffee coffee) {
        this(coffee, 1);
    }

    public MilkDecorator(Coffee coffee, int quantity) {
        super(coffee);
        if (quantity < 1) {
            throw new IllegalArgumentException("quantity must be at least 1");
        }
        this.quantity = quantity;
    }

    @Override
    public String getDescription() {
        String addon = quantity > 1 ? "молоко x" + quantity : "молоко";
        return super.getDescription() + ", " + addon;
    }

    @Override
    public double getCost() {
        return super.getCost() + MILK_COST * quantity;
    }
}