package Sample4;

/**
 * Created by Alex on 29.03.2019
 */

class Testthread4 extends Thread {
    private volatile boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            System.out.println("Java is the best!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void myInterrupt() {stop = true;}
}

public class Sample4 {
    public static void main(String[] args) throws InterruptedException {

        Testthread4 thread = new Testthread4();
        thread.start();

        Thread.sleep(5000);
        thread.myInterrupt();
    }
}