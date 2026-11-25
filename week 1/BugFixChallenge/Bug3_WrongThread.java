
import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class Bug3_WrongThread extends JFrame {

    private JLabel timeLabel;
    private JButton startButton;
    private volatile boolean running = false;

    public Bug3_WrongThread() {

        setTitle("Bug 3 - Wrong Thread");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        timeLabel = new JLabel("Time: ");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 16));

        startButton = new JButton("Start Clock");

        startButton.addActionListener(e -> {

            if (running) {
                return;
            }

            running = true;
            startButton.setEnabled(false);

            Thread clockThread = new Thread(() -> {

                while (running) {

                    String currentTime =
                            "Time: " + new Date();

                    SwingUtilities.invokeLater(() -> {
                        timeLabel.setText(currentTime);
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }

            });

            clockThread.setDaemon(true);
            clockThread.start();

        });

        add(timeLabel);
        add(startButton);

        setSize(350, 150);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Bug3_WrongThread().setVisible(true);
        });

    }
}
