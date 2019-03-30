package Sample6;

/**
 * Created by Alex on 29.03.2019
 */
public class Transaction extends Thread {
    private Account account;
    private int amount;

    public Transaction(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(System.currentTimeMillis() % 500);
        } catch (InterruptedException e) {
            return;
        }

        account.withdraw(amount);
    }
}
