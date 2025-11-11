package unit1;

import javax.swing.*;

public class JTextAreaExample {
    public static void main(String[] args) {
        JFrame f = new JFrame("JTextArea Example");
        JTextArea ta = new JTextArea("Type here...");
        JScrollPane scroll = new JScrollPane(ta);
        scroll.setBounds(50, 50, 200, 100);
        f.add(scroll);
        f.setSize(300, 250);
        f.setLayout(null);
        f.setVisible(true);
    }
}
