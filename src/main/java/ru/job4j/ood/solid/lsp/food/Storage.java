package ru.job4j.ood.solid.lsp.food;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public interface Storage {

    void add(Food food);

    boolean accept(Food food);

    default double analyzeControlQuality(Food food) {
        Period base = Period.between(food.getCreateDate(), food.getExpirationDate());
        LocalDate localDate = LocalDate.now();
        Period daysPassed = Period.between(food.getCreateDate(), localDate);
        return (double) daysPassed.getDays() / base.getDays();
    }

    List<Food> clear();

    List<Food> getAll();

    int getLength();
}
