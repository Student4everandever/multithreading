package Sample6;

/**
 * Created by Alex on 29.03.2019
 */
public class Account {
    private int money;

    public Account(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public synchronized void withdraw(int amount) {
        if(money >= amount) {
            money -= amount;
        }
    }
}
