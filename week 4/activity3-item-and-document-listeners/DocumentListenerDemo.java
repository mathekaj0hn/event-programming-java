
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class DocumentListenerDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("DocumentListener Demonstration");
            frame.setSize(450, 220);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new GridLayout(3, 1, 10, 10));

            JLabel instruction = new JLabel("Type something below:");
            JTextField textField = new JTextField();
            JLabel result = new JLabel("Characters: 0");

            textField.getDocument().addDocumentListener(
                new DocumentListener() {

                    private void updateCount() {
                        int count = textField.getText().length();
                        result.setText("Characters: " + count);
                    }

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        updateCount();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        updateCount();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        updateCount();
                    }
                }
            );

            frame.add(instruction);
            frame.add(textField);
            frame.add(result);

            frame.setVisible(true);
        });
    }
}
