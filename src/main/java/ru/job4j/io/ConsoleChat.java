package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final List<String> logAllChat = new LinkedList<>();
    private final List<String> allBotAnswers = new LinkedList<>();
    private final List<String> dataAllBotAnswers = new ArrayList<>(20);

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void getAllBotAnswersOfFile() {
        try (BufferedReader read = new BufferedReader(new FileReader(
                ".\\src\\data\\dataBotAnswers.txt"))) {
            String y;
            while ((y = read.readLine()) != null) {
                dataAllBotAnswers.add(y);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAllLogsChatInFile() throws IOException {
        Files.write(Path.of(path), logAllChat);
    }

    public void setAllBotAnswersInFile() throws IOException {
        Files.write(Path.of(botAnswers), allBotAnswers);
    }

    public String randomBotAnswer() {
        int random = (int) (Math.random() * (dataAllBotAnswers.size() - 1));
        return dataAllBotAnswers.get(random);
    }

    public void run() throws IOException {
        getAllBotAnswersOfFile();
        boolean chat = true;
        boolean bot = true;
        Scanner scanner = new Scanner(System.in);
        while (chat) {
            System.out.print("you: ");
            String userAnswer = scanner.nextLine();
            switch (userAnswer.toLowerCase(Locale.ROOT)) {
                case (OUT):
                    chat = false;
                    bot = false;
                    break;
                case (STOP):
                    bot = false;
                    break;
                case (CONTINUE):
                    bot = true;
                    break;
                default:
                    logAllChat.add(userAnswer);
            }
            if (bot) {
                String x = randomBotAnswer();
                logAllChat.add(x);
                allBotAnswers.add(x);
                System.out.println(x);
            }
        }
        scanner.close();
        setAllLogsChatInFile();
        setAllBotAnswersInFile();
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat(".\\src\\data\\allChatsLog.txt",
                ".\\src\\data\\logBotAnswers.txt");
        cc.run();
    }
}
