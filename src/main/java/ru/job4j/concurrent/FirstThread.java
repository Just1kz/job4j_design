package ru.job4j.concurrent;

public class FirstThread implements Runnable {
    @Override
    public void run() {
        ParseFile parseFile = new ParseFile("result.txt");
        parseFile.saveContent(
                parseFile.getContent(), "result2.txt"
        );
        System.out.println(Thread.currentThread().getName()
                + " завершил загрузку первой");
        System.out.println("В файле полная копия");
    }
}
