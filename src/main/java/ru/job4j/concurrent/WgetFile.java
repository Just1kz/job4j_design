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
            long start = System.currentTimeMillis();
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                long finish = System.currentTimeMillis();
                long factTime = finish - start;
                double normalTimeOfSpeed = (double) dataBuffer.length / speed;
                System.out.println(factTime);
                System.out.println(normalTimeOfSpeed);
                if (factTime < normalTimeOfSpeed) {
                    Thread.sleep((long) (normalTimeOfSpeed - factTime) * 1000);
                    start = System.currentTimeMillis();
                }
                System.out.println("Loaded!");
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        String url = null;
        int speed = 0;
        if (args.length >= 2) {
            url = args[0];
            speed = Integer.parseInt(args[1]);
        }
        Thread wget = new Thread(new WgetFile(url, speed));
        wget.start();
        wget.join();
    }
}
