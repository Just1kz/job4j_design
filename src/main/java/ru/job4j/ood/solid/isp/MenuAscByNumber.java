package ru.job4j.ood.solid.isp;

import java.util.Comparator;

public class MenuAscByNumber implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        String[] x1 = o1.getNumber().split("\\.");
        String[] x2 = o2.getNumber().split("\\.");
        int rsl = x1[0].compareTo(x2[0]);
        if (rsl == 0) {
            rsl = o1.getNumber().compareTo(o2.getNumber());
        }
        return rsl;
    }
}
