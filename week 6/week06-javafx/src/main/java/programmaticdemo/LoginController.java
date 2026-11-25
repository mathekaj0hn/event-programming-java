
package programmaticdemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label messageLabel;

    @FXML
    private void handleLogin() {

        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Please fill in all fields.");
            System.out.println("Empty fields detected.");

        } else if (username.equals("admin")
                && password.equals("password123")) {

            messageLabel.setText("Login successful!");
            System.out.println("Login successful!");

        } else {

            messageLabel.setText("Invalid username or password.");
            System.out.println("Login failed!");
        }
    }
}

