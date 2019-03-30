package Sample9;

import java.math.BigInteger;
import java.util.concurrent.*;

/**
 * Created by Alex on 30.03.2019
 */
public class Sample9 {
    public static void main(String [] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try{
            Future<BigInteger> future = service.submit(new Calculator(500));
            BigInteger result = null;
            try{
                result = future.get();

                /*try{
                    result = future.get(10, TimeUnit.SECONDS);
                } catch (TimeoutException e) {
                    e.printStackTrace();
                } */

                System.out.println("Result = " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getCause());
            }
        } finally {
            service.shutdownNow();
        }
    }
}
