package ru.job4j.ood.solid.lsp.food;

import java.util.List;

public interface ControlQuality {
    void distribute(Food food);

    List<Food> clear();

    void add(Storage storage);

    void resort();
}
