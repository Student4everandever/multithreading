package Sample10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Alex on 30.03.2019
 */
public class Sample10 {
    static final int THREAD_COUNT = 8;
    static final int PART_LENGTH = 5_000_000;

    public static void main(String [] args) {
        int [] array = new int[THREAD_COUNT * PART_LENGTH];
        Arrays.fill(array, 1);

        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);
        List<Future<Long>> results = new ArrayList<>();
        int offset = 0;
        long result = 0;

        try{
            for(int i = 0; i < THREAD_COUNT; i++) {
                Counter counter = new Counter(array, offset, offset + PART_LENGTH);
                offset += PART_LENGTH;

                Future<Long> future = service.submit(counter);
                results.add(future);
            }

            for(Future<Long> future : results) {
                try{
                    result += future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    return;
                }
            }
            System.out.println("Result = " + result);
        } finally {
            service.shutdownNow();
        }
    }
}
