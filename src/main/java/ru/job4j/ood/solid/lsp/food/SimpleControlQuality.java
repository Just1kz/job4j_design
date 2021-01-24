package ru.job4j.ood.solid.lsp.food;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class SimpleControlQuality implements ControlQuality {
    private final List<Storage> storages = new ArrayList<>();

    @Override
    public void distribute(Food food) {
        for (Storage storage : storages) {
            if (storage.accept(food)) {
                storage.add(food);
                break;
            }
        }
    }

    @Override
    public List<Food> clear() {
        List<Food> rsl = new ArrayList<>();
        for (Storage storage : storages) {
            if (storage.getLength() != 0) {
                rsl.addAll(storage.getAll());
            }
        }
        storages.clear();
        return rsl;
    }

    @Override
    public void add(Storage storage) {
        storages.add(storage);
    }

    @Override
    public void resort() {
        List<Food> foods = clear();
        for (Food out : foods) {
            distribute(out);
        }
    }

    public List<Storage> getStorages() {
        return storages;
    }

    @Override
    public String toString() {
        return "SimpleControlQuality{"
                + "storages="
                + storages
                + '}';
    }

    public static void main(String[] args) {
        Food food = new Food("eggs",
                LocalDate.of(2021, 2, 25),
                LocalDate.of(2021, 1, 20),
                150.00,
                0.00);
        Period base = Period.between(food.getCreateDate(), food.getExpirationDate());
        LocalDate localDate = LocalDate.now();
        Period daysPassed = Period.between(food.getCreateDate(), localDate);
        double rsl = (double) daysPassed.getDays() / base.getDays();
        System.out.println(base.getDays());
        System.out.println(rsl);

        SimpleControlQuality z = new SimpleControlQuality();
        z.distribute(food);

//        System.out.println(z.storages.get(1).analyzeControlQuality(food));
//        System.out.println(z.storages.get(1).accept(food));
        System.out.println(z);
    }

}
