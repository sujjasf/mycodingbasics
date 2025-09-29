package filelogger;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

// Simulates downloading a file chunk
class DownloadTask implements Callable<byte[]> {
    private final int chunkId;
    private final int size; // chunk size in bytes

    DownloadTask(int chunkId, int size) {
        this.chunkId = chunkId;
        this.size = size;
    }

    @Override
    public byte[] call() throws Exception {
        // Simulate download time
        Thread.sleep(500 + (int)(Math.random() * 1000));
        
        // Generate dummy data (in real case, fetch from network)
        byte[] data = new byte[size];
        Arrays.fill(data, (byte) ('A' + chunkId));
        
        System.out.println("✅ Downloaded chunk " + chunkId);
        return data;
    }
}

public class FileDownloader {
    public static void main(String[] args) throws Exception {
        int totalChunks = 5;
        int chunkSize = 1024; // 1 KB each (for demo)
        
        ExecutorService pool = Executors.newFixedThreadPool(3);
        List<Future<byte[]>> results = new ArrayList<>();

        // Submit download tasks
        for (int i = 0; i < totalChunks; i++) {
            results.add(pool.submit(new DownloadTask(i, chunkSize)));
        }

        // Collect chunks
        try (FileOutputStream fos = new FileOutputStream("downloaded_file.txt")) {
            for (int i = 0; i < results.size(); i++) {
                byte[] chunk = results.get(i).get(); // wait for each chunk
                fos.write(chunk);
            }
        }

        pool.shutdown();
        System.out.println("🎉 File download complete → saved as downloaded_file.txt");
    }
}
