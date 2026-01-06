package ComputerNetwork.unit3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProxySelector;
import java.net.URL;
import java.net.URLConnection;

/**
 * Simple demo that sets LocalProxySelector as the default ProxySelector,
 * opens a URLConnection to tutorialspoint.com, sets timeouts and prints lines
 * read from the response using BufferedReader.
 *
 * Usage:
 *  - compile: javac -d bin src/ComputerNetwork/unit3/ProxyReadDemo.java
 *  - run:     java -cp bin ComputerNetwork.unit3.ProxyReadDemo
 *
 * Pass an alternate URL as the first argument if desired.
 */
public class ProxyReadDemo {
    public static void main(String[] args) {
        String proxyHost = "127.0.0.1"; // change if needed
        int proxyPort = 8080; // change if needed

        // Install your LocalProxySelector as the default for this JVM
        ProxySelector.setDefault(new LocalProxySelector(proxyHost, proxyPort));
        System.out.println("Default ProxySelector set to LocalProxySelector(" + proxyHost + ":" + proxyPort + ")");

        String urlStr = (args.length > 0) ? args[0] : "https://www.tutorialspoint.com/";

        try {
            URL url = new URL(urlStr);
            System.out.println("Opening URL: " + url);

            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(5000); // 5 seconds
            conn.setReadTimeout(5000);    // 5 seconds
            conn.setRequestProperty("User-Agent", "Java/ProxyReadDemo");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                String line;
                int printed = 0;
                // print up to 200 lines to avoid flooding terminal
                while ((line = br.readLine()) != null && printed++ < 200) {
                    System.out.println(line);
                }
                System.out.println("--- End of output (printed " + printed + " lines)");
            }

        } catch (IOException e) {
            System.err.println("I/O error when reading URL: " + e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}
