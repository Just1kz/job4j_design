package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        byte x = 2;
        short x2 = 10;
        long x3 = 100000;
        char x4 = 35;
        float x5 = (float) 36.6;
        double x6 = 36.632;
        boolean x7 = true;
        LOG.debug("User info name : {}, age : {}, children: {}, cars: {}, salary: {}$, age wife {},"
                        + "body heat: {}, body heat of wife: {}, married: {}"
                , name, age, x, x2, x3, x4, x5, x6, x7);
    }
}
