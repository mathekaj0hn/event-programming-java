
import javax.swing.*;
import java.awt.*;

public class StudentPortal {

    private JFrame frame;
    private JTextField nameField;
    private JTextField registrationField;
    private JTextField emailField;
    private JLabel statusLabel;
    private JTextArea outputArea;

    public StudentPortal() {

        frame = new JFrame("University Student Portal");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 550);
        frame.setLocationRelativeTo(null);

        createInterface();

    }

    private void createInterface() {

        // Main layout
        frame.setLayout(new BorderLayout(10, 10));

        // Header
        JLabel heading = new JLabel(
                "UNIVERSITY STUDENT PORTAL",
                SwingConstants.CENTER
        );

        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        frame.add(heading, BorderLayout.NORTH);

        // Student registration form
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 15));

        formPanel.setBorder(
                BorderFactory.createTitledBorder("Student Registration")
        );

        nameField = new JTextField();
        registrationField = new JTextField();
        emailField = new JTextField();

        formPanel.add(new JLabel("Full Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Registration Number:"));
        formPanel.add(registrationField);

        formPanel.add(new JLabel("Email Address:"));
        formPanel.add(emailField);

        JButton registerButton = new JButton("Register Student");
        JButton clearButton = new JButton("Clear Form");

        formPanel.add(registerButton);
        formPanel.add(clearButton);

        // Dashboard buttons
        JPanel dashboardPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        dashboardPanel.setBorder(
                BorderFactory.createTitledBorder("Student Dashboard")
        );

        JButton viewButton = new JButton("View Students");
        JButton coursesButton = new JButton("View Courses");
        JButton resultsButton = new JButton("View Results");
        JButton exitButton = new JButton("Exit Portal");

        dashboardPanel.add(viewButton);
        dashboardPanel.add(coursesButton);
        dashboardPanel.add(resultsButton);
        dashboardPanel.add(exitButton);

        // Output area
        outputArea = new JTextArea(8, 30);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JScrollPane scrollPane = new JScrollPane(outputArea);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder("Portal Information")
        );

        // Centre container
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));

        centerPanel.add(formPanel, BorderLayout.NORTH);
        centerPanel.add(dashboardPanel, BorderLayout.CENTER);
        centerPanel.add(scrollPane, BorderLayout.SOUTH);

        frame.add(centerPanel, BorderLayout.CENTER);

        // Status bar
        statusLabel = new JLabel("Welcome! Ready to register students.");

        statusLabel.setBorder(
                BorderFactory.createEmptyBorder(8, 10, 8, 10)
        );

        frame.add(statusLabel, BorderLayout.SOUTH);

        // Event handling

        registerButton.addActionListener(event -> registerStudent());

        clearButton.addActionListener(event -> clearForm());

        viewButton.addActionListener(event -> {

            outputArea.setText(
                    "STUDENT INFORMATION\n"
                    + "---------------------------\n"
                    + "Student records will appear here."
            );

            statusLabel.setText("Viewing student records.");

        });

        coursesButton.addActionListener(event -> {

            outputArea.setText(
                    "AVAILABLE COURSES\n"
                    + "---------------------------\n"
                    + "1. Computer Science\n"
                    + "2. Information Technology\n"
                    + "3. Software Engineering\n"
                    + "4. Business Information Technology"
            );

            statusLabel.setText("Viewing available courses.");

        });

        resultsButton.addActionListener(event -> {

            outputArea.setText(
                    "ACADEMIC RESULTS\n"
                    + "---------------------------\n"
                    + "No examination results available yet."
            );

            statusLabel.setText("Viewing academic results.");

        });

        exitButton.addActionListener(event -> {

            int choice = JOptionPane.showConfirmDialog(
                    frame,
                    "Are you sure you want to exit?",
                    "Exit Portal",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                frame.dispose();
            }

        });

    }

    private void registerStudent() {

        String name = nameField.getText().trim();
        String registration = registrationField.getText().trim();
        String email = emailField.getText().trim();

        if (name.isEmpty() || registration.isEmpty() || email.isEmpty()) {

            JOptionPane.showMessageDialog(
                    frame,
                    "Please fill in all registration fields.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );

            statusLabel.setText("Registration failed: Missing information.");

            return;
        }

        outputArea.setText(
                "STUDENT REGISTERED SUCCESSFULLY\n"
                + "--------------------------------\n"
                + "Name: " + name + "\n"
                + "Registration Number: " + registration + "\n"
                + "Email: " + email
        );

        statusLabel.setText("Student registration completed successfully.");

        JOptionPane.showMessageDialog(
                frame,
                "Student registered successfully!",
                "Registration Successful",
                JOptionPane.INFORMATION_MESSAGE
        );

    }

    private void clearForm() {

        nameField.setText("");
        registrationField.setText("");
        emailField.setText("");

        outputArea.setText("");

        statusLabel.setText("Form cleared. Ready for another student.");

    }

    public void show() {

        frame.setVisible(true);

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            StudentPortal portal = new StudentPortal();

            portal.show();

        });

    }
}
