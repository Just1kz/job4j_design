package ru.job4j.concurrent;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class WgetFile implements Runnable {
    private final String url;
    private final int speed;

    public WgetFile(String url, int speed) {
        this.url = url;
        this.speed = speed;
    }

    @Override
    public void run() {
        try (BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream("pom_tmp.xml")) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                LocalDateTime start = LocalDateTime.now();
                while (dataBuffer[1023] == 0) {
                    System.out.println(dataBuffer[1022]);
                }
                LocalDateTime finish = LocalDateTime.now();
                long factTime = start.until(finish, ChronoUnit.MILLIS);
                double normalTimeOfSpeed = (double) dataBuffer.length / speed;
                int rslTime = (int) (normalTimeOfSpeed - factTime) * 1000;
                Thread.sleep(Math.max(rslTime, 0));
                System.out.println(rslTime);
                System.out.println("Loaded!");
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        String url = args[0];
        int speed = Integer.parseInt(args[1]);
        Thread wget = new Thread(new WgetFile(url, speed));
        wget.start();
        wget.join();
        //параметры конфигурации:
        //https://raw.githubusercontent.com/peterarsentev/course_test/master/pom.xml 50
    }
}
