
import javax.swing.*;
import java.awt.*;

public class ComponentShowcase {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Swing Component Showcase");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(550, 500);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(0, 2, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // JLabel
            JLabel nameLabel = new JLabel("Enter your name:");

            // JTextField
            JTextField nameField = new JTextField();

            // JButton
            JButton greetButton = new JButton("Greet");

            // JLabel for displaying output
            JLabel resultLabel = new JLabel("Your greeting will appear here.");

            // JCheckBox
            JCheckBox studentCheckBox = new JCheckBox("I am a student");

            // JRadioButtons
            JRadioButton maleButton = new JRadioButton("Male");
            JRadioButton femaleButton = new JRadioButton("Female");

            ButtonGroup genderGroup = new ButtonGroup();
            genderGroup.add(maleButton);
            genderGroup.add(femaleButton);

            JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            genderPanel.add(maleButton);
            genderPanel.add(femaleButton);

            // JComboBox
            String[] courses = {
                "Computer Science",
                "Information Technology",
                "Software Engineering",
                "Business Information Technology"
            };

            JComboBox<String> courseBox = new JComboBox<>(courses);

            // Button event
            greetButton.addActionListener(event -> {

                String name = nameField.getText().trim();

                if (name.isEmpty()) {
                    resultLabel.setText("Please enter your name.");
                    return;
                }

                String greeting = "Hello, " + name + "!";

                if (studentCheckBox.isSelected()) {
                    greeting += " Welcome, student.";
                }

                resultLabel.setText(greeting);
            });

            // Add components to panel
            panel.add(nameLabel);
            panel.add(nameField);

            panel.add(new JLabel("Gender:"));
            panel.add(genderPanel);

            panel.add(new JLabel("Select your course:"));
            panel.add(courseBox);

            panel.add(studentCheckBox);
            panel.add(greetButton);

            panel.add(new JLabel("Result:"));
            panel.add(resultLabel);

            frame.add(panel);
            frame.setVisible(true);

        });
    }
}
