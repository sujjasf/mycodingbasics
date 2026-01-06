
package unit3;


import javax.swing.*;
import java.awt.*;

public class main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Swing Example");
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter Name:");
        JTextField textField = new JTextField(15);
        JLabel label1 = new JLabel("Enter Password:");
        JTextField textField1 = new JTextField(15);
        JButton button = new JButton("Submit");

        button.addActionListener(e -> {
            String name = textField.getText();
            String password = textField1.getText();

            if (name.equals("sujjal") && password.equals("123")) {
                JOptionPane.showMessageDialog(
                    frame,
                    "Login SUccesful",
                    "Welcome",
                    JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                    frame,
                    "Login Unsuccesful ",
                    "Waring",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        });

        frame.add(label);
        frame.add(textField);
        frame.add(label1);
        frame.add(textField1);
        frame.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

