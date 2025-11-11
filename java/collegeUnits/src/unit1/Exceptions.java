package unit1;

import javax.swing.JFrame;

public class Exceptions {

    public Exceptions() {
        JFrame f = new JFrame("EventHandline");
        f.setSize(300, 300);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton b = new JButton("Click Here!");
        b.setBounds(100, 100, 100, 20);
        f.add(b);
    }

    public static void main(String[] args) {
        new Exceptions();
    }
    
}
