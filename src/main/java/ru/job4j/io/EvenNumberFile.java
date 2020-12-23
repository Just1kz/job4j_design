package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {

        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int z;
            boolean rsl;
            while ((z = in.read()) != -1) {

                if (z !=  10 && z != 13) {
                    String s = Character.toString((char) z);
                    rsl = (char) z % 2 == 0;
                    text
                            .append(s)
                            .append(" - является ли четным числом? - ")
                            .append(rsl).append((char)10);
                }
            }
                System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
