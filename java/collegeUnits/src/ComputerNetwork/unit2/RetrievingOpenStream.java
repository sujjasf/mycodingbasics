package ComputerNetwork.unit2;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.URL;

public class RetrievingOpenStream {
    public static void main(String[] args) throws Exception{
        try {
            URL url = new URL("https://www.w3schools.com/");
            InputStream in = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            in.close();

            System.out.println("Done reading URL content.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
