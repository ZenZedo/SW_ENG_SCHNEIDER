package naehmaschine.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import naehmaschine.model.Stichmuster;
import naehmaschine.util.StichMusterRenderer;

/**
 * Canvas für die Näh-Animation mit skalierter Anzeige.
 * Zeigt die Stiche vergrößert an, damit Längen/Breiten-Unterschiede deutlich sichtbar sind.
 */
public class Naehflaeche extends JPanel {

    private Stichmuster aktuellesStichmuster;
    private double geschwindigkeit;
    private boolean sewing;
    private List<Point> stitchPoints;
    private Timer animationTimer;
    private int currentX;
    private int currentY;

    // ← NEU: Skalierungsfaktor für bessere Sichtbarkeit
    private static final double SCALE_FACTOR = 4.0;
    private static final int STITCH_SPACING = 15;  // Abstand zwischen Stichen

    public Naehflaeche() {
        setBorder(BorderFactory.createTitledBorder("Nähfläche"));
        setBackground(new Color(240, 240, 240));
        setPreferredSize(new Dimension(600, 400));

        stitchPoints = new ArrayList<>();
        currentX = 50;
        currentY = 50;
        sewing = false;
    }

    public void setStichmuster(Stichmuster muster) {
        this.aktuellesStichmuster = muster;
        stitchPoints.clear();
        currentX = 50;
        currentY = 50;
        repaint();
    }

    public void setGeschwindigkeit(double geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
        updateAnimationSpeed();
    }

    public void startSewing() {
        if (!sewing && aktuellesStichmuster != null) {
            sewing = true;
            startAnimation();
        }
    }

    public void stopSewing() {
        sewing = false;
        if (animationTimer != null) {
            animationTimer.stop();
        }
    }

    private void startAnimation() {
        if (animationTimer == null) {
            animationTimer = new Timer(100, e -> addStitch());
        }
        updateAnimationSpeed();
        animationTimer.start();
    }

    private void updateAnimationSpeed() {
        if (animationTimer != null && sewing) {
            int delay = geschwindigkeit > 0 ?
                    (int)(1100 / Math.max(1, geschwindigkeit) * 100) : 100;
            animationTimer.setDelay(Math.max(10, delay));
        }
    }

    /**
     * Fügt einen neuen Stich mit Skalierung hinzu.
     */
    private void addStitch() {
        if (!sewing || aktuellesStichmuster == null) return;

        stitchPoints.add(new Point(currentX, currentY));

        // ← GEÄNDERT: Stichlänge mit Skalierungsfaktor multiplizieren
        double scaledStitchLength = aktuellesStichmuster.getStichlaenge() * SCALE_FACTOR;
        currentX += (int)scaledStitchLength + STITCH_SPACING;

        // Zeilenumbruch
        if (currentX > getWidth() - 100) {
            currentX = 50;
            currentY += 40;  // ← Etwas Abstand zwischen Zeilen
        }

        // Canvas leeren wenn unten angekommen
        if (currentY > getHeight() - 50) {
            stitchPoints.clear();
            currentY = 50;
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (aktuellesStichmuster == null || stitchPoints.isEmpty()) {
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.setFont(new Font("Arial", Font.ITALIC, 20));
            String text = "Pedal drücken zum Nähen...";
            FontMetrics fm = g2d.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(text)) / 2;
            int y = getHeight() / 2;
            g2d.drawString(text, x, y);

            // ← NEU: Zeige aktuelle Parameter-Info
            drawParameterInfo(g2d);
            return;
        }

        // Stiche mit Skalierung zeichnen
        g2d.setColor(new Color(50, 50, 200));
        g2d.setStroke(new BasicStroke(2.5f));

        for (int i = 0; i < stitchPoints.size() - 1; i++) {
            Point p1 = stitchPoints.get(i);
            Point p2 = stitchPoints.get(i + 1);

            // Stichmuster mit Skalierung rendern
            StichMusterRenderer.renderStitch(g2d, aktuellesStichmuster, p1, p2,
                    SCALE_FACTOR);
        }

        // ← NEU: Zeige Muster-Informationen oben an
        drawPatternInfo(g2d);
    }

    /**
     * ← NEU: Zeichnet aktuelle Parameter-Informationen.
     */
    private void drawPatternInfo(Graphics2D g2d) {
        String info = String.format("%s | Länge: %.1f mm | Breite: %.1f mm",
                aktuellesStichmuster.getName(),
                aktuellesStichmuster.getStichlaenge(),
                aktuellesStichmuster.getStichbreite());

        g2d.setColor(new Color(100, 100, 100));
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        g2d.drawString(info, 20, 25);
    }

    /**
     * ← NEU: Zeichnet Info wenn nicht genäht wird.
     */
    private void drawParameterInfo(Graphics2D g2d) {
        if (aktuellesStichmuster != null) {
            String info = String.format("Muster: %s | Länge: %.1f mm | Breite: %.1f mm",
                    aktuellesStichmuster.getName(),
                    aktuellesStichmuster.getStichlaenge(),
                    aktuellesStichmuster.getStichbreite());

            g2d.setColor(new Color(150, 150, 150));
            g2d.setFont(new Font("Arial", Font.BOLD, 14));
            FontMetrics fm = g2d.getFontMetrics();
            int x = (getWidth() - fm.stringWidth(info)) / 2;
            g2d.drawString(info, x, getHeight() / 2 + 30);
        }
    }
}
