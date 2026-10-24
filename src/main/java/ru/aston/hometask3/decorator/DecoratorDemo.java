package ru.aston.hometask3.decorator;

public class DecoratorDemo {

    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        print(coffee);

        coffee = new MilkDecorator(coffee,6);
        print(coffee);

        coffee = new SugarDecorator(coffee);
        print(coffee);

        Coffee doubleMilk = new SugarDecorator(new MilkDecorator(new SimpleCoffee(), 2), 3);
        print(doubleMilk);
    }

    private static void print(Coffee coffee) {
        System.out.println(coffee.getDescription() + " = " + coffee.getCost());
    }
}
