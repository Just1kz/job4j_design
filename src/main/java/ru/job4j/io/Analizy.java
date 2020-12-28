package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> zxc = new ArrayList<>();
        int count = 0;
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String y;
            while ((y = read.readLine()) != null) {
                if (y.length() != 0 && !y.startsWith("#")) {
                    String[] x = y.split(" ");
                    if (count == 0 && (x[0].equals("400") || x[0].equals("500"))) {
                        out.write(x[1]);
                        out.write("; ");
                        count++;
                    }
                    if (count > 0 && (x[0].equals("200") || x[0].equals("300"))) {
                        out.write(x[1]);
                        out.write(10);
                        count--;
                    }
                }
            }
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
