package ru.job4j.io;

public class ArgZip {
    private final String[] args;

    private final static String directory = "-d";
    private final static String exclude = "-e";
    private final static String output = "-o";

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length != 6) {
            throw new IllegalArgumentException("Wrong Root pattern: key1_param1"
                    + "_key2_param2_key3_param3");
        }
        if (!args[0].equals(directory)) {
            throw new IllegalArgumentException("Wrong KEY of directory");
        }
        if (!args[1].matches("(\\.||C:\\\\)")) {
            throw new IllegalArgumentException("Wrong pattern of directory");
        }
        if (!args[2].equals(exclude)) {
            throw new IllegalArgumentException("Wrong KEY of exclude");
        }
        if (args[3].startsWith(34 + "*.")) {
            throw new IllegalArgumentException("Wrong pattern of exclude");
        }
        if (!args[4].equals(output)) {
            throw new IllegalArgumentException("Wrong KEY of output");
        }
        if (!args[5].endsWith(".zip")) {
            throw new IllegalArgumentException("Wrong pattern of output");
        }
        return false;
    }

    public String directory() {
        valid();
        return args[1];
    }

    public String exclude() {
        valid();
        return args[3];
    }

    public String output() {
        valid();
        return args[5];
    }

    public static void main(String[] args) {
        String x = "-d . -e *.java -o design.zip";
        System.out.println(x);
        System.out.println(args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
        if (!args[3].startsWith("*.")) {
            throw new IllegalArgumentException("Wrong pattern of exclude");
        }
    }

}
