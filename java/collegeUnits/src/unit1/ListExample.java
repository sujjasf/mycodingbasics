package unit1;

import javax.swing.*;
import java.awt.event.*;  // Needed for ActionListener

public class ListExample {
    public static void main(String[] args) {
        // Create frame
        JFrame f = new JFrame("JList Example");
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        // Create data for list
        String countries[] = {"Nepal", "India", "China", "USA", "UK"};

        // Create JList
        JList<String> list = new JList<>(countries);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Add scrollbar
        JScrollPane scroll = new JScrollPane(list);
        scroll.setBounds(50, 50, 150, 100);

        // Create button
        JButton b = new JButton("Show Selected");
        b.setBounds(80, 170, 130, 30);

        // Create label
        JLabel l = new JLabel("Select a country");
        l.setBounds(50, 210, 200, 30);

        // Add ActionListener to button
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list.getSelectedIndex() != -1) {
                    String data = "Country Selected is: " + list.getSelectedValue();
                    l.setText(data);
                } else {
                    l.setText("No country selected!");
                }
            }
        });

        // Add all components to frame
        f.add(scroll);
        f.add(b);
        f.add(l);

        // Make visible
        f.setVisible(true);
    }
}
