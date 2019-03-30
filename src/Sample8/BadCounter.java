package Sample8;

/**
 * Created by Alex on 30.03.2019
 */
public class BadCounter implements Counter {
    private volatile int x;


    @Override
    public void increment() {
    //public synchronized void increment() {
        x++;
    }

    @Override
    public String toString() {
        return "BadCounter{" +
                "x=" + x +
                '}';
    }
}
