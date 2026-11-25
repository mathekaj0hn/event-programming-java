
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TabbedPaneDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("University Student Management");
            frame.setSize(700, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout());

            // Main heading
            JLabel heading = new JLabel(
                    "STUDENT MANAGEMENT SYSTEM",
                    SwingConstants.CENTER
            );

            heading.setFont(new Font("Arial", Font.BOLD, 22));
            heading.setBorder(
                    BorderFactory.createEmptyBorder(15, 10, 15, 10)
            );

            // Create tabbed pane
            JTabbedPane tabbedPane = new JTabbedPane();

            // TAB 1: Student Details
            JPanel studentPanel = new JPanel(new GridLayout(4, 2, 10, 15));
            studentPanel.setBorder(
                    BorderFactory.createEmptyBorder(30, 40, 30, 40)
            );

            studentPanel.add(new JLabel("Student Name:"));
            studentPanel.add(new JLabel("Kent William"));

            studentPanel.add(new JLabel("Registration Number:"));
            studentPanel.add(new JLabel("BIT/2024/001"));

            studentPanel.add(new JLabel("Email Address:"));
            studentPanel.add(new JLabel("student@example.com"));

            studentPanel.add(new JLabel("Programme:"));
            studentPanel.add(new JLabel("Business Information Technology"));

            // TAB 2: Courses
            JPanel coursesPanel = new JPanel(new BorderLayout(10, 10));

            JLabel coursesHeading = new JLabel(
                    "AVAILABLE COURSES",
                    SwingConstants.CENTER
            );

            coursesHeading.setFont(new Font("Arial", Font.BOLD, 18));

            String[] courses = {
                    "Event-Driven Programming",
                    "Database Management Systems",
                    "Software Engineering",
                    "Computer Networks",
                    "Web Development",
                    "Data Structures and Algorithms",
                    "Information Systems"
            };

            JList<String> courseList = new JList<>(courses);
            courseList.setFont(new Font("Arial", Font.PLAIN, 15));
            courseList.setSelectionMode(
                    ListSelectionModel.SINGLE_SELECTION
            );

            coursesPanel.setBorder(
                    BorderFactory.createEmptyBorder(15, 20, 15, 20)
            );

            coursesPanel.add(coursesHeading, BorderLayout.NORTH);
            coursesPanel.add(
                    new JScrollPane(courseList),
                    BorderLayout.CENTER
            );

            // TAB 3: Results
            JPanel resultsPanel = new JPanel(new BorderLayout(10, 10));

            String[] columns = {
                    "Course",
                    "Marks",
                    "Grade"
            };

            Object[][] data = {
                    {"Event-Driven Programming", 85, "A"},
                    {"Database Management", 78, "B+"},
                    {"Software Engineering", 90, "A"},
                    {"Computer Networks", 72, "B"},
                    {"Web Development", 88, "A"}
            };

            DefaultTableModel model = new DefaultTableModel(
                    data,
                    columns
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            JTable resultsTable = new JTable(model);
            resultsTable.setRowHeight(30);
            resultsTable.setFont(new Font("Arial", Font.PLAIN, 14));

            resultsTable.getTableHeader().setFont(
                    new Font("Arial", Font.BOLD, 14)
            );

            JLabel resultsHeading = new JLabel(
                    "STUDENT ACADEMIC RESULTS",
                    SwingConstants.CENTER
            );

            resultsHeading.setFont(new Font("Arial", Font.BOLD, 18));

            resultsPanel.setBorder(
                    BorderFactory.createEmptyBorder(15, 20, 15, 20)
            );

            resultsPanel.add(resultsHeading, BorderLayout.NORTH);
            resultsPanel.add(
                    new JScrollPane(resultsTable),
                    BorderLayout.CENTER
            );

            // Add all three tabs
            tabbedPane.addTab("Student Details", studentPanel);
            tabbedPane.addTab("Courses", coursesPanel);
            tabbedPane.addTab("Results", resultsPanel);

            // Status label
            JLabel statusLabel = new JLabel(
                    "Welcome! Select a tab to view information.",
                    SwingConstants.CENTER
            );

            statusLabel.setBorder(
                    BorderFactory.createEmptyBorder(10, 5, 10, 5)
            );

            // Update status when a tab is selected
            tabbedPane.addChangeListener(e -> {
                int selectedIndex = tabbedPane.getSelectedIndex();

                statusLabel.setText(
                        "Currently viewing: "
                                + tabbedPane.getTitleAt(selectedIndex)
                );
            });

            // Add components to frame
            frame.add(heading, BorderLayout.NORTH);
            frame.add(tabbedPane, BorderLayout.CENTER);
            frame.add(statusLabel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
