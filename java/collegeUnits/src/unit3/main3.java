package unit3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main3 {


    public static void main(String[] args) {

        JFrame frame = new JFrame("Login Form");
        frame.setSize(350, 200);
        frame.setLayout(new FlowLayout());

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);

        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (username.equals("admin") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Login Successful",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Username or Password",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        frame.add(userLabel);
        frame.add(userField);
        frame.add(passLabel);
        frame.add(passField);
        frame.add(loginButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
