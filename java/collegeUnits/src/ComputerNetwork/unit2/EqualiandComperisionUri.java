package ComputerNetwork.unit2;

import java.net.URI;

public class EqualiandComperisionUri {
    public static void main(String[] args) throws Exception {
        URI uri1 = new URI("https://www.google.com/search?q=javapoint&ie=UTF-8");
        URI uri2 = new URI("https://www.google.com/search?q=javapoint&ie=UTF-8");

        if(uri1.equals(uri2));
    }
}
