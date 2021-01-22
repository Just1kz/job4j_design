package ru.job4j.ood.solid.lsp.parking;

public interface Parking {
    Car getCar(Car car);

    boolean addCar(Car car);
}
