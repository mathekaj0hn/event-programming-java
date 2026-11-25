
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventSourceDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Separate Listener Class");
            frame.setSize(450, 250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JLabel label = new JLabel("Click the button.");
            label.setHorizontalAlignment(SwingConstants.CENTER);

            JButton button = new JButton("Test Separate Listener");

            // Technique 3: Separate Listener Class
            button.addActionListener(new MyButtonListener(label));

            frame.setLayout(new BorderLayout());
            frame.add(label, BorderLayout.CENTER);
            frame.add(button, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}

// Separate class responsible for handling button events
class MyButtonListener implements ActionListener {

    private JLabel label;

    public MyButtonListener(JLabel label) {
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        label.setText("Separate Listener Class was used!");
    }
}

