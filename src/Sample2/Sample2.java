package Sample2;

/**
 * Created by Alex on 29.03.2019
 */

class TestThread2 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("Hi, I'm " + this.getClass().getName());
    }
}

public class Sample2 {
    public static void main(String[] args) {

        TestThread2 thread = new TestThread2();
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Interrupted");
        }

        System.out.println("Finish");
    }
}