
public class PriorityThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) System.out.println("Low priority Thread: " + i);
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) System.out.println("High priority Thread: " + i);
        });

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}
