package ru.job4j.ood.solid.lsp;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.ood.solid.lsp.food.Food;
import ru.job4j.ood.solid.lsp.food.SimpleControlQuality;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class SimpleControlQualityTest {
    SimpleControlQuality input = new SimpleControlQuality();
    Food milk = new Food("milk",
            LocalDate.of(2021, 2, 3),
            LocalDate.of(2021, 1, 10),
            100.00,
            0.00); //0.41666 - shop
    Food meat = new Food("meat",
            LocalDate.of(2021, 1, 17),
            LocalDate.of(2021, 1, 2),
            550.00,
            0.00); //1.2 - trash
    Food bread = new Food("bread",
            LocalDate.of(2021, 1, 23),
            LocalDate.of(2021, 1, 18),
            35.00,
            0.00); //0.4 - shop
    Food fish = new Food("fish",
            LocalDate.of(2021, 1, 18),
            LocalDate.of(2021, 1, 10),
            700.00,
            0.00); //1.25 - trash
    Food chicken = new Food("chicken",
            LocalDate.of(2021, 2, 1),
            LocalDate.of(2021, 1, 18),
            150.00,
            0.00); //0.1428 - warehouse
    Food eggs = new Food("eggs",
            LocalDate.of(2021, 2, 22),
            LocalDate.of(2021, 1, 5),
            90.00,
            0.00); // 0.8823 - скидка и в Shop

    @Test
    public void controlQualityShop() {
        input.controlQuality(milk);
        input.controlQuality(bread);
        input.controlQuality(eggs);
        List<Food> output = List.of(milk, bread, eggs);
        Assert.assertThat(input.getShop().getAll().toString(), is(output.toString()));
    }

    @Test
    public void controlQualityTrash() {
        input.controlQuality(meat);
        input.controlQuality(fish);
        List<Food> output = List.of(meat, fish);
        Assert.assertThat(input.getTrash().getAll().toString(), is(output.toString()));
    }

    @Test
    public void controlQualityWarehouse() {
        input.controlQuality(chicken);
        List<Food> output = List.of(chicken);
        Assert.assertThat(input.getWarehouse().getAll().toString(), is(output.toString()));
    }

    @Test
    public void controlQualityDiscounted() {
        input.controlQuality(eggs);
        List<Food> output = List.of(eggs);
        Assert.assertThat(input.getShop().getAll().toString(), is(output.toString()));
        Assert.assertThat(eggs.getDiscount(), is(0.20));
    }
}

