package ComputerNetwork.unit2;

import java.net.URL;

public class urlmethod {
    public static void main(String[] args) throws Exception {
        // URL url = new URL("https", "www.w3schools.com/", 443,"css/default.asp");
        URL url = new URL("https", "www.w3schools.com", 443, "css/default.asp");
        // System.out.println(url.getAuthority());
        // System.out.println(url.getContent());
        // System.out.println(url.getFile());
        // System.out.println(url.getHost());
        System.out.println("Authority " + url.getAuthority());
        System.out.println("Host " + url.getHost());
        System.out.println("Port " + url.getPort());
        System.out.println("Protocol " + url.getProtocol());
        System.out.println("File " + url.getFile());
        System.out.println("Path " + url.getPath());
        System.out.println("Query " + url.getQuery());
    }
}
