package ru.job4j.ood.solid.ood.input;

import java.util.Scanner;

public class ConsoleInput implements InputManager {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String ask() {
        return scanner.nextLine();
    }

    @Override
    public String[] splitAsk(String x, String symbolToSplit) {
        return x.split(symbolToSplit);
    }
}
