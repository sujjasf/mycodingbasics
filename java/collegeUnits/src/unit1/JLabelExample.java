package unit1;

import javax.swing.*;

public class JLabelExample {
    public static void main(String[] args) {
        JFrame f = new JFrame("JLabel Example");
        JLabel l = new JLabel("Welcome to Java Swing!");
        l.setBounds(50, 50, 200, 30);
        f.add(l);
        f.setSize(400, 300);
        f.setLayout(null);
        f.setVisible(true);
    }
}
