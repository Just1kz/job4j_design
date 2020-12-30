package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        StringBuilder rsl = new StringBuilder();
        int count = 0;
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            String y;
            while ((y = read.readLine()) != null) {
                if (y.length() != 0 && !y.startsWith("#")) {
                    String[] x = y.split(" ");
                    if (count == 0 && (x[0].equals("400") || x[0].equals("500"))) {
                        if (rsl.length() != 0) {
                            rsl.append(", ");
                        }
                        rsl.append(x[1]);
                        rsl.append("; ");
                        count++;
                    }
                    if (count > 0 && (x[0].equals("200") || x[0].equals("300"))) {
                        rsl.append(x[1]);
                        count--;
                    }
                }
            }
            write(target, rsl.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write(String target, String s) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            out.write(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
