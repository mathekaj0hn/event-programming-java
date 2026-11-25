
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FirstWindow {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("My First Swing Window");

            frame.setSize(500, 350);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setLocationRelativeTo(null);

            frame.setVisible(true);

        });
    }
}
