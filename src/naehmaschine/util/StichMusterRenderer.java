package naehmaschine.util;

import java.awt.*;
import java.awt.geom.*;
import naehmaschine.model.Stichmuster;

/**
 * Utility-Klasse zum Rendern verschiedener Stichmuster mit Skalierung.
 */
public class StichMusterRenderer {

    /**
     * Rendert einen Stich mit Skalierungsfaktor.
     */
    public static void renderStitch(Graphics2D g2d, Stichmuster muster,
                                    Point p1, Point p2, double scaleFactor) {
        switch (muster.getNummer()) {
            case 1: // Geradstich
                renderStraightStitch(g2d, p1, p2, scaleFactor);
                break;
            case 2: // Zickzack
                renderZigzagStitch(g2d, p1, p2, muster.getStichbreite(), scaleFactor);
                break;
            case 3: // Dreifach-Geradstich
                renderTripleStraightStitch(g2d, p1, p2, scaleFactor);
                break;
            case 4: // Elastischer Zickzack
                renderElasticZigzag(g2d, p1, p2, muster.getStichbreite(), scaleFactor);
                break;
            case 5: // Blindstich
                renderBlindStitch(g2d, p1, p2, scaleFactor);
                break;
            case 6: // Überwendlingstich
                renderOverlockStitch(g2d, p1, p2, muster.getStichbreite(), scaleFactor);
                break;
            case 7: // Knopflochstich
                renderButtonholeStitch(g2d, p1, p2, muster.getStichbreite(), scaleFactor);
                break;
            case 8: // Federstich
                renderFeatherStitch(g2d, p1, p2, muster.getStichbreite(), scaleFactor);
                break;
            case 9: // Hexenstich
                renderHoneycombStitch(g2d, p1, p2, scaleFactor);
                break;
            case 10: // Kreuzstich
                renderCrossStitch(g2d, p1, p2, scaleFactor);
                break;
            case 11: // Muschelstich
                renderShellStitch(g2d, p1, p2, muster.getStichbreite(), scaleFactor);
                break;
            case 12: // Wellenstich
                renderWaveStitch(g2d, p1, p2, muster.getStichbreite(), scaleFactor);
                break;
            case 13: // Blumenstich
                renderFlowerStitch(g2d, p1, p2, scaleFactor);
                break;
            case 14: // Sternstich
                renderStarStitch(g2d, p1, p2, scaleFactor);
                break;
            case 15: // Rautenstich
                renderDiamondStitch(g2d, p1, p2, scaleFactor);
                break;
            default:
                renderStraightStitch(g2d, p1, p2, scaleFactor);
        }
    }

    // ← ALLE Rendering-Methoden müssen den scaleFactor berücksichtigen

