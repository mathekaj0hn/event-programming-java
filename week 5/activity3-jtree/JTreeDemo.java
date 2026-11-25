
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;

public class JTreeDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("University Department Explorer");
            frame.setSize(600, 450);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout(10, 10));

            JLabel heading = new JLabel("UNIVERSITY STRUCTURE");
            heading.setFont(new Font("Arial", Font.BOLD, 22));
            heading.setHorizontalAlignment(SwingConstants.CENTER);
            heading.setBorder(
                    BorderFactory.createEmptyBorder(15, 10, 10, 10)
            );

            // Root node
            DefaultMutableTreeNode university =
                    new DefaultMutableTreeNode("University");

            // School of Computing
            DefaultMutableTreeNode computing =
                    new DefaultMutableTreeNode("School of Computing");

            computing.add(new DefaultMutableTreeNode("Software Engineering"));
            computing.add(new DefaultMutableTreeNode("Information Technology"));
            computing.add(new DefaultMutableTreeNode("Computer Science"));

            // School of Business
            DefaultMutableTreeNode business =
                    new DefaultMutableTreeNode("School of Business");

            business.add(new DefaultMutableTreeNode(
                    "Business Information Technology"
            ));
            business.add(new DefaultMutableTreeNode("Accounting"));
            business.add(new DefaultMutableTreeNode("Finance"));

            // School of Engineering
            DefaultMutableTreeNode engineering =
                    new DefaultMutableTreeNode("School of Engineering");

            engineering.add(new DefaultMutableTreeNode(
                    "Electrical Engineering"
            ));
            engineering.add(new DefaultMutableTreeNode(
                    "Mechanical Engineering"
            ));

            // Add schools to university
            university.add(computing);
            university.add(business);
            university.add(engineering);

            // Create tree
            JTree tree = new JTree(university);
            tree.setFont(new Font("Arial", Font.PLAIN, 15));
            tree.setRowHeight(25);

            // Expand all top-level schools
            tree.expandRow(1);
            tree.expandRow(2);
            tree.expandRow(3);

            JScrollPane scrollPane = new JScrollPane(tree);

            JLabel resultLabel = new JLabel(
                    "Select a department or school."
            );
            resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
            resultLabel.setFont(new Font("Arial", Font.BOLD, 14));

            // Handle tree selection
            tree.addTreeSelectionListener(e -> {

                DefaultMutableTreeNode selectedNode =
                        (DefaultMutableTreeNode)
                        tree.getLastSelectedPathComponent();

                if (selectedNode != null) {

                    resultLabel.setText(
                            "Selected: " + selectedNode.getUserObject()
                    );
                }
            });

            frame.add(heading, BorderLayout.NORTH);
            frame.add(scrollPane, BorderLayout.CENTER);
            frame.add(resultLabel, BorderLayout.SOUTH);

            frame.setVisible(true);
        });
    }
}
