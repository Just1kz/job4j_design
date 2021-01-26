package ru.job4j.ood.solid.lsp.parking;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class CustomParkingTest {

    @Test
    public void whenCanJoinParkPlace() {
        Parking parking = new CustomParking(2, 0, 0, 0);
        Car car = new CustomCar("Audi TT", 1, "ип406з");
        Assert.assertTrue(parking.addCar(car));
        Assert.assertEquals(car, parking.getCar(car));
    }

    @Test
    public void whenSmallParking() {
        Parking parking = new CustomParking(1, 0, 0, 0);
        Car car = new CustomCar("Audi TT", 1, "ип406з");
        Car car2 = new CustomCar("КАМАЗ", 2, "зв345у");
        assertThat(parking.addCar(car), is(true));
        assertThat(parking.addCar(car2), is(false));
    }

    @Test
    public void whenParkingFull() {
        Parking parking = new CustomParking(10, 0, 10, 0);
        Car car = new CustomCar("Audi TT", 1, "ип406з");
        assertThat(parking.addCar(car), is(false));
    }

    @Test
    public void whenSearchCarInParking() {
        Parking parking = new CustomParking(10, 1, 9, 0);
        Car car = new CustomCar("Audi TT", 1, "ип406з");
        Car car2 = new CustomCar("КАМАЗ", 2, "зв345у");
        parking.addCar(car2);
        parking.addCar(car);
        Assert.assertThat(parking.getCar(car), Is.is(car));
        Assert.assertThat(parking.getCar(car2), Is.is(car2));
    }
}