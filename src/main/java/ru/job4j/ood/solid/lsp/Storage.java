package ru.job4j.ood.solid.lsp;

import java.util.List;

public interface Storage {

    public void add(Food food);

    public List<Food> getAll();
}
