

public class UriConstructor {
    public static void main(String[] args) {
        URI uri1 =  new URI("https://www.tutorialsteacher.com/cshart/cshart-interface");
        System.out.println(uri1);
        URI uri2 =  new URI("https", "www.tutorialsteacher.com", null);
        System.out.println(uri2);
        URI uri3 =  new URI("https", "www.tutorialsteacher.com", "cshart/cshart-interface");
        System.out.println(uri3);

    }
}