
import javax.swing.*;
import java.awt.*;

public class FreezeDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("EDT Freeze Demonstration");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(450, 250);
            frame.setLocationRelativeTo(null);

            JButton button = new JButton("Start Long Operation");

            JLabel statusLabel = new JLabel("Ready", SwingConstants.CENTER);

            button.addActionListener(event -> {

                statusLabel.setText("Processing...");

                // Deliberately block the Event Dispatch Thread
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                statusLabel.setText("Operation completed!");
            });

            frame.setLayout(new BorderLayout(10, 10));

            frame.add(button, BorderLayout.CENTER);
            frame.add(statusLabel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
