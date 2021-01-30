package ru.job4j.ood.solid.lsp.parking;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomCar customCar = (CustomCar) o;
        return Objects.equals(registrationCode, customCar.registrationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationCode);
    }
}
