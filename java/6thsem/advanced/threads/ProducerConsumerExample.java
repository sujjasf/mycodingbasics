// Producer–Consumer Problem (with BlockingQueue)
// Producer generates items, Consumer takes them.
// Great for learning coordination between threads.
import java.util.concurrent.*;

// class Producer implements Runnable {
//     private final BlockingQueue<String> queue;
//     Producer(BlockingQueue<String> q) { this.queue = q; }

//     @Override
//     public void run() {
//         try {
//             for (int i = 1; i <= 5; i++) {
//                 String item = "Item-" + i;
//                 queue.put(item);  // adds to queue (waits if full)
//                 System.out.println("Produced: " + item);
//                 Thread.sleep(500);
//             }
//         } catch (InterruptedException e) {}
//     }
// }

// class Consumer implements Runnable {
//     private final BlockingQueue<String> queue;
//     Consumer(BlockingQueue<String> q) { this.queue = q; }

//     @Override
//     public void run() {
//         try {
//             while (true) {
//                 String item = queue.take(); // takes from queue (waits if empty)
//                 System.out.println(Thread.currentThread().getName() + " consumed: " + item);
//                 Thread.sleep(800);
//             }
//         } catch (InterruptedException e) {}
//     }
// }
class Producer implements Runnable {
    private final BlockingQueue<String> queue;
    Producer(BlockingQueue<String> q) { this.queue = q; }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                String item = "Item-" + i;
                queue.put(item);
                System.out.println("Produced: " + item);
                Thread.sleep(500);
            }
            // Send "poison pill" to stop consumers
            queue.put("END");
            queue.put("END");
        } catch (InterruptedException e) {}
    }
}

class Consumer implements Runnable {
    private final BlockingQueue<String> queue;
    Consumer(BlockingQueue<String> q) { this.queue = q; }

    @Override
    public void run() {
        try {
            while (true) {
                String item = queue.take();
                if (item.equals("END")) {
                    System.out.println(Thread.currentThread().getName() + " stopping.");
                    break; // exit loop
                }
                System.out.println(Thread.currentThread().getName() + " consumed: " + item);
                Thread.sleep(800);
            }
        } catch (InterruptedException e) {}
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        Thread producer = new Thread(new Producer(queue));
        Thread consumer1 = new Thread(new Consumer(queue), "Consumer1");
        Thread consumer2 = new Thread(new Consumer(queue), "Consumer2");

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
