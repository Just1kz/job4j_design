package ru.job4j.ood.solid.lsp.food;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private final List<Food> trash = new ArrayList<>();

    public Trash() {
    }

    public void add(Food food) {
        trash.add(food);
    }

    @Override
    public boolean accept(Food food) {
        double rsl = analyzeControlQuality(food);
        return rsl > 1;
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
        List<Food> rsl = new ArrayList<>(trash);
        trash.clear();
        return rsl;
    }

    public List<Food> getAll() {
        return trash;
    }

    @Override
    public int getLength() {
        return trash.size();
    }

    @Override
    public String toString() {
        return "Trash{"
                + "trash="
                + trash
                + '}';
    }
}
