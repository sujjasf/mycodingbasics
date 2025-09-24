
public class DaemonThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) { 
                System.out.println("Background thread still running....");
                try { Thread.sleep(1);} catch (InterruptedException e) {}
            }
        });

        t1.setDaemon(true);
        t1.start();

        System.out.println("Main thread Finished!!!");
    }
}
