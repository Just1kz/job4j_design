package ru.job4j.concurrent;

public class ConsoleProgress implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Start loading ...");
                int count = 0;
                String[] process = {" \\ ", " | ", " / "};
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.print("\rLoading ... " + process[count] + ".");
                    Thread.sleep(100);
                    count = (count + 1) % process.length;
                }
            } catch (InterruptedException e) {
            System.out.println("");
            System.out.println("Loaded!");
            e.printStackTrace();
            }
        }

    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(10000); /* симулируем выполнение параллельной задачи в течение 1 секунды. */
        progress.interrupt();
    }
}
