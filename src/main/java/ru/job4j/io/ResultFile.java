package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        int[] rsl = new int[100];
        int count = 0;
        for (int i = 1; i <= 10; i++) {
            for (int z = 1; z <= 10; z++) {
                rsl[count++] = z * i;
            }
        }
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("Hello, job4j!".getBytes());
            for (int j : rsl) {
                String x = Integer.toString(j) + " ";
                out.write(x.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
