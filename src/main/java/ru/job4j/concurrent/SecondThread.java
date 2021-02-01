package ru.job4j.concurrent;

public class SecondThread implements Runnable {
    @Override
    public void run() {
        ParseFile parseFile = new ParseFile("result.txt");
        parseFile.saveContent(
                parseFile.getContent(x -> x == 2), "result2.txt"
        );
        System.out.println(Thread.currentThread().getName()
                + " завершил загрузку первой");
        System.out.println("В файле копия без русских букв");
    }
}
