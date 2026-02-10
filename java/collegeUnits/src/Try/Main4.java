package Try;

import java.net.InetAddress;

public class Main1 {
    public static void main(String[] args) throws Exception {
        InetAddress ibiblio = InetAddress.getByName("www.sujjalkhadka.com.np");
        InetAddress helios = InetAddress.getByName("socials.sujjalkhadka.com.np");
        if (ibiblio.equals(helios)) {
            System.out.println("WWW.ibiblio.org is the same as "+ ibiblio + " and " + helios);
        } else {
            System.out.println("www.ibliblio.org is not as same as "+ ibiblio + " and " + helios);
        } 
    }
}
