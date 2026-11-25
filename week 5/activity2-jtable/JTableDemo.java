
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JTableDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Student Records Management");
            frame.setSize(750, 450);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout(10, 10));

            JLabel heading = new JLabel("STUDENT RECORDS MANAGEMENT");
            heading.setFont(new Font("Arial", Font.BOLD, 22));
            heading.setHorizontalAlignment(SwingConstants.CENTER);

            String[] columns = {
                "Registration Number", "Student Name", "Course", "Year"
            };

            Object[][] data = {
                {"BIT001", "Alice Johnson", "BBIT", 1},
                {"BIT002", "Brian Smith", "Computer Science", 2},
                {"BIT003", "Charles Brown", "BBIT", 3},
                {"BIT004", "David Wilson", "IT", 4},
                {"BIT005", "Elizabeth Taylor", "Software Engineering", 2}
            };

            DefaultTableModel model =
                    new DefaultTableModel(data, columns);

            JTable table = new JTable(model);
            table.setRowHeight(28);
            table.setSelectionMode(
                    ListSelectionModel.SINGLE_SELECTION
            );

            JScrollPane scrollPane = new JScrollPane(table);

            JButton addButton = new JButton("Add Student");
            JButton deleteButton = new JButton("Delete Student");
            JButton viewButton = new JButton("View Student");

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(addButton);
            buttonPanel.add(deleteButton);
            buttonPanel.add(viewButton);

            // ADD STUDENT
            addButton.addActionListener(e -> {

                JTextField regField = new JTextField();
                JTextField nameField = new JTextField();
                JTextField courseField = new JTextField();

                String[] years = {"1", "2", "3", "4"};
                JComboBox<String> yearBox = new JComboBox<>(years);

                JPanel panel = new JPanel(new GridLayout(4, 2, 5, 10));

                panel.add(new JLabel("Registration Number:"));
                panel.add(regField);

                panel.add(new JLabel("Student Name:"));
                panel.add(nameField);

                panel.add(new JLabel("Course:"));
                panel.add(courseField);

                panel.add(new JLabel("Year:"));
                panel.add(yearBox);

                int result = JOptionPane.showConfirmDialog(
                        frame, panel, "Add Student",
                        JOptionPane.OK_CANCEL_OPTION
                );

                if (result == JOptionPane.OK_OPTION) {

                    String reg = regField.getText().trim();
                    String name = nameField.getText().trim();
                    String course = courseField.getText().trim();
                    String year = (String) yearBox.getSelectedItem();

                    if (reg.isEmpty() || name.isEmpty()
                            || course.isEmpty()) {

                        JOptionPane.showMessageDialog(
                                frame, "Please fill in all fields."
                        );
                        return;
                    }

                    for (int i = 0; i < model.getRowCount(); i++) {

                        if (model.getValueAt(i, 0).toString()
                                .equalsIgnoreCase(reg)) {

                            JOptionPane.showMessageDialog(
                                    frame,
                                    "Registration number already exists."
                            );
                            return;
                        }
                    }

                    model.addRow(new Object[]{reg, name, course, year});

                    JOptionPane.showMessageDialog(
                            frame, "Student added successfully!"
                    );
                }
            });

            // DELETE STUDENT
            deleteButton.addActionListener(e -> {

                int selectedRow = table.getSelectedRow();

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(
                            frame, "Please select a student to delete."
                    );
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to delete this student?",
                        "Confirm Deletion",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {

                    model.removeRow(
                            table.convertRowIndexToModel(selectedRow)
                    );

                    JOptionPane.showMessageDialog(
                            frame, "Student deleted successfully!"
                    );
                }
            });

            // VIEW STUDENT
            viewButton.addActionListener(e -> {

                int selectedRow = table.getSelectedRow();

                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(
                            frame, "Please select a student to view."
                    );
                    return;
                }

                int row = table.convertRowIndexToModel(selectedRow);

                String details =
                        "Registration Number: "
                        + model.getValueAt(row, 0) + "\n"
                        + "Student Name: "
                        + model.getValueAt(row, 1) + "\n"
                        + "Course: "
                        + model.getValueAt(row, 2) + "\n"
                        + "Year: "
                        + model.getValueAt(row, 3);

                JOptionPane.showMessageDialog(
                        frame, details, "Student Details",
                        JOptionPane.INFORMATION_MESSAGE
                );
            });

            frame.add(heading, BorderLayout.NORTH);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(buttonPanel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
