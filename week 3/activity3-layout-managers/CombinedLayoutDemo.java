
import javax.swing.*;
import java.awt.*;

public class CombinedLayoutDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Combined Layout Demonstration");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(650, 450);
            frame.setLocationRelativeTo(null);

            frame.setLayout(new BorderLayout(10, 10));

            // Top section using FlowLayout
            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

            topPanel.add(new JLabel("Student Management System"));
            topPanel.add(new JButton("Home"));
            topPanel.add(new JButton("Settings"));

            // Centre section using GridLayout
            JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));

            centerPanel.add(new JButton("Register Student"));
            centerPanel.add(new JButton("View Students"));
            centerPanel.add(new JButton("Update Student"));
            centerPanel.add(new JButton("Delete Student"));

            // Bottom section
            JPanel bottomPanel = new JPanel(new FlowLayout());

            bottomPanel.add(
                new JLabel("University Management Dashboard")
            );

            // Add sections to the main window
            frame.add(topPanel, BorderLayout.NORTH);
            frame.add(centerPanel, BorderLayout.CENTER);
            frame.add(bottomPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
