
import javax.swing.*;
import java.awt.*;

public class JListDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Student List Management");
            frame.setSize(500, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout(10, 10));

            JLabel heading = new JLabel("STUDENT MANAGEMENT LIST");
            heading.setHorizontalAlignment(SwingConstants.CENTER);
            heading.setFont(new Font("Arial", Font.BOLD, 20));

            DefaultListModel<String> listModel = new DefaultListModel<>();

            listModel.addElement("Alice Johnson");
            listModel.addElement("Brian Smith");
            listModel.addElement("Charles Brown");
            listModel.addElement("David Wilson");
            listModel.addElement("Elizabeth Taylor");

            JList<String> studentList = new JList<>(listModel);
            studentList.setSelectionMode(
                    ListSelectionModel.SINGLE_SELECTION
            );

            studentList.setFont(new Font("Arial", Font.PLAIN, 16));

            JScrollPane scrollPane = new JScrollPane(studentList);

            JTextField nameField = new JTextField();

            JButton addButton = new JButton("Add Student");
            JButton removeButton = new JButton("Remove Selected");
            JButton showButton = new JButton("Show Selected");

            JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
            inputPanel.add(new JLabel("Student Name:"), BorderLayout.WEST);
            inputPanel.add(nameField, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel(new FlowLayout());
            buttonPanel.add(addButton);
            buttonPanel.add(removeButton);
            buttonPanel.add(showButton);

            JPanel bottomPanel = new JPanel(new BorderLayout());
            bottomPanel.add(inputPanel, BorderLayout.NORTH);
            bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

            // Add student
            addButton.addActionListener(e -> {

                String name = nameField.getText().trim();

                if (name.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please enter a student name."
                    );

                    return;
                }

                listModel.addElement(name);
                nameField.setText("");

                JOptionPane.showMessageDialog(
                        frame,
                        name + " added successfully!"
                );
            });

            // Remove selected student
            removeButton.addActionListener(e -> {

                int selectedIndex = studentList.getSelectedIndex();

                if (selectedIndex == -1) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please select a student to remove."
                    );

                    return;
                }

                String name = listModel.getElementAt(selectedIndex);

                listModel.remove(selectedIndex);

                JOptionPane.showMessageDialog(
                        frame,
                        name + " removed successfully!"
                );
            });

            // Show selected student
            showButton.addActionListener(e -> {

                String selectedStudent = studentList.getSelectedValue();

                if (selectedStudent == null) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Please select a student."
                    );

                    return;
                }

                JOptionPane.showMessageDialog(
                        frame,
                        "Selected Student: " + selectedStudent
                );
            });

            frame.add(heading, BorderLayout.NORTH);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(bottomPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
