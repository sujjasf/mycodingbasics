// Bank account simulation (deposit & withdraw safely)

class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", new balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", new balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + ", but insufficient funds. Current balance: " + balance);
        }
    }
}

public class Bank21 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            account.deposit(500);
            account.withdraw(700);
        }, "User1");

        Thread t2 = new Thread(() -> {
            account.deposit(500);
            account.withdraw(700);
        }, "User2");

        t1.start();
        t2.start();
    }
}
