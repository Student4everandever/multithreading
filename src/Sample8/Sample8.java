package Sample8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 30.03.2019
 */
public class Sample8 {
    static void check(Counter counter) throws InterruptedException {
        List<TestThread> threads = new ArrayList<>();

        for(int i = 0; i < 100; i++) {
            TestThread thread = new TestThread(counter);
            threads.add(thread);
            thread.start();
        }

        for(TestThread thread : threads) {
            thread.join();
        }
        System.out.println(counter);
    }

    public static void main(String [] args) throws InterruptedException {
        check(new BadCounter());
        check(new GoodCounter());
    }
}
