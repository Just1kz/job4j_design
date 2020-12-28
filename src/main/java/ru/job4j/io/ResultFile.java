package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        int[][] rsl = new int[10][10];
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("Hello, job4j! ".getBytes());
            for (int i = 1; i < rsl.length; i++) {
                for (int z = 1; z < rsl[i].length; z++) {
                    rsl[i][z] = z * i;
                    String x = Integer.toString(rsl[i][z]) + " ";
                    out.write(x.getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
