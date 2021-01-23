package ru.job4j.ood.solid.lsp.parking;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class CustomParkingTest {

    @Ignore
    @Test
    public void whenCanJoinParkPlace() {
        Parking parking = new CustomParking(2, 0);
        Car car = new CustomCar("Audi TT", 1, "ип406з");
        Assert.assertTrue(parking.addCar(car));
        Assert.assertEquals(car, parking.getCar(car));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenSmallParking() {
        Parking parking = new CustomParking(1, 0);
        Car car = new CustomCar("Audi TT", 1, "ип406з");
        Car car2 = new CustomCar("КАМАЗ", 2, "зв345у");
        parking.addCar(car);
        parking.addCar(car2);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenParkingFull() {
        Parking parking = new CustomParking(10, 10);
        Car car = new CustomCar("Audi TT", 1, "ип406з");
        parking.addCar(car);
    }

    @Ignore
    @Test
    public void whenSearchCarInParking() {
        Parking parking = new CustomParking(10, 0);
        Car car = new CustomCar("Audi TT", 1, "ип406з");
        parking.addCar(car);
        Assert.assertThat(parking.getCar(car), Is.is(car));
    }
}