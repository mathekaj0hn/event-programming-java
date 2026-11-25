
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class MiniFileManager extends JFrame {

    private DefaultListModel<File> fileModel;
    private JList<File> fileList;

    private JLabel pathLabel;
    private JLabel detailsLabel;

    private File currentDirectory;

    public MiniFileManager() {

        setTitle("Mini File Manager");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Default starting directory
        currentDirectory = new File(
                System.getProperty("user.home")
        );

        // Heading
        JLabel heading = new JLabel(
                "MINI FILE MANAGER",
                SwingConstants.CENTER
        );

        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 5, 10)
        );

        // File list
        fileModel = new DefaultListModel<>();
        fileList = new JList<>(fileModel);

        fileList.setFont(new Font("Arial", Font.PLAIN, 14));
        fileList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        fileList.setCellRenderer(new DefaultListCellRenderer() {

            @Override
            public Component getListCellRendererComponent(
                    JList<?> list,
                    Object value,
                    int index,
                    boolean selected,
                    boolean focused
            ) {

                super.getListCellRendererComponent(
                        list,
                        value,
                        index,
                        selected,
                        focused
                );

                File file = (File) value;

                if (file.isDirectory()) {
                    setText("[FOLDER] " + file.getName());
                } else {
                    setText("[FILE] " + file.getName());
                }

                return this;
            }
        });

        JScrollPane scrollPane = new JScrollPane(fileList);

        // Current directory label
        pathLabel = new JLabel();
        pathLabel.setBorder(
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        );

        // Details label
        detailsLabel = new JLabel(
                "Select a file or folder to view its details."
        );

        detailsLabel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );

        // Toolbar buttons
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton chooseButton = new JButton("Choose Folder");
        JButton refreshButton = new JButton("Refresh");
        JButton backButton = new JButton("Home");
        JButton openButton = new JButton("Open Selected");

        toolbar.add(chooseButton);
        toolbar.add(refreshButton);
        toolbar.add(backButton);
        toolbar.add(openButton);

        // Choose directory
        chooseButton.addActionListener(e -> chooseDirectory());

        // Refresh directory
        refreshButton.addActionListener(e -> loadDirectory());

        // Return to home directory
        backButton.addActionListener(e -> {
            currentDirectory = new File(
                    System.getProperty("user.home")
            );
            loadDirectory();
        });

        // Open selected item
        openButton.addActionListener(e -> openSelectedItem());

        // Show selected file details
        fileList.addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting()) {

                File selectedFile = fileList.getSelectedValue();

                if (selectedFile != null) {
                    showDetails(selectedFile);
                }
            }
        });

        // Double-click to open files or folders
        fileList.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    openSelectedItem();
                }
            }
        });

        // Main content panel
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(pathLabel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        // Bottom panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(detailsLabel, BorderLayout.CENTER);

        // Add components
        add(heading, BorderLayout.NORTH);
        add(toolbar, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Load initial directory
        loadDirectory();
    }

    // Select a folder
    private void chooseDirectory() {

        JFileChooser chooser = new JFileChooser();

        chooser.setFileSelectionMode(
                JFileChooser.DIRECTORIES_ONLY
        );

        chooser.setCurrentDirectory(currentDirectory);

        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {

            currentDirectory = chooser.getSelectedFile();

            loadDirectory();
        }
    }

    // Display directory contents
    private void loadDirectory() {

        fileModel.clear();

        pathLabel.setText(
                "Current Directory: " + currentDirectory.getAbsolutePath()
        );

        File[] files = currentDirectory.listFiles();

        if (files == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Unable to access this directory.",
                    "Access Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // Display folders before files
        java.util.Arrays.sort(
                files,
                (a, b) -> {
                    if (a.isDirectory() != b.isDirectory()) {
                        return a.isDirectory() ? -1 : 1;
                    }
                    return a.getName().compareToIgnoreCase(b.getName());
                }
        );

        for (File file : files) {
            fileModel.addElement(file);
        }

        detailsLabel.setText(
                files.length + " item(s) found."
        );
    }

    // Open selected file or folder
    private void openSelectedItem() {

        File selectedFile = fileList.getSelectedValue();

        if (selectedFile == null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please select a file or folder first."
            );

            return;
        }

        if (selectedFile.isDirectory()) {

            currentDirectory = selectedFile;
            loadDirectory();

        } else {

            try {

                if (Desktop.isDesktopSupported()
                        && Desktop.getDesktop().isSupported(
                                Desktop.Action.OPEN
                        )) {

                    Desktop.getDesktop().open(selectedFile);

                } else {

                    JOptionPane.showMessageDialog(
                            this,
                            "Opening files is not supported on this computer."
                    );
                }

            } catch (IOException | UnsupportedOperationException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Could not open the file:\n" + ex.getMessage(),
                        "Open Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    // Display file information
    private void showDetails(File file) {

        DecimalFormat formatter = new DecimalFormat("#,##0.00");

        String type = file.isDirectory() ? "Folder" : "File";

        String size = file.isDirectory()
                ? "Not calculated"
                : formatter.format(file.length() / 1024.0) + " KB";

        detailsLabel.setText(
                "Name: " + file.getName()
                        + " | Type: " + type
                        + " | Size: " + size
        );
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            MiniFileManager manager = new MiniFileManager();
            manager.setVisible(true);
        });
    }
}

