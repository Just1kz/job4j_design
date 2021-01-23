package ru.job4j.ood.solid.ood.input;

public interface InputManager {
    String ask();

    String[] splitAsk(String x, String symbolToSplit);
}
