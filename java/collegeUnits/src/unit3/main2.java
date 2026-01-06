package unit3;

import javax.swing.*;
import java.awt.*;

public class main2 {
    
    public static void main(String[] args) {

        JFrame frame = new JFrame("Swing Example");
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter Name:");
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            String name = textField.getText();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(
                    frame,
                    "Enter your name",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
                );
            } else {
                // JOptionPane.showMessageDialog(
                //     frame,
                //     "Hello " + name,
                //     "Welcome",
                //     JOptionPane.INFORMATION_MESSAGE
                // );
                if(name.equals("sujjal")){
                    JOptionPane.showMessageDialog(
                        frame, 
                        "Login Succesful, Welcome " + name,
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
