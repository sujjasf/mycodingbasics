package unit2;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

class MyComponent extends JComponent {
    private Image img;

    public MyComponent() {
        URL imgUrl = getClass().getResource("./backgound.jpg");
        img = (imgUrl != null) ? new ImageIcon(imgUrl).getImage() : new ImageIcon("q.jpg").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            // draw scaled to component size
            g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            g2d.dispose();
        } else {
            g.setColor(Color.RED);
            g.drawString("Image not found", 10, 20);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }
}

public class Paint extends JFrame {
    public Paint() {
        setTitle("Paint - Image Component");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MyComponent());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Paint());
    }
}