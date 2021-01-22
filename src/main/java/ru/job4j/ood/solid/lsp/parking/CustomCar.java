package ru.job4j.ood.solid.lsp.parking;

public class CustomCar implements Car {
    private String name;
    private int size;
    private String registrationCode;

    public CustomCar(String name, int size, String registrationCode) {
        this.name = name;
        this.size = size;
        this.registrationCode = registrationCode;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String registrationCode() {
        return null;
    }
}
