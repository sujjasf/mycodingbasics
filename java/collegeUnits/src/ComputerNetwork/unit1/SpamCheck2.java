package ComputerNetwork;

import java.net.InetAddress;

public class SpamCheck2 {

    public static String BlackHole = "sbl.spamhaus.org";

    public static void main(String[] args) throws Exception {
        // String testIP = "sbl.spamhaus.org"; // example IP not a spammer
        String testIP = "google.com"; // example IP not a spammer
        // String testIP = "8.8.8.8"; // example IP not a spammer
        // String testIP = "127.0.0.2"; // This IP is always listed as spammer
        
        if (IsSpammer(testIP)) {
            System.out.println(testIP + " is a SPAMMER.");
        } else {
            System.out.println(testIP + " is CLEAN.");
        }
    }

    private static boolean IsSpammer(String ip) {
        try {
            // Reverse the IP
            String[] parts = ip.split("\\.");
            String reversedIP = parts[3] + "." + parts[2] + "." + parts[1] + "." + parts[0];

            // DNSBL query host
            String query = reversedIP + "." + BlackHole;

            // DNS lookup attempt
            InetAddress.getByName(query);

            // If resolved successfully, IP is listed as spammer
            return true;

        } catch (Exception e) {
            // If DNS lookup fails (host not found), IP is clean
            return false;
        }
    }
}
