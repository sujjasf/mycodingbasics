package ComputerNetwork.unit2;

import java.net.URI;


public class UriConstructor {
    public static void main(String[] args) throws Exception {
        URI uri1 = new URI("https://www.tutorialsteacher.com/cshart/cshart-interface");
        System.out.println(uri1);
        URI uri2 = new URI("https", "www.tutorialsteacher.com", null);
        System.out.println(uri2.getPort());
        URI uri3 = new URI("https", "www.tutorialsteacher.com", "cshart/cshart-interface");
        System.out.println(uri3.getPath());
        URI uri4 = new URI("https", "www.tutorialsteacher.com", "cshart/cshart-interface");
        System.out.println(uri4.getScheme());
        

        URI uri5 = new URI("https", "www.tutorialsteacher.com", "cshart/cshart-interface", "type=object");
        System.out.println(uri5.getFragment());
        // URI uri3 = new URI("https", "www.tutorialsteacher.com", "cshart/cshart-interface");
        // System.out.println(uri3.getFile());

    }
}