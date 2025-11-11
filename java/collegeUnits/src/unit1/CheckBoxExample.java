package unit1;

import javax.swing.*;
import java.awt.event.*;

public class CheckBoxExample {
    public static void main(String[] args) {
        // Create frame
        JFrame f = new JFrame("JCheckBox Example");
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        // Create checkboxes
        JCheckBox cb1 = new JCheckBox("Music");
        cb1.setBounds(50, 50, 100, 30);

        JCheckBox cb2 = new JCheckBox("Dance");
        cb2.setBounds(50, 80, 100, 30);

        JCheckBox cb3 = new JCheckBox("Sports");
        cb3.setBounds(50, 110, 100, 30);

        // Create button
        JButton b = new JButton("Show Selected");
        b.setBounds(70, 160, 130, 30);

        // Create label
        JLabel l = new JLabel("Select your hobbies");
        l.setBounds(50, 200, 200, 30);

        // Add ActionListener for button click
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = "Selected: ";
                boolean anySelected = false;

                if (cb1.isSelected()) {
                    data += cb1.getText() + " ";
                    anySelected = true;
                }
                if (cb2.isSelected()) {
                    data += cb2.getText() + " ";
                    anySelected = true;
                }
                if (cb3.isSelected()) {
                    data += cb3.getText() + " ";
                    anySelected = true;
                }

                if (!anySelected) {
                    l.setText("No hobbies selected!");
                } else {
                    l.setText(data);
                }
            }
        });

        // Add components to frame
        f.add(cb1);
        f.add(cb2);
        f.add(cb3);
        f.add(b);
        f.add(l);

        // Make frame visible
        f.setVisible(true);
    }
}
