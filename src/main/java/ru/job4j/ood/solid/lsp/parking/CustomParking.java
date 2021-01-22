package ru.job4j.ood.solid.lsp.parking;

public class CustomParking implements Parking {
    private int size;
    private int nowCarPlaced;

    public CustomParking(int size, int nowCarPlaced) {
        this.size = size;
        this.nowCarPlaced = nowCarPlaced;
    }

    @Override
    public Car getCar(Car car) {
        return null;
    }

    @Override
    public boolean addCar(Car car) {
        return false;
    }
}
