package ru.job4j.ood.solid.lsp.food;

import java.util.List;

public interface Storage {

    void add(Food food);

    boolean accept(Food food);

    double analyzeControlQuality(Food food);

    List<Food> clear();

    List<Food> getAll();

    int getLength();
}
