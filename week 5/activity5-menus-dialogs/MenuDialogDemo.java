
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuDialogDemo {

    private static JFrame frame;
    private static JTextArea textArea;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            frame = new JFrame("Student Management - Menus and Dialogs");
            frame.setSize(700, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout());

            // Text area
            textArea = new JTextArea();
            textArea.setFont(new Font("Arial", Font.PLAIN, 15));
            textArea.setText("Welcome to the Student Management System!\n\n"
                    + "Use the menus above to perform actions.\n"
                    + "You can also right-click inside this area.");

            textArea.setMargin(new Insets(10, 10, 10, 10));

            JScrollPane scrollPane = new JScrollPane(textArea);

            // Create menu bar
            JMenuBar menuBar = new JMenuBar();

            // FILE MENU
            JMenu fileMenu = new JMenu("File");

            JMenuItem newItem = new JMenuItem("New");
            JMenuItem saveItem = new JMenuItem("Save");
            JMenuItem exitItem = new JMenuItem("Exit");

            newItem.addActionListener(e -> {
                textArea.setText("");
                JOptionPane.showMessageDialog(
                        frame,
                        "A new document has been created."
                );
            });

            saveItem.addActionListener(e -> {
                JOptionPane.showMessageDialog(
                        frame,
                        "Document saved successfully!",
                        "Save",
                        JOptionPane.INFORMATION_MESSAGE
                );
            });

            exitItem.addActionListener(e -> exitApplication());

            fileMenu.add(newItem);
            fileMenu.add(saveItem);
            fileMenu.addSeparator();
            fileMenu.add(exitItem);

            // EDIT MENU
            JMenu editMenu = new JMenu("Edit");

            JMenuItem clearItem = new JMenuItem("Clear");
            JMenuItem inputItem = new JMenuItem("Enter Student Name");

            clearItem.addActionListener(e -> textArea.setText(""));

            inputItem.addActionListener(e -> {
                String name = JOptionPane.showInputDialog(
                        frame,
                        "Enter the student's name:"
                );

                if (name != null && !name.trim().isEmpty()) {
                    textArea.append("\nStudent Name: " + name.trim());
                }
            });

            editMenu.add(clearItem);
            editMenu.add(inputItem);

            // HELP MENU
            JMenu helpMenu = new JMenu("Help");

            JMenuItem aboutItem = new JMenuItem("About");

            aboutItem.addActionListener(e -> {
                JOptionPane.showMessageDialog(
                        frame,
                        "Student Management System\n"
                                + "Version 1.0\n"
                                + "Developed using Java Swing.",
                        "About",
                        JOptionPane.INFORMATION_MESSAGE
                );
            });

            helpMenu.add(aboutItem);

            // Add menus to menu bar
            menuBar.add(fileMenu);
            menuBar.add(editMenu);
            menuBar.add(helpMenu);

            frame.setJMenuBar(menuBar);

            // Create popup menu
            JPopupMenu popupMenu = new JPopupMenu();

            JMenuItem popupClear = new JMenuItem("Clear Text");
            JMenuItem popupName = new JMenuItem("Add Student Name");

            popupClear.addActionListener(e -> textArea.setText(""));

            popupName.addActionListener(e -> {
                String name = JOptionPane.showInputDialog(
                        frame,
                        "Enter student name:"
                );

                if (name != null && !name.trim().isEmpty()) {
                    textArea.append("\nStudent Name: " + name.trim());
                }
            });

            popupMenu.add(popupClear);
            popupMenu.add(popupName);

            // Display popup menu on right-click
            textArea.addMouseListener(new MouseAdapter() {

                private void showPopup(MouseEvent e) {
                    if (e.isPopupTrigger()) {
                        popupMenu.show(
                                e.getComponent(),
                                e.getX(),
                                e.getY()
                        );
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    showPopup(e);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    showPopup(e);
                }
            });

            // Bottom status label
            JLabel statusLabel = new JLabel(
                    "Ready - Use the menus or right-click for options."
            );

            statusLabel.setBorder(
                    BorderFactory.createEmptyBorder(8, 10, 8, 10)
            );

            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(statusLabel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }

    // Confirmation dialog before exiting
    private static void exitApplication() {

        int choice = JOptionPane.showConfirmDialog(
                frame,
                "Are you sure you want to exit?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (choice == JOptionPane.YES_OPTION) {
            frame.dispose();
        }
    }
}
