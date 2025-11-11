package unit1;

import javax.swing.*;
import java.awt.event.*;

public class ComboBoxExample {
    public static void main(String[] args) {
        // Create frame
        JFrame f = new JFrame("JComboBox Example");
        f.setSize(300, 250);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        // Create data for combo box
        String countries[] = {"Nepal", "India", "China", "USA", "UK"};

        // Create combo box
        JComboBox<String> cb = new JComboBox<>(countries);
        cb.setBounds(80, 50, 120, 25);

        // Create button
        JButton b = new JButton("Show Selected");
        b.setBounds(80, 90, 130, 30);

        // Create label
        JLabel l = new JLabel("Select a country");
        l.setBounds(70, 140, 200, 30);

        // Add ActionListener to button
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) cb.getSelectedItem(); // get selected value
                l.setText("Country Selected: " + selected);
            }
        });

        // Add components to frame
        f.add(cb);
        f.add(b);
        f.add(l);

        // Make visible
        f.setVisible(true);
    }
}
