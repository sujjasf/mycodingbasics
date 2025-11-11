package unit2;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.io.File;

public class MyImage extends JFrame {
    public MyImage() {
        setTitle("MyImage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Try loading image from classpath (place backgound.jpg in src/unit2)
        URL imgUrl = getClass().getResource("./obama.gif");
        ImageIcon icon = null;

        if (imgUrl != null) {
            icon = new ImageIcon(imgUrl);
            System.out.println("Loaded image from classpath: /unit2/backgound.jpg");
        } else {
            // fallback: look in working directory
            File f = new File("backgound.jpg");
            if (f.exists()) {
                icon = new ImageIcon(f.getAbsolutePath());
                System.out.println("Loaded image from working directory: " + f.getAbsolutePath());
            } else {
                System.out.println("Image not found. Checked classpath /unit2/backgound.jpg and working dir.");
            }
        }

        JLabel label = (icon != null) ? new JLabel(icon) : new JLabel("Image not found");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        add(label, BorderLayout.CENTER);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        if (icon != null) {
            System.out.println("Image displayed in window.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyImage());
    }
}