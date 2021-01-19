package ru.job4j.ood.solid.lsp.food;

import java.time.LocalDate;
import java.time.Period;

public class SimpleControlQuality implements ControlQuality {
    private final Warehouse warehouse = new Warehouse();
    private final Shop shop = new Shop();
    private final Trash trash = new Trash();

    @Override
    public boolean controlQuality(Food food) {
        Period base = Period.between(food.getCreateDate(), food.getExpirationDate());
        LocalDate localDate = LocalDate.now();
        Period daysPassed = Period.between(food.getCreateDate(), localDate);
        double rsl = (double) daysPassed.getDays() / base.getDays();
        if (rsl < 0.25) {
            warehouse.add(food);
            return true;
        }
        if (rsl >= 0.25 && rsl <= 0.75) {
            shop.add(food);
            return true;
        }
        if (rsl > 0.75 && rsl < 1) {
            food.setDiscount(0.20);
            shop.add(food);
        } else {
            trash.add(food);
        }
        return true;
    }

    @Override
    public String toString() {
        return "SimpleControlQuality{"
                + "warehouse="
                + warehouse
                + ", shop="
                + shop
                + ", trash="
                + trash
                + '}';
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Shop getShop() {
        return shop;
    }

    public Trash getTrash() {
        return trash;
    }

    public static void main(String[] args) {
        Food food = new Food("eggs",
                LocalDate.of(2021, 2, 22),
                LocalDate.of(2021, 1, 5),
                150.00,
                0.00);
        Period base = Period.between(food.getCreateDate(), food.getExpirationDate());
        LocalDate localDate = LocalDate.now();
        Period daysPassed = Period.between(food.getCreateDate(), localDate);
        double rsl = (double) daysPassed.getDays() / base.getDays();
        System.out.println(base.getDays());
        System.out.println(rsl);
    }

}
