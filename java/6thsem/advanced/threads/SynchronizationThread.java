// // Without synchronization (possible wrong results):
// class Counter {
//     private int count = 0;
//     public void increment() { count++; }
//     public int getCount() { return count; }
// }

// With synchronization (correct results):
class SafeCounter {
    private int count = 0;
    public synchronized void increment() { count++; }
    public int getCount() { return count; }
}

public class SynchronizationThread {
    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        // Counter c = new Counter();
        SafeCounter c = new SafeCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + c.getCount());
    }
}
