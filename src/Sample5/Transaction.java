package Sample5;

/**
 * Created by Alex on 29.03.2019
 */
public class Transaction extends Thread {
    private Account account;
    private int withdraw;

    public Transaction(Account account, int withdraw) {
        this.account = account;
        this.withdraw = withdraw;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(System.currentTimeMillis() % 500);
        } catch (InterruptedException e) {
            return;
        }

        synchronized (account) {    //comment this
            int total = account.getMoney();
            if(total >= withdraw) {
                account.setMoney(total - withdraw);
            }
        } // comment this
    }
}
