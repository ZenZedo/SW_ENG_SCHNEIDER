package naehmaschine.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * F2.1-F2.3: Virtuelles Fußpedal für Geschwindigkeitssteuerung.
 */
public class PedalPanel extends JPanel {

    private static final int PEDAL_WIDTH = 200;
    private static final int PEDAL_HEIGHT = 80;

    private double pedalPosition; // 0.0 - 1.0
    private boolean pressed;
    private NaehmaschineView.PedalListener listener;
    private JPanel pedalCanvas;
    private JLabel statusLabel;

    public PedalPanel() {
        this.pedalPosition = 0.0;
        this.pressed = false;

        setLayout(new BorderLayout(10, 5));
        setBorder(BorderFactory.createTitledBorder("Fußpedal"));
        setPreferredSize(new Dimension(0, 150));

        // Pedal Canvas
        pedalCanvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                paintPedal((Graphics2D) g);
            }
        };
        pedalCanvas.setPreferredSize(new Dimension(PEDAL_WIDTH, PEDAL_HEIGHT));
        pedalCanvas.setBackground(Color.LIGHT_GRAY);
        setupMouseListeners();

        // Status-Label
        statusLabel = new JLabel("Nicht gedrückt - 0 U/min", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Layout
        JPanel centerWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerWrapper.add(pedalCanvas);

        add(centerWrapper, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
    }

    /**
     * Zeichnet das Pedal.
     */
    private void paintPedal(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int offset = pressed ? (int)(pedalPosition * 10) : 0;

        // Pedal-Body
        Color pedalColor = pressed ? new Color(100, 150, 200) :
                new Color(150, 150, 150);
        g2d.setColor(pedalColor);
        g2d.fillRoundRect(20, 20 + offset, PEDAL_WIDTH - 40,
                PEDAL_HEIGHT - 30, 15, 15);

        // Schatten
        g2d.setColor(new Color(0, 0, 0, 50));
        g2d.fillRoundRect(22, 22 + offset, PEDAL_WIDTH - 40,
                PEDAL_HEIGHT - 30, 15, 15);

        // Pedal-Umriss
        g2d.setColor(Color.DARK_GRAY);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRoundRect(20, 20 + offset, PEDAL_WIDTH - 40,
                PEDAL_HEIGHT - 30, 15, 15);

        // Text
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        String text = pressed ? "GEDRÜCKT" : "PEDAL";
        FontMetrics fm = g2d.getFontMetrics();
        int textX = (PEDAL_WIDTH - fm.stringWidth(text)) / 2;
        int textY = (PEDAL_HEIGHT + offset) / 2 + fm.getAscent() / 2;
        g2d.drawString(text, textX, textY);
    }

    /**
     * Maus-Listener für Pedal-Interaktion.
     */
    private void setupMouseListeners() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pressed = true;
                pedalPosition = 0.5; // Mittlere Stärke beim Klicken
                updateStatus();
                pedalCanvas.repaint();
                if (listener != null) {
                    listener.onPedalPressed(pedalPosition);
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (pressed) {
                    // Stärke basierend auf Y-Position
                    double relativeY = (double)e.getY() / PEDAL_HEIGHT;
                    pedalPosition = Math.max(0.0, Math.min(1.0, relativeY));
                    updateStatus();
                    pedalCanvas.repaint();
                    if (listener != null) {
                        listener.onPedalPressed(pedalPosition);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                pressed = false;
                pedalPosition = 0.0;
                updateStatus();
                pedalCanvas.repaint();
                if (listener != null) {
                    listener.onPedalReleased();
                }
            }
        };

        pedalCanvas.addMouseListener(mouseAdapter);
        pedalCanvas.addMouseMotionListener(mouseAdapter);
    }

    private void updateStatus() {
        double geschwindigkeit = pedalPosition * 1100;
        statusLabel.setText(String.format("%s - %.0f U/min",
                pressed ? "Gedrückt" : "Nicht gedrückt",
                geschwindigkeit));
    }

    public void setPedalListener(NaehmaschineView.PedalListener listener) {
        this.listener = listener;
    }
}

