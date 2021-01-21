package ru.job4j.ood.solid.lsp.food;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    private final List<Food> shop = new ArrayList<>();

    public Shop() {
    }

    public void add(Food food) {
        shop.add(food);
    }

    @Override
    public boolean accept(Food food) {
        double rsl = analyzeControlQuality(food);
        if (rsl >= 0.25 && rsl <= 0.75) {
            return true;
        }
        if (rsl > 0.75 && rsl < 1) {
            food.setDiscount(0.20);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> clear() {
        List<Food> rsl = new ArrayList<>(shop);
        shop.clear();
        return rsl;
    }

    public List<Food> getAll() {
        return shop;
    }

    @Override
    public int getLength() {
        return shop.size();
    }

    @Override
    public String toString() {
        return "Shop{"
                + "shop="
                + shop
                + '}';
    }
}
