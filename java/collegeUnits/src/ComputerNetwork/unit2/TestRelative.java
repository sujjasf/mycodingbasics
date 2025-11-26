package ComputerNetwork.unit2;

import java.net.MalformedURLException;
import java.net.URL;

public class TestRelative {
    public static void main(String[] args) throws MalformedURLException {
        URL myurl = new URL("https://www.w3schools.com/");
        URL asppage1 = new URL(myurl, "css/default.asp");
        URL asppage2 = new URL(myurl, "js/defualt.asp");
        System.out.println(asppage1);
        System.out.println(asppage2);
    }
}