package unit1;

import javax.swing.*;

public class DesktopPaneExample {
    public static void main(String[] args) {
        // Create main frame
        JFrame f = new JFrame("JDesktopPane Example");
        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a desktop pane
        JDesktopPane desktop = new JDesktopPane();

        // Create internal frames
        JInternalFrame frame1 = new JInternalFrame("Window 1", true, true, true, true);
        JInternalFrame frame2 = new JInternalFrame("Window 2", true, true, true, true);

        // Set sizes and positions
        frame1.setBounds(50, 50, 200, 150);
        frame2.setBounds(300, 100, 200, 150);

        // Add some content to internal frames
        frame1.add(new JLabel("This is internal frame 1"));
        frame2.add(new JLabel("This is internal frame 2"));

        // Make internal frames visible
        frame1.setVisible(true);
        frame2.setVisible(true);

        // Add internal frames to desktop pane
        desktop.add(frame1);
        desktop.add(frame2);

        // Add desktop pane to main frame
        f.add(desktop);

        // Make main frame visible
        f.setVisible(true);
    }
}
