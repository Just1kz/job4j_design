package ru.job4j.ood.solid.ood.rules;

import ru.job4j.ood.solid.ood.input.InputManager;

public interface RulesSteps {
    boolean analyzeStep(String x);
    //не пошёл ли игрок уже на занятую ячейку (true если ход возможен) *и пошёл ли он своим символом*
}
