package ru.job4j.ood.solid.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class CustomParking implements Parking {
    private final List<Car> parkingLittleCar = new ArrayList<>();
    private final List<Car> parkingBigCar = new ArrayList<>();
    private final int sizeLittle;
    private final int sizeBig;
    private int nowCarPlacedLittle;
    private int nowCarPlacedBig;

    public CustomParking(int sizeLittle, int sizeBig, int nowCarPlacedLittle, int nowCarPlacedBig) {
        this.sizeLittle = sizeLittle;
        this.sizeBig = sizeBig;
        this.nowCarPlacedLittle = nowCarPlacedLittle;
        this.nowCarPlacedBig = nowCarPlacedBig;
    }

    @Override
    public Car getCar(Car car) {
        if (car.size() == 1) {
            for (Car value : parkingLittleCar) {
                if (value.registrationCode().equals(car.registrationCode())) {
                    return value;
                }
            }
        } else {
            for (Car value : parkingBigCar) {
                if (value.registrationCode().equals(car.registrationCode())) {
                    return value;
                }
            }
        }
        return null;
    }

    @Override
    public boolean addCar(Car car) {
        if (car.size() == 1
                && (nowCarPlacedLittle + car.size()) <= sizeLittle) {
            nowCarPlacedLittle = nowCarPlacedLittle + car.size();
            parkingLittleCar.add(car);
            return true;
        }
        if (car.size() == 2
                && (nowCarPlacedBig + 1) <= sizeBig) {
            nowCarPlacedBig = nowCarPlacedBig + 1;
            parkingBigCar.add(car);
            return true;
        }
        System.out.println("Вы пытаетесь поместить в парковку машину не соответствующего типа");
        return false;
    }
}
