package ru.job4j.concurrent;

import net.jcip.annotations.Immutable;

import java.io.*;

@Immutable
public class ParseFile {
    private final String path;

    public ParseFile(String path) {
        this.path = path;
    }

    public synchronized String getFile() {
        return path;
    }

    public synchronized String getContent() {
        StringBuilder output = new StringBuilder();
        try (BufferedReader i = new BufferedReader(new FileReader(this.path))) {
            int data;
            while ((data = i.read()) > 0) {
                output.append((char) data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public synchronized String getContentWithoutUnicode() {
        StringBuilder output = new StringBuilder();
        try (BufferedReader input = new BufferedReader(new FileReader(this.path))) {
            int data;
            while ((data = input.read()) > 0) {
                if (data < 0x80) {
                    output.append((char) data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public synchronized void saveContent(String content, String target) {
        try (PrintWriter output = new PrintWriter(new FileOutputStream(target))) {
            for (int i = 0; i < content.length(); i += 1) {
                output.write(content.charAt(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new FirstThread());
        Thread thread2 = new Thread(new SecondThread());
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
    }
}
