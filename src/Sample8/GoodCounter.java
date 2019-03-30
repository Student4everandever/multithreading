package Sample8;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Alex on 30.03.2019
 */
public class GoodCounter implements Counter {
    private AtomicInteger x = new AtomicInteger();

    @Override
    public void increment() {
        x.getAndIncrement();
    }

    @Override
    public String toString() {
        return "GoodCounter{" +
                "x=" + x.get() +
                '}';
    }
}
