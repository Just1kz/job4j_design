package ru.job4j.ood.solid.lsp.food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private final List<Food> trash = new ArrayList<>();

    public Trash() {
    }

    public void add(Food food) {
        trash.add(food);
    }

    public List<Food> getAll() {
        return trash;
    }
}
