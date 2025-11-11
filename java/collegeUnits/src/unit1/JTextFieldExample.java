package unit1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextFieldExample {
    public static void main(String[] args) {
        JFrame f = new JFrame("JTextField Example");
        f.setSize(400, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

        // Create components
        JLabel label = new JLabel("Enter your name:");
        JTextField textField = new JTextField(15);  // 15 columns wide
        JButton button = new JButton("Greet");
        JLabel resultLabel = new JLabel("");

        // Add action listener to button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText(); // get text from field
                resultLabel.setText("Hello, " + name + "!");
            }
        });

        // Add components to frame
        f.add(label);
        f.add(textField);
        f.add(button);
        f.add(resultLabel);

        f.setVisible(true);
    }
}
