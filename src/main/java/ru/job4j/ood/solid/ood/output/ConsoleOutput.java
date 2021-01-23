package ru.job4j.ood.solid.ood.output;

public class ConsoleOutput implements OutputManager {

    @Override
    public void printTable(String[][] x) {
        for (String[] strings : x) {
            println("");
            for (int y = 0; y < strings.length; y++) {
                if (y == strings.length - 1) {
                    System.out.print("[" + strings[y] + "]");
                } else {
                    System.out.print("[" + strings[y] + "] | ");
                }
            }
        }
        System.out.println();
    }
}
