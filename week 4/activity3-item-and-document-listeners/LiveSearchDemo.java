
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class LiveSearchDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Live Search Application");
            frame.setSize(450, 350);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout(10, 10));

            String[] students = {
                "Alice Johnson",
                "Brian Smith",
                "Charles Brown",
                "David Wilson",
                "Elizabeth Taylor",
                "Faith Mwangi",
                "George Kamau",
                "Hannah Otieno"
            };

            JTextField searchField = new JTextField();
            DefaultListModel<String> listModel = new DefaultListModel<>();
            JList<String> studentList = new JList<>(listModel);

            for (String student : students) {
                listModel.addElement(student);
            }

            JLabel instruction = new JLabel("Search for a student:");

            JPanel topPanel = new JPanel(new BorderLayout(5, 5));
            topPanel.add(instruction, BorderLayout.NORTH);
            topPanel.add(searchField, BorderLayout.CENTER);

            frame.add(topPanel, BorderLayout.NORTH);
            frame.add(new JScrollPane(studentList), BorderLayout.CENTER);

            searchField.getDocument().addDocumentListener(
                new DocumentListener() {

                    private void filterStudents() {

                        String search = searchField.getText()
                                .trim().toLowerCase();

                        listModel.clear();

                        for (String student : students) {
                            if (student.toLowerCase().contains(search)) {
                                listModel.addElement(student);
                            }
                        }
                    }

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        filterStudents();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        filterStudents();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        filterStudents();
                    }
                }
            );

            frame.setVisible(true);
        });
    }
}
