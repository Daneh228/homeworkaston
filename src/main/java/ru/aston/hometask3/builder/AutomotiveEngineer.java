package ru.aston.hometask3.builder;

public class AutomotiveEngineer {

    private CarBuilder builder;

    public AutomotiveEngineer(CarBuilder builder) {
        super();
        this.builder = builder;
        if (this.builder == null){
            throw new IllegalArgumentException("Инжинер не может работать без Car Builder");
        }
    }

    public Car manufactureCar() {
        return builder.model().fixBody().paint().fixInterior().build();
    }
}