    private static void renderStraightStitch(Graphics2D g2d, Point p1, Point p2,
                                             double scale) {
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    private static void renderZigzagStitch(Graphics2D g2d, Point p1, Point p2,
                                           double width, double scale) {
        int w = (int)(width * scale * 2);
        Path2D path = new Path2D.Double();
        path.moveTo(p1.x, p1.y - w/2);
        path.lineTo(p2.x, p2.y + w/2);
        g2d.draw(path);
    }

    private static void renderTripleStraightStitch(Graphics2D g2d, Point p1, Point p2,
                                                   double scale) {
        int offset = (int)(2 * scale);
        g2d.drawLine(p1.x, p1.y - offset, p2.x, p2.y - offset);
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        g2d.drawLine(p1.x, p1.y + offset, p2.x, p2.y + offset);
    }

    private static void renderElasticZigzag(Graphics2D g2d, Point p1, Point p2,
                                            double width, double scale) {
        int w = (int)(width * scale * 2);
        Path2D path = new Path2D.Double();
        path.moveTo(p1.x, p1.y);
        path.quadTo((p1.x + p2.x)/2, p1.y - w, p2.x, p2.y);
        g2d.draw(path);
    }

    private static void renderBlindStitch(Graphics2D g2d, Point p1, Point p2,
                                          double scale) {
        int offset = (int)(3 * scale);
        g2d.drawLine(p1.x, p1.y, p2.x - offset, p2.y);
        g2d.drawLine(p2.x - offset, p2.y, p2.x, p2.y - (int)(5 * scale));
    }

    private static void renderOverlockStitch(Graphics2D g2d, Point p1, Point p2,
                                             double width, double scale) {
        int w = (int)(width * scale * 2);
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        g2d.drawLine(p1.x, p1.y, p2.x - (int)(3*scale), p2.y + w);
    }

    private static void renderButtonholeStitch(Graphics2D g2d, Point p1, Point p2,
                                               double width, double scale) {
        int w = (int)(width * scale * 2);
        g2d.drawLine(p1.x, p1.y - w/2, p2.x, p2.y - w/2);
        g2d.drawLine(p1.x, p1.y + w/2, p2.x, p2.y + w/2);
        g2d.drawLine(p1.x, p1.y - w/2, p1.x, p1.y + w/2);
    }

    private static void renderFeatherStitch(Graphics2D g2d, Point p1, Point p2,
                                            double width, double scale) {
        int w = (int)(width * scale * 2);
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        g2d.drawLine(p1.x, p1.y, (p1.x + p2.x)/2, (int)(p1.y - w * scale));
        g2d.drawLine(p1.x, p1.y, (p1.x + p2.x)/2, (int)(p1.y + w * scale));
    }

    private static void renderHoneycombStitch(Graphics2D g2d, Point p1, Point p2,
                                              double scale) {
        int size = (int)(5 * scale);
        g2d.drawOval(p1.x - size/2, p1.y - size/2, size, size);
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    private static void renderCrossStitch(Graphics2D g2d, Point p1, Point p2,
                                          double scale) {
        int size = (int)(4 * scale);
        g2d.drawLine(p1.x - size, p1.y - size, p1.x + size, p1.y + size);
        g2d.drawLine(p1.x - size, p1.y + size, p1.x + size, p1.y - size);
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    private static void renderShellStitch(Graphics2D g2d, Point p1, Point p2,
                                          double width, double scale) {
        int w = (int)(width * scale * 2);
        Path2D path = new Path2D.Double();
        path.moveTo(p1.x, p1.y);
        path.curveTo(p1.x + (int)(3*scale), p1.y - w, p2.x - (int)(3*scale), p2.y - w, p2.x, p2.y);
        g2d.draw(path);
    }

    private static void renderWaveStitch(Graphics2D g2d, Point p1, Point p2,
                                         double width, double scale) {
        int w = (int)(width * scale);
        Path2D path = new Path2D.Double();
        path.moveTo(p1.x, p1.y);
        path.quadTo((p1.x + p2.x)/2, p1.y - w, p2.x, p2.y);
        path.quadTo((p1.x + p2.x)/2, p1.y + w, p2.x, p2.y);
        g2d.draw(path);
    }

    private static void renderFlowerStitch(Graphics2D g2d, Point p1, Point p2,
                                           double scale) {
        int size = (int)(6 * scale);
        for (int i = 0; i < 5; i++) {
            double angle = Math.toRadians(i * 72);
            int x = p1.x + (int)(size * Math.cos(angle));
            int y = p1.y + (int)(size * Math.sin(angle));
            g2d.drawLine(p1.x, p1.y, x, y);
        }
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    private static void renderStarStitch(Graphics2D g2d, Point p1, Point p2,
                                         double scale) {
        int size = (int)(5 * scale);
        for (int i = 0; i < 8; i++) {
            double angle = Math.toRadians(i * 45);
            int x = p1.x + (int)(size * Math.cos(angle));
            int y = p1.y + (int)(size * Math.sin(angle));
            g2d.drawLine(p1.x, p1.y, x, y);
        }
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    private static void renderDiamondStitch(Graphics2D g2d, Point p1, Point p2,
                                            double scale) {
        int size = (int)(4 * scale);
        Path2D path = new Path2D.Double();
        path.moveTo(p1.x, p1.y - size);
        path.lineTo(p1.x + size, p1.y);
        path.lineTo(p1.x, p1.y + size);
        path.lineTo(p1.x - size, p1.y);
        path.closePath();
        g2d.draw(path);
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
    }
}
