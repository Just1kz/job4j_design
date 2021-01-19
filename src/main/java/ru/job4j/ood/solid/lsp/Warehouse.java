package ru.job4j.ood.solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private final List<Food> warehouse = new ArrayList<>();

    public Warehouse() {
    }

    public void add(Food food) {
        warehouse.add(food);
    }

    public List<Food> getAll() {
        return warehouse;
    }
}
