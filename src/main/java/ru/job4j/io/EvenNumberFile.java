package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {

        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int z;
            boolean rsl;
            while ((z = in.read()) != -1) {

                if (z ==  48
                        || z == 49
                        || z == 50
                        || z == 51
                        || z == 52
                        || z == 53
                        || z == 54
                        || z == 55
                        || z == 56
                        || z == 57) {
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
