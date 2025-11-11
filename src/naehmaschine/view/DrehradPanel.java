package naehmaschine.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import naehmaschine.model.LED;

/**
 * F1.2: Drehrad-Steuerung für alle auswählbaren Einstellungen.
 * Ermöglicht die Auswahl und Anpassung von Parametern durch Drehen.
 */
public class DrehradPanel extends JPanel {

    private static final int DIAL_SIZE = 200;

    private enum SteuerModus {
        STICHMUSTER, STICHLAENGE, STICHBREITE,
        FADENSPANNUNG, LED_HELLIGKEIT, LED_MODUS
    }

    private SteuerModus aktuellerModus;
    private double drehwinkel; // 0-360 Grad
    private JPanel drehradCanvas;
    private JLabel werteLabel;
    private NaehmaschineView.DrehradListener listener;

    private Point lastMousePoint;

    public DrehradPanel() {
        this.aktuellerModus = SteuerModus.STICHMUSTER;
        this.drehwinkel = 0;

        setLayout(new BorderLayout(5, 10));
        setBorder(BorderFactory.createTitledBorder("Drehrad-Steuerung"));
        setPreferredSize(new Dimension(280, 600));

        // Modus-Auswahl Buttons
        JPanel modusPanel = createModusPanel();
        add(modusPanel, BorderLayout.NORTH);

        // Drehrad
        drehradCanvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                paintDrehrad((Graphics2D) g);
            }
        };
        drehradCanvas.setPreferredSize(new Dimension(DIAL_SIZE, DIAL_SIZE));
        drehradCanvas.setBackground(Color.LIGHT_GRAY);
        setupMouseListeners();

        add(drehradCanvas, BorderLayout.CENTER);

        // Werte-Anzeige
        werteLabel = new JLabel("Wert: --", SwingConstants.CENTER);
        werteLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(werteLabel, BorderLayout.SOUTH);
    }

    /**
     * Erstellt Panel mit Modus-Auswahl-Buttons.
     */
    private JPanel createModusPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Modus"));

        addModusButton(panel, "Stichmuster", SteuerModus.STICHMUSTER);
        addModusButton(panel, "Stichlänge", SteuerModus.STICHLAENGE);
        addModusButton(panel, "Stichbreite", SteuerModus.STICHBREITE);
        addModusButton(panel, "Fadenspannung", SteuerModus.FADENSPANNUNG);
        addModusButton(panel, "LED Helligkeit", SteuerModus.LED_HELLIGKEIT);
        addModusButton(panel, "LED Modus", SteuerModus.LED_MODUS);

        return panel;
    }

    private void addModusButton(JPanel panel, String text, SteuerModus modus) {
        JButton button = new JButton(text);
        button.addActionListener(e -> {
            aktuellerModus = modus;
            updateWerteAnzeige();
        });
        panel.add(button);
    }

    /**
     * Zeichnet das Drehrad.
     */
    private void paintDrehrad(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = DIAL_SIZE / 2;
        int centerY = DIAL_SIZE / 2;
        int radius = DIAL_SIZE / 2 - 20;

        // Äußerer Kreis (Drehrad-Body)
        g2d.setColor(new Color(80, 80, 80));
        g2d.fillOval(centerX - radius, centerY - radius,
                radius * 2, radius * 2);

        // Innerer Kreis
        int innerRadius = radius - 15;
        g2d.setColor(new Color(120, 120, 120));
        g2d.fillOval(centerX - innerRadius, centerY - innerRadius,
                innerRadius * 2, innerRadius * 2);

        // Marker-Linien (12 Stück wie bei einer Uhr)
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(2));
        for (int i = 0; i < 12; i++) {
            double angle = Math.toRadians(i * 30);
            int x1 = centerX + (int)(innerRadius * 0.85 * Math.cos(angle));
            int y1 = centerY + (int)(innerRadius * 0.85 * Math.sin(angle));
            int x2 = centerX + (int)(innerRadius * Math.cos(angle));
            int y2 = centerY + (int)(innerRadius * Math.sin(angle));
            g2d.drawLine(x1, y1, x2, y2);
        }

        // Zeiger
        double angleRad = Math.toRadians(drehwinkel - 90);
        int pointerLength = radius - 30;
        int pointerX = centerX + (int)(pointerLength * Math.cos(angleRad));
        int pointerY = centerY + (int)(pointerLength * Math.sin(angleRad));

        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(4));
        g2d.drawLine(centerX, centerY, pointerX, pointerY);

        // Zentrum
        g2d.setColor(Color.DARK_GRAY);
        g2d.fillOval(centerX - 8, centerY - 8, 16, 16);
    }

    /**
     * Maus-Listener für Drehrad-Interaktion.
     */
    private void setupMouseListeners() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastMousePoint = e.getPoint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (lastMousePoint != null) {
                    int centerX = DIAL_SIZE / 2;
                    int centerY = DIAL_SIZE / 2;

                    double angle1 = Math.atan2(lastMousePoint.y - centerY,
                            lastMousePoint.x - centerX);
                    double angle2 = Math.atan2(e.getY() - centerY,
                            e.getX() - centerX);

                    double angleDiff = Math.toDegrees(angle2 - angle1);
                    drehwinkel += angleDiff;

                    // Normalisieren auf 0-360
                    while (drehwinkel < 0) drehwinkel += 360;
                    while (drehwinkel >= 360) drehwinkel -= 360;

                    lastMousePoint = e.getPoint();
                    drehradCanvas.repaint();
                    updateWerteAnzeige();
                    notifyListener();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                lastMousePoint = null;
            }
        };

        drehradCanvas.addMouseListener(mouseAdapter);
        drehradCanvas.addMouseMotionListener(mouseAdapter);
    }

    /**
     * Aktualisiert die Werte-Anzeige basierend auf Modus und Winkel.
     */
    private void updateWerteAnzeige() {
        String text = "";
        switch (aktuellerModus) {
            case STICHMUSTER:
                int musterNr = (int)(drehwinkel / 360.0 * 15) + 1;
                text = "Muster: " + musterNr;
                break;
            case STICHLAENGE:
                double laenge = 1.5 + (drehwinkel / 360.0 * 3.5);
                text = String.format("Länge: %.1f mm", laenge);
                break;
            case STICHBREITE:
                double breite = 2.5 + (drehwinkel / 360.0 * 4.5);
                text = String.format("Breite: %.1f mm", breite);
                break;
            case FADENSPANNUNG:
                double spannung = 1.0 + (drehwinkel / 360.0 * 8.0);
                text = String.format("Spannung: %.1f", spannung);
                break;
            case LED_HELLIGKEIT:
                int helligkeit = (int)(drehwinkel / 360.0 * 5) + 1;
                text = "Helligkeit: " + helligkeit;
                break;
            case LED_MODUS:
                int modusIndex = (int)(drehwinkel / 120.0);
                String[] modi = {"Aus", "Ein", "Automatisch"};
                text = "Modus: " + modi[modusIndex % 3];
                break;
        }
        werteLabel.setText(text);
    }

    /**
     * Benachrichtigt Listener über Wertänderung.
     */
    private void notifyListener() {
        if (listener == null) return;

        switch (aktuellerModus) {
            case STICHMUSTER:
                int musterNr = (int)(drehwinkel / 360.0 * 15) + 1;
                listener.onStichmusterChanged(musterNr);
                break;
            case STICHLAENGE:
                double laenge = 1.5 + (drehwinkel / 360.0 * 3.5);
                listener.onStichlaengeChanged(laenge);
                break;
            case STICHBREITE:
                double breite = 2.5 + (drehwinkel / 360.0 * 4.5);
                listener.onStichbreiteChanged(breite);
                break;
            case FADENSPANNUNG:
                double spannung = 1.0 + (drehwinkel / 360.0 * 8.0);
                listener.onFadenspannungChanged(spannung);
                break;
            case LED_HELLIGKEIT:
                int helligkeit = (int)(drehwinkel / 360.0 * 5) + 1;
                listener.onLEDHelligkeitChanged(helligkeit);
                break;
            case LED_MODUS:
                int modusIndex = (int)(drehwinkel / 120.0) % 3;
                LED.LEDModus[] modi = {LED.LEDModus.AUS,
                        LED.LEDModus.EIN,
                        LED.LEDModus.AUTOMATISCH};
                listener.onLEDModusChanged(modi[modusIndex]);
                break;
        }
    }

    public void setDrehradListener(NaehmaschineView.DrehradListener listener) {
        this.listener = listener;
    }
}
