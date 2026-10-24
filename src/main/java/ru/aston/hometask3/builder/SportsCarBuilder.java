package ru.aston.hometask3.builder;

public class SportsCarBuilder implements CarBuilder {

    private String model;
    private String body;
    private String paint;
    private String interior;

    public SportsCarBuilder(){
        super();
    }


    @Override
    public CarBuilder model() {
        System.out.println("Спортивная модель");
        this.model = "Sports Model";
        return this;
    }

    @Override
    public CarBuilder fixBody() {
        System.out.println("Установлен кузов спортивной машины");
        this.body = "Sport Body";
        return this;
    }

    @Override
    public CarBuilder paint() {
        System.out.println("Покрашена в металический цвет");
        this.paint = "Black metallic";
        return this;
    }

    @Override
    public CarBuilder fixInterior() {
        System.out.println("Установлен современный интерьер");
        this.interior = "Modern interior";
        return this;
    }

    @Override
    public Car build() {
        Car car = new Car(model,body,interior,paint);
        if (!car.isValid()) {
            throw new IllegalStateException("Сборка спортивной машины не завершена: заданы не все части");
        }
        return car;
    }
}
