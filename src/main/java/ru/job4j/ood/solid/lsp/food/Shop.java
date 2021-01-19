package ru.job4j.ood.solid.lsp.food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private final List<Food> shop = new ArrayList<>();

    public Shop() {
    }

    public void add(Food food) {
        shop.add(food);
    }

    public List<Food> getAll() {
        return shop;
    }
}
