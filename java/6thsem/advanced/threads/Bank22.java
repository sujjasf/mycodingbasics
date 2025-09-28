import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Banking {
    private int balance = 10000;
    private final ReentrantLock lock = new ReentrantLock();

    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount);
            System.out.println("Current Balance: " + balance);
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrew " + amount);
                System.out.println("Current Balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " Tried to withdraw but Insufficient funds");
                System.out.println("Current Balance: " + balance);
            }
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }
}


public class Bank22 {
    public static void main(String[] args) {
        Banking transaction = new Banking();

        ExecutorService service = Executors.newFixedThreadPool(3);
        
        service.execute(() -> {
            Thread.currentThread().setName("User1");
            transaction.deposit(1000);
            transaction.withdraw(300);
        });
        
        service.execute(() -> {
            Thread.currentThread().setName("User2");
            transaction.deposit(500);
            transaction.withdraw(700);    
        });

        service.execute(() -> {
            Thread.currentThread().setName("User3");
            transaction.deposit(1200);
            transaction.withdraw(1200);
        });
        
        service.shutdown();
    }
    
}
