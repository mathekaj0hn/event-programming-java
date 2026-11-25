
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyboardMover extends JPanel implements KeyListener {

    private int x = 180;
    private int y = 120;

    private final int SIZE = 40;
    private final int SPEED = 15;

    public KeyboardMover() {

        setBackground(Color.WHITE);
        setFocusable(true);

        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.BLUE);
        g.fillRect(x, y, SIZE, SIZE);

        g.setColor(Color.BLACK);
        g.drawString("Use arrow keys to move the square", 10, 20);
    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_UP:
                y -= SPEED;
                break;

            case KeyEvent.VK_DOWN:
                y += SPEED;
                break;

            case KeyEvent.VK_LEFT:
                x -= SPEED;
                break;

            case KeyEvent.VK_RIGHT:
                x += SPEED;
                break;
        }

        // Keep the square inside the panel
        x = Math.max(0, Math.min(x, getWidth() - SIZE));
        y = Math.max(25, Math.min(y, getHeight() - SIZE));

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No action needed
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No action needed
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Keyboard Movement Application");

            KeyboardMover panel = new KeyboardMover();

            frame.add(panel);
            frame.setSize(500, 350);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Give keyboard focus to the drawing panel
            panel.requestFocusInWindow();
        });
    }
}
