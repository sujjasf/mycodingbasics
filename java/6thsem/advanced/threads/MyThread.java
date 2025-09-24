
import java.util.Random;

// Create two threads to print numbers 1–10 simultaneously
class PrintTask implements Runnable {
    private String name;
    private Random rand = new Random();

    public PrintTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) {
            System.out.println(name + " prints: " + i);
            try { Thread.sleep(rand.nextInt(300) + 100);} catch (InterruptedException e) {}
        }
    }

}


public class MyThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintTask("Thread-1"));
        Thread t2 = new Thread(new PrintTask("Thread-2"));

        t1.start();
        t2.start();
    }
}