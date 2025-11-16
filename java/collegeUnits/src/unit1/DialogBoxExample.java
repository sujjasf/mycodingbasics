package unit1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DialogBoxExample {
    public static void main(String[] args) {
        JFrame f = new JFrame("Example");
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        JButton b1 = new JButton("Click ");
        b1.setBounds(100, 100, 80, 25);
        f.add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog();
                d.setBounds(50, 50, 150, 150);
                JLabel l = new JLabel("This is you dialog box!");

                l.setBounds(10, 10, 120, 120);
                d.add(l);
                d.setVisible(true);
            }
        });
        f.setVisible(true);
    }
}