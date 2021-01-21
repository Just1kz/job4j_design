package ru.job4j.ood.solid.isp;

import java.util.ArrayList;
import java.util.List;

public class Menu implements ManagerMenu {
    private final List<Task> output = new ArrayList<>();

    @Override
    public void add(Task task) {
        if (!output.contains(task)) {
            if (modificationName(task) != null) {
                task.setName(modificationName(task));
            }
            output.add(task);

        }
    }

    @Override
    public void getAllMenu() {
        if (output.size() > 0) {
            List<Task> rsl = new ArrayList<>(sortMenu());
            System.out.println(rsl);
        }
    }

    @Override
    public Task findByNumbers(String number) {
        for (Task x : output) {
            if (x.getNumber().equals(number)) {
                return x;
            }
        }
        return null;
    }

    @Override
    public List<Task> sortMenu() {
        output.sort(new MenuAscByNumber());
        return output;
    }

    @Override
    public String modificationName(Task task) {
            if (task.getNumber().length() / 2 > 1) {
                StringBuilder zxc = new StringBuilder(task.getName());
                for (int i = 0; i < task.getNumber().length(); i++) {
                        zxc.insert(0, "-");
                    if (i == task.getNumber().length() - 1) {
                        zxc.insert(i + 1, " ");
                    }
                }
                return zxc.toString();
        }
        return null;
    }

    public static void main(String[] args) {
      Menu menu = new Menu();
      menu.add(new Task("Task", "1.1."));
      menu.add(new Task("Task", "1."));
      menu.add(new Task("Task", "2."));
      menu.add(new Task("Task", "1.1.1."));
      menu.add(new Task("Task", "1.1.2."));
      menu.add(new Task("Task", "2.1."));
      menu.getAllMenu();
    }
}
