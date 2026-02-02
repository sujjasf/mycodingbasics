import java.net.*;

public class Main {
    public static void main(String[] args) throws Exception {

        InetAddress ia = InetAddress.getByName("8.8.8.8");
        //InetAddress ssk = InetAddress.getByName("www.social.sujjalkhadka.com.np");
        InetAddress sk = InetAddress.getByName("www.sujjalkhadka.com.np");
        
        //System.out.println("SSK " + ssk.getHostAddress());
        System.out.println("SSK " + sk.getHostAddress());
        //System.out.println("SSK " + ssk.getCanonicalHostName());
        System.out.println("SSK " + sk.getCanonicalHostName());
        

        System.out.println("Host Address: " + ia.getHostAddress());
        System.out.println("Canonical Name: " + ia.getCanonicalHostName());
    }
}
