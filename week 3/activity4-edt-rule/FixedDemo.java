
import javax.swing.*;
import java.awt.*;

public class FixedDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Fixed EDT Demonstration");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450, 250);
            frame.setLocationRelativeTo(null);

            JButton button = new JButton("Start Background Operation");

            JLabel statusLabel = new JLabel("Ready", SwingConstants.CENTER);

            button.addActionListener(event -> {

                button.setEnabled(false);
                statusLabel.setText("Processing in background...");

                // Create a background thread
                Thread worker = new Thread(() -> {

                    try {
                        Thread.sleep(5000);

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    // Update Swing components safely on the EDT
                    SwingUtilities.invokeLater(() -> {

                        statusLabel.setText("Operation completed!");

                        button.setEnabled(true);
                    });
                });

                worker.start();
            });

            frame.setLayout(new BorderLayout(10, 10));

            frame.add(button, BorderLayout.CENTER);
            frame.add(statusLabel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
