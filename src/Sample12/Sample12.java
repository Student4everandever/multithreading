package Sample12;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex on 30.03.2019
 */

class Timer implements Runnable {
    @Override
    public void run() {
        System.out.println("Tick");
    }
}

public class Sample12 {
    public static void main(String [] args) throws InterruptedException {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        try{
            service.scheduleWithFixedDelay(new Timer(), 5,3, TimeUnit.SECONDS);
            Thread.sleep(20000);
        } finally {
            service.shutdown();
        }
    }
}
