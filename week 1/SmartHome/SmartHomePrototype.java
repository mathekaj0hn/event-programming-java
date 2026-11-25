
import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class SmartHomePrototype extends JFrame {

    private JLabel statusLabel;
    private JTextArea eventLog;

    private JToggleButton lightsToggle;
    private JToggleButton securityToggle;

    private JButton doorButton;

    public SmartHomePrototype() {

        // Window setup
        setTitle("Smart Home Controller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Status Panel
        statusLabel = new JLabel("System Ready");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));

        statusLabel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(statusLabel, BorderLayout.NORTH);

        // Event Log
        eventLog = new JTextArea(10, 30);
        eventLog.setEditable(false);
        eventLog.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(eventLog);

        add(scrollPane, BorderLayout.CENTER);

        // Control Panel
        JPanel controlPanel =
                new JPanel(new GridLayout(3, 1, 5, 5));

        controlPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Lights Toggle Button
        lightsToggle = new JToggleButton("Lights: OFF");

        lightsToggle.addActionListener(e -> {

            if (lightsToggle.isSelected()) {

                lightsToggle.setText("Lights: ON");

                logEvent("Lights turned ON");

                statusLabel.setText("Lights are ON");

            } else {

                lightsToggle.setText("Lights: OFF");

                logEvent("Lights turned OFF");

                statusLabel.setText("Lights are OFF");

            }

        });

        // Security Toggle Button
        securityToggle = new JToggleButton("Security: OFF");

        securityToggle.addActionListener(e -> {

            if (securityToggle.isSelected()) {

                securityToggle.setText("Security: ARMED");

                logEvent("Security system ARMED");

                statusLabel.setText("Security armed");

            } else {

                securityToggle.setText("Security: OFF");

                logEvent("Security system DISARMED");

                statusLabel.setText("Security disarmed");

                getContentPane().setBackground(Color.WHITE);

            }

        });

        // Door Sensor Button
        doorButton = new JButton("Simulate Door Open");

        doorButton.addActionListener(e -> {

            logEvent("Door sensor triggered");

            if (securityToggle.isSelected()) {

                logEvent("ALARM! Intruder detected!");

                statusLabel.setText("ALARM ACTIVE!");

                getContentPane().setBackground(Color.RED);

                JOptionPane.showMessageDialog(
                        this,
                        "WARNING! Intruder detected!",
                        "SECURITY ALERT",
                        JOptionPane.WARNING_MESSAGE
                );

            } else {

                logEvent("Door opened (no alarm)");

                statusLabel.setText("Door opened");

            }

        });

        // Add buttons to panel
        controlPanel.add(lightsToggle);
        controlPanel.add(securityToggle);
        controlPanel.add(doorButton);

        add(controlPanel, BorderLayout.SOUTH);

        // Window settings
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    // Method to record events
    private void logEvent(String event) {

        String timestamp = new Date().toString();

        eventLog.append(
                "[" + timestamp + "] " + event + "\n"
        );

        eventLog.setCaretPosition(
                eventLog.getDocument().getLength()
        );

    }

    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new SmartHomePrototype().setVisible(true);

        });

    }
}

