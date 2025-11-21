package mvc1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private User user;
    private View view;

    public Controller(User user, View view) {
        this.user = user;
        this.view = view;
        this.view.getLoginButton().addActionListener(new LoginButtonListener());
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsername();
            String password = view.getPassword();

            // Update user model with input values
            user = new User(username, password);

            // Validate login
            if (user.validate()) {
                view.setMessage("Login Successful!");
            } else {
                view.setMessage("Invalid username or password!");
            }
        }
    }
}
