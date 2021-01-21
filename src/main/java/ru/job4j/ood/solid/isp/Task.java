package ru.job4j.ood.solid.isp;

import java.util.Comparator;
import java.util.Objects;

public class Task implements Comparator<Task> {
    private String name;
    private String number;

    public Task(String type, String number) {
        this.name = type;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public int compare(Task o1, Task o2) {
        return Integer.compare(Integer.parseInt(o1.number), Integer.parseInt(o2.number));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return Objects.equals(name, task.name)
                && Objects.equals(number, task.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public String toString() {
        return "Task{"
                + "type='"
                + name
                + '\''
                + ", number='"
                + number
                + '\''
                + '}';
    }
}
