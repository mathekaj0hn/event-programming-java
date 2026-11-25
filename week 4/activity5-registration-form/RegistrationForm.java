
import javax.swing.*;
import java.awt.*;

public class RegistrationForm {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Student Registration Form");
            frame.setSize(600, 450);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout(10, 10));

            // Heading
            JLabel heading = new JLabel("STUDENT REGISTRATION");
            heading.setFont(new Font("Arial", Font.BOLD, 22));
            heading.setHorizontalAlignment(SwingConstants.CENTER);
            heading.setBorder(BorderFactory.createEmptyBorder(15, 10, 5, 10));

            // Input fields
            JTextField nameField = new JTextField();
            JTextField regNumberField = new JTextField();
            JTextField emailField = new JTextField();

            // Gender radio buttons
            JRadioButton maleButton = new JRadioButton("Male");
            JRadioButton femaleButton = new JRadioButton("Female");

            ButtonGroup genderGroup = new ButtonGroup();
            genderGroup.add(maleButton);
            genderGroup.add(femaleButton);

            JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            genderPanel.add(maleButton);
            genderPanel.add(femaleButton);

            // Course selection
            String[] courses = {
                "Select Course",
                "Business Information Technology",
                "Computer Science",
                "Information Technology",
                "Software Engineering",
                "Data Science"
            };

            JComboBox<String> courseComboBox =
                    new JComboBox<>(courses);

            // Terms checkbox
            JCheckBox termsCheckbox =
                    new JCheckBox("I accept the registration terms");

            // Form panel
            JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 12));
            formPanel.setBorder(
                    BorderFactory.createEmptyBorder(15, 25, 15, 25)
            );

            formPanel.add(new JLabel("Student Name:"));
            formPanel.add(nameField);

            formPanel.add(new JLabel("Registration Number:"));
            formPanel.add(regNumberField);

            formPanel.add(new JLabel("Email Address:"));
            formPanel.add(emailField);

            formPanel.add(new JLabel("Gender:"));
            formPanel.add(genderPanel);

            formPanel.add(new JLabel("Course:"));
            formPanel.add(courseComboBox);

            formPanel.add(new JLabel("Terms and Conditions:"));
            formPanel.add(termsCheckbox);

            // Buttons
            JButton registerButton = new JButton("Register Student");
            JButton clearButton = new JButton("Clear Form");

            JPanel buttonPanel = new JPanel(new FlowLayout());
            buttonPanel.add(registerButton);
            buttonPanel.add(clearButton);

            // Registration event
            registerButton.addActionListener(e -> {

                String name = nameField.getText().trim();
                String regNumber = regNumberField.getText().trim();
                String email = emailField.getText().trim();

                String gender = "";

                if (maleButton.isSelected()) {
                    gender = "Male";
                } else if (femaleButton.isSelected()) {
                    gender = "Female";
                }

                String course =
                        (String) courseComboBox.getSelectedItem();

                // Validate empty fields
                if (name.isEmpty()
                        || regNumber.isEmpty()
                        || email.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please fill in all text fields.",
                            "Missing Information",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                // Validate email
                if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please enter a valid email address.",
                            "Invalid Email",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                // Validate gender
                if (gender.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please select your gender.",
                            "Missing Information",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                // Validate course
                if (courseComboBox.getSelectedIndex() == 0) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please select a course.",
                            "Missing Information",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                // Validate terms
                if (!termsCheckbox.isSelected()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please accept the registration terms.",
                            "Terms Required",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                // Display registration details
                String message =
                        "REGISTRATION SUCCESSFUL!\n\n"
                        + "Name: " + name + "\n"
                        + "Registration Number: " + regNumber + "\n"
                        + "Email: " + email + "\n"
                        + "Gender: " + gender + "\n"
                        + "Course: " + course;

                JOptionPane.showMessageDialog(
                        frame,
                        message,
                        "Registration Confirmation",
                        JOptionPane.INFORMATION_MESSAGE
                );
            });

            // Clear form event
            clearButton.addActionListener(e -> {

                nameField.setText("");
                regNumberField.setText("");
                emailField.setText("");

                genderGroup.clearSelection();
                courseComboBox.setSelectedIndex(0);
                termsCheckbox.setSelected(false);
            });

            // Add components to window
            frame.add(heading, BorderLayout.NORTH);
            frame.add(formPanel, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
