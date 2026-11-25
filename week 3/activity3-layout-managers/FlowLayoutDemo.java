
import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("FlowLayout Demonstration");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 300);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));

            panel.add(new JButton("Button 1"));
            panel.add(new JButton("Button 2"));
            panel.add(new JButton("Button 3"));
            panel.add(new JButton("Button 4"));
            panel.add(new JButton("Button 5"));

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
