package ru.job4j.concurrent;


import static org.hamcrest.Matchers.is;
import org.junit.Assert;
import org.junit.Test;
import java.util.concurrent.atomic.AtomicReference;


public class CashTest {

    @Test
    public void test() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Cash baseCache = new Cash();
        Base base = new Base(1, 1);
        baseCache.add(base);
        Thread thread1 = new Thread(
                () -> {
                    try {
                        baseCache.update(new Base(1, 1));
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        Thread thread2 = new Thread(
                () -> {
                    try {
                        baseCache.update(new Base(1, 2));
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        Assert.assertThat(ex.get().getMessage(), is("Invalid version"));
    }
}