package ru.job4j.ood.solid.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class CustomParking implements Parking {
    private final List<Car> parking = new ArrayList<>();
    private final int size;
    private int nowCarPlaced;

    public CustomParking(int size, int nowCarPlaced) {
        this.size = size;
        this.nowCarPlaced = nowCarPlaced;
    }

    @Override
    public Car getCar(Car car) {
        for (Car value : parking) {
            if (value.registrationCode().equals(car.registrationCode())) {
                return value;
            }
        }
        return null;
    }

    @Override
    public boolean addCar(Car car) {
        if ((nowCarPlaced + car.size()) <= size) {
            nowCarPlaced = nowCarPlaced + car.size();
            parking.add(car);
            return true;
        }
        return false;
    }
}
