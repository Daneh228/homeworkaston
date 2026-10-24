package ru.aston.hometask3.builder;

public class ClassicCarBuilder implements CarBuilder {

    private String model;
    private String body;
    private String paint;
    private String interior;

    public ClassicCarBuilder(){
        super();
    }

    @Override
    public CarBuilder model() {
        System.out.println("Классическая модель");
        this.model = "Classic Model";
        return this;
    }

    @Override
    public CarBuilder fixBody() {
        System.out.println("Установлен кузов классической машины");
        this.body = "Classic body";
        return this;
    }

    @Override
    public CarBuilder paint() {
        System.out.println("Покрашена в классический белый цвет");
        this.paint = "Classic white";
        return this;
    }

    @Override
    public CarBuilder fixInterior() {
        System.out.println("Установлен классический интерьер");
        this.interior = "Classic interior";
        return this;
    }

    @Override
    public Car build() {
        Car car = new Car(model,body,interior,paint);
        if (!car.isValid()) {
            throw new IllegalStateException("Сборка классической машины не завершена: заданы не все части");
        }
        return car;
    }
}
