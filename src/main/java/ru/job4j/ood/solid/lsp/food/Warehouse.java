package ru.job4j.ood.solid.lsp.food;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private final List<Food> warehouse = new ArrayList<>();

    public Warehouse() {
    }

    public void add(Food food) {
        warehouse.add(food);
    }

    @Override
    public boolean accept(Food food) {
        double rsl = analyzeControlQuality(food);
        if (rsl < 0.25) {
            return true;
        }
        return false;
    }

    @Override
    public List<Food> clear() {
        List<Food> rsl = new ArrayList<>(warehouse);
        warehouse.clear();
        return rsl;
    }

    public List<Food> getAll() {
        return warehouse;
    }

    @Override
    public int getLength() {
        return warehouse.size();
    }

    @Override
    public String toString() {
        return "Warehouse{"
                + "warehouse="
                + warehouse
                + '}';
    }
}
