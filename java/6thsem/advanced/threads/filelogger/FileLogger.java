package filelogger;

import java.io.*;
import java.util.concurrent.*;

// Logger worker: runs in its own thread
class LoggerWorker implements Runnable {
    private final BlockingQueue<String> logQueue;
    private final File logFile;

    public LoggerWorker(BlockingQueue<String> logQueue, String fileName) {
        this.logQueue = logQueue;
        this.logFile = new File(fileName);
    }

    @Override
    public void run() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            while (true) {
                String message = logQueue.take(); // wait for log message
                if (message.equals("STOP")) break; // graceful shutdown
                writer.write(message);
                writer.newLine();
                writer.flush(); // ensure message is written
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class FileLogger {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> logQueue = new LinkedBlockingQueue<>();
        Thread loggerThread = new Thread(new LoggerWorker(logQueue, "app.log"));
        loggerThread.start();

        // Simulate multiple users logging
        ExecutorService users = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 3; i++) {
            int userId = i;
            users.submit(() -> {
                for (int j = 1; j <= 5; j++) {
                    String msg = "User" + userId + " performed action " + j;
                    try {
                        logQueue.put(msg);
                    } catch (InterruptedException e) {}
                }
            });
        }

        users.shutdown();
        users.awaitTermination(5, TimeUnit.SECONDS);

        // Stop logger
        logQueue.put("STOP");
        loggerThread.join();

        System.out.println("✅ Logging complete. Check app.log file!");
    }
}
