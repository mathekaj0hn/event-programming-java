
import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("GridLayout Demonstration");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 350);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(3, 3, 8, 8));

            for (int i = 1; i <= 9; i++) {
                panel.add(new JButton("Button " + i));
            }

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
