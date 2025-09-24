
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorServiceThread {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);

        service.execute(new PrintTask("Task-1", 200));
        service.execute(new PrintTask("Task-2", 400));

        service.shutdown();
    }
}


class PrintTask implements Runnable {
    private String name;
    private int delay;

    public PrintTask(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " Prints: " + i);
            try { Thread.sleep(delay); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
