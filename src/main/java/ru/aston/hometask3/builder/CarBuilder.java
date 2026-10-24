package ru.aston.hometask3.builder;

public interface CarBuilder {

    CarBuilder model();

    CarBuilder fixBody();

    CarBuilder paint();

    CarBuilder fixInterior();

    Car build();
}
