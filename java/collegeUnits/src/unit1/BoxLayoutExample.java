package unit1;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BoxLayoutExample {
    public static void main(String[] args) {
        JFrame f = new JFrame("Example");
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));

        for (int i = 1; i <= 5; i++) {
            f.add(new JButton("Button " + i));
        }

        f.setAlwaysOnTop(true);
        f.setVisible(true);
    }
}


room no 48 ko :- ""
idno room48
pass 48