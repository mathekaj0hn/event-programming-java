
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Three Listener Techniques");
            frame.setSize(500, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

            JLabel label = new JLabel("Choose a button to test a listener.");
            label.setHorizontalAlignment(SwingConstants.CENTER);

            JButton anonymousButton = new JButton("Anonymous Inner Class");
            JButton lambdaButton = new JButton("Lambda Expression");

            // Technique 1: Anonymous Inner Class
            anonymousButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("Anonymous Inner Class was used!");
                }
            });

            // Technique 2: Lambda Expression
            lambdaButton.addActionListener(e ->
                label.setText("Lambda Expression was used!")
            );

            panel.add(label);
            panel.add(anonymousButton);
            panel.add(lambdaButton);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
