
import javax.swing.*;
import java.awt.*;

public class CounterApp {

    private int count = 0;
    private JLabel countLabel;

    public CounterApp() {

        JFrame frame = new JFrame("Java Swing Counter");
        frame.setSize(450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        // Heading
        JLabel heading = new JLabel("COUNTER APPLICATION");
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 22));

        // Counter display
        countLabel = new JLabel("0");
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);
        countLabel.setFont(new Font("Arial", Font.BOLD, 50));

        // Buttons
        JButton incrementButton = new JButton("Increment (+)");
        JButton decrementButton = new JButton("Decrement (-)");
        JButton resetButton = new JButton("Reset");

        // Increment event
        incrementButton.addActionListener(e -> {
            count++;
            updateDisplay();
        });

        // Decrement event
        decrementButton.addActionListener(e -> {
            count--;
            updateDisplay();
        });

        // Reset event
        resetButton.addActionListener(e -> {
            count = 0;
            updateDisplay();
        });

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(incrementButton);
        buttonPanel.add(decrementButton);
        buttonPanel.add(resetButton);

        // Add components
        frame.add(heading, BorderLayout.NORTH);
        frame.add(countLabel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void updateDisplay() {
        countLabel.setText(String.valueOf(count));
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new CounterApp());
    }
}
