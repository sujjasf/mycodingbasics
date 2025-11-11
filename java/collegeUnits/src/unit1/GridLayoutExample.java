package unit1;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutExample {
    public static void main(String[] args) {
        JFrame f = new JFrame("Example");
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout());

        for(int i = 1; i <= 5; i++) {
            f.add(new JButton("Button " + i));
        }

        f.setAlwaysOnTop(true);
        f.setVisible(true);
    }
}
