
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingApp extends JPanel {

    private final ArrayList<Point> points = new ArrayList<>();

    public DrawingApp() {

        setBackground(Color.WHITE);

        // Mouse click listener
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }
        });

        // Mouse movement listener
        addMouseMotionListener(new MouseMotionAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.BLUE);

        // Draw small circles connecting the recorded mouse positions
        for (int i = 1; i < points.size(); i++) {

            Point previous = points.get(i - 1);
            Point current = points.get(i);

            g.drawLine(
                    previous.x,
                    previous.y,
                    current.x,
                    current.y
            );
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Mouse Drawing Application");

            DrawingApp drawingPanel = new DrawingApp();

            JButton clearButton = new JButton("Clear Drawing");

            clearButton.addActionListener(e -> {
                drawingPanel.points.clear();
                drawingPanel.repaint();
            });

            frame.setLayout(new BorderLayout());

            frame.add(drawingPanel, BorderLayout.CENTER);
            frame.add(clearButton, BorderLayout.SOUTH);

            frame.setSize(650, 450);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
