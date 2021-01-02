package ru.job4j.io;

import java.io.File;

public class ExamSearchAndZip {
    private final String[] args;

    private final static String DIRECTORY = "-d";
    private final static String SEARCHPARAMETR = "-n";
    private final static String OUTPUT = "-o";

    public ExamSearchAndZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length != 7) {
            throw new IllegalArgumentException("Invalid ROOT Pattern! "
                    + "Try again, e.g. java -jar find.jar -d c:/ -n *.txt -m -o log.txt");
        }
        if (!args[0].equals(DIRECTORY)
                || !args[2].equals(SEARCHPARAMETR)
                || !args[5].equals(OUTPUT)) {
            throw new IllegalArgumentException("Wrong NameKEY, "
                    + "Try again, e.g. java -jar find.jar -d c:/ -n *.txt -m -o log.txt");
        }
        if (!args[4].equals(ExamSearchType.M.getName())
                && !args[4].equals(ExamSearchType.F.getName())
                && !args[4].equals(ExamSearchType.R.getName())) {
            throw new IllegalArgumentException("Wrong NameKEY, "
                    + "Try again, e.g. java -jar find.jar -d c:/ -n *.txt -m -o log.txt");
        }
        File file = new File(args[1]);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        return true;
    }

    public String directory() {
        return args[1];
    }

    public String patternSearch() {
        return args[3];
    }

    public String searchType() {
        return args[4];
    }

    public String logPath() {
        return args[6];
    }
}
