package ru.job4j.ood.solid.lsp.parking;

public interface Parking {
    Car getCar(Car car);

    void addCar(Car car);
}
