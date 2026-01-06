
package unit3;

// Import Swing classes (JFrame, JLabel, JButton, JTextField, JOptionPane)
import javax.swing.*;

// Import layout classes like FlowLayout
import java.awt.*;

// Import event handling classes
import java.awt.event.*;

public class SwingExample {

    // Main method: program starts from here
    public static void main(String[] args) {

        // Create the main window (JFrame) with a title
        JFrame frame = new JFrame("Swing Example");

        // Set the width and height of the window
        frame.setSize(400, 200);

        // Set layout to arrange components left to right
        frame.setLayout(new FlowLayout());

        // Create a label to show text on the window
        JLabel label = new JLabel("Enter Name:");

        // Create a text field to take input from the user
        JTextField textField = new JTextField(15);

        // Create a button that the user can click
        JButton button = new JButton("Submit");

        // Add event handling to the button
        // This code runs when the button is clicked
        button.addActionListener(e -> {

            // Get the text entered by the user
            String name = textField.getText();

            // Check if the text field is empty
            if (name.isEmpty()) {

                // Show warning dialog if no name is entered
                JOptionPane.showMessageDialog(
                    frame,                  // parent window
                    "Enter your name",      // message
                    "Warning",              // dialog title
                    JOptionPane.WARNING_MESSAGE // warning icon
                );

            } else {

                // Show information dialog if name is entered
                JOptionPane.showMessageDialog(
                    frame,                      // parent window
                    "Hello " + name,            // message
                    "Welcome",                  // dialog title
                    JOptionPane.INFORMATION_MESSAGE // info icon
                );
            }
        });

        // Add label to the window
        frame.add(label);

        // Add text field to the window
        frame.add(textField);

        // Add button to the window
        frame.add(button);

        // Close the program when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window visible on screen
        frame.setVisible(true);
    }
}
