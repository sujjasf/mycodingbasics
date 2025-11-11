package unit1;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableExample {
    public static void main(String[] args) {
        JFrame f = new JFrame("Example");
        f.setSize(300, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String data[][] = {{"1", "Sujjal", "Nepal-1"}, {"2", "Sujal", "Nepal-2"}, {"3", "Sushant", "Nepal-3"}};
        String title[] = { "s.n.", "Name", "Address"};
        JTable t = new JTable(data, title); 
        // t.setBounds(30, 40, 200, 300)
        JScrollPane s = new JScrollPane(t);
        f.add(s);
        f.setVisible(true);
    }
}
