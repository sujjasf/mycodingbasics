
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Sender implements Runnable {
    private String name;
    private BlockingQueue<String> messages;

    public Sender(String name, BlockingQueue<String> messages) {
        this.name = name;
        this.messages = messages;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 3; i++) {
                String msg = name + " says: Hello " + i;
                messages.put(msg); // send message
                Thread.sleep(500); // simulate typing delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}

class Receiver implements Runnable {
    private BlockingQueue<String> messages;

    public Receiver(BlockingQueue<String> messages) {
        this.messages = messages;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String msg = messages.take(); // wait for message
                if (msg.equals("EXIT"))
                    break; // shutdown signal
                System.out.println("Broadcast -> " + msg);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ChatRoom {
    public static void main(String[] args) {
        BlockingQueue<String> chatQueue = new ArrayBlockingQueue<>(50);

        // Start Chat Room Broadcaster
        Thread Receiver = new Thread(new Receiver(chatQueue));
        Receiver.start();

        // Start multiple users
        Thread user1 = new Thread(new Sender("Alice", chatQueue));
        Thread user2 = new Thread(new Sender("Bob", chatQueue));
        Thread user3 = new Thread(new Sender("Charlie", chatQueue));

        user1.start();
        user2.start();
        user3.start();

        // Wait for users to finish
        try {
            user1.join();
            user2.join();
            user3.join();

            // Send shutdown signal
            chatQueue.put("EXIT");
            Receiver.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Chat room closed.");
    }
}
