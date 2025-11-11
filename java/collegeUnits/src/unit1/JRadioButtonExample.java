package unit1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JRadioButtonExample {
    public static void main(String[] args) {
        JFrame f = new JFrame("JRadioButton Example");
        f.setSize(400, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

        // Create label
        JLabel label = new JLabel("Select your gender:");

        // Create radio buttons
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        JRadioButton otherButton = new JRadioButton("Other");

        // Group them so only one can be selected
        ButtonGroup group = new ButtonGroup();
        group.add(maleButton);
        group.add(femaleButton);
        group.add(otherButton);

        // Create a button and result label
        JButton button = new JButton("Submit");
        JLabel resultLabel = new JLabel("");

        // Add action listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = "";
                if (maleButton.isSelected()) {
                    selected = "Male";
                } else if (femaleButton.isSelected()) {
                    selected = "Female";
                } else if (otherButton.isSelected()) {
                    selected = "Other";
                } else {
                    selected = "None selected";
                }

                resultLabel.setText("You selected: " + selected);
            }
        });

        // Add components to frame
        f.add(label);
        f.add(maleButton);
        f.add(femaleButton);
        f.add(otherButton);
        f.add(button);
        f.add(resultLabel);

        f.setVisible(true);
    }
}
