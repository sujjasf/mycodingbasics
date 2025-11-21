package mvc1;

import java.awt.GridLayout;
import javax.swing.*;

public class View extends JFrame {
    private JTextField tUser = new JTextField(20);
    private JPasswordField tPass = new JPasswordField(20);
    private JButton bLogin = new JButton("Login");
    private JLabel lMessage = new JLabel();

    public View() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel p = new JPanel(new GridLayout(5, 1));

        p.add(new JLabel("Username"));
        p.add(tUser);

        p.add(new JLabel("Password"));
        p.add(tPass);

        p.add(bLogin);
        p.add(lMessage);

        add(p);
        setLocationRelativeTo(null);
    }

    public String getUsername() {
        return tUser.getText();
    }

    public String getPassword() {
        return new String(tPass.getPassword());
    }

    public JButton getLoginButton() {
        return bLogin;
    }

    public void setMessage(String msg) {
        lMessage.setText(msg);
    }
}
