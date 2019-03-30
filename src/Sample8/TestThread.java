package Sample8;

/**
 * Created by Alex on 30.03.2019
 */
public class TestThread extends Thread {
    private final Counter counter;


    public TestThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(System.currentTimeMillis() % 100);
        } catch (InterruptedException e) {
            return;
        }
        counter.increment();
    }
}
