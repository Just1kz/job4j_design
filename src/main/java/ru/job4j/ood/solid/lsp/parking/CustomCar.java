package ru.job4j.ood.solid.lsp.parking;

public class CustomCar implements Car {
    private final String name;
    private final int size;
    private final String registrationCode;

    public CustomCar(String name, int size, String registrationCode) {
        this.name = name;
        this.size = size;
        this.registrationCode = registrationCode;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String registrationCode() {
        return registrationCode;
    }
}
