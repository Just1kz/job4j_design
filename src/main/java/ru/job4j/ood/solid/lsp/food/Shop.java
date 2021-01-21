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
    public double analyzeControlQuality(Food food) {
        Period base = Period.between(food.getCreateDate(), food.getExpirationDate());
        LocalDate localDate = LocalDate.now();
        Period daysPassed = Period.between(food.getCreateDate(), localDate);
        return (double) daysPassed.getDays() / base.getDays();
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
