
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemListenerDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("ItemListener Demonstration");
            frame.setSize(450, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new FlowLayout());

            JCheckBox programming = new JCheckBox("Programming");
            JCheckBox networking = new JCheckBox("Networking");
            JCheckBox databases = new JCheckBox("Databases");

            JLabel result = new JLabel("Select your favourite subjects.");

            ItemListener listener = new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {

                    JCheckBox selectedBox = (JCheckBox) e.getSource();

                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        result.setText(selectedBox.getText() + " selected!");
                    } else {
                        result.setText(selectedBox.getText() + " deselected!");
                    }
                }
            };

            programming.addItemListener(listener);
            networking.addItemListener(listener);
            databases.addItemListener(listener);

            frame.add(new JLabel("Choose your subjects:"));
            frame.add(programming);
            frame.add(networking);
            frame.add(databases);
            frame.add(result);

            frame.setVisible(true);
        });
    }
}
