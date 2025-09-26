class Banking {
    private int balance = 10000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited " + amount);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount);
        } else {
            System.out.println(Thread.currentThread().getName() + " Tried to withdraw but Insufficient funds");
        }
    }
}


public class Bank22 {
    public static void main(String[] args) {
        Banking transaction = new Banking();

        Thread t1 = new Thread(() -> {
            transaction.deposit(1000);
            transaction.withdraw(300);
        }, "User1");

        
        Thread t2 = new Thread(() -> {
            transaction.deposit(500);
            transaction.withdraw(700);
        }, "User2");
        
        Thread t3 = new Thread(() -> {
            transaction.deposit(1200);
            transaction.withdraw(1200);
        }, "User3");

        t1.start();
        t2.start();
        t3.start();
    }
    
}
