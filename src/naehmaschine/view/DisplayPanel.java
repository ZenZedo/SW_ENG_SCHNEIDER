package naehmaschine.view;

import javax.swing.*;
import java.awt.*;
import naehmaschine.model.Stichmuster;

/**
 * Sprint 1: Zeigt Stichmuster, Länge und Breite
 * Sprint 2 (TODO): Zusätzlich Geschwindigkeit, Fadenspannung
 *
 * F1.4, F5.3
 */
public class DisplayPanel extends JPanel {

    private JLabel stichmusterLabel;
    private JLabel stichlaengeLabel;
    private JLabel stichbreiteLabel;
    // TODO Sprint 2: private JLabel fadenspannungLabel;
    // TODO Sprint 2: private JLabel geschwindigkeitLabel;

    public DisplayPanel() {
        setLayout(new GridLayout(3, 1, 10, 10)); // Sprint 1: 3 Zeilen
        // TODO Sprint 2: GridLayout auf (5, 1) ändern

        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                "Digital Display",
                0,
                0,
                new Font("Arial", Font.BOLD, 14)));
        setBackground(new Color(50, 100, 150));

        // Labels initialisieren (Sprint 1)
        stichmusterLabel = createDisplayLabel("Muster: --");
        stichlaengeLabel = createDisplayLabel("Länge: -- mm");
        stichbreiteLabel = createDisplayLabel("Breite: -- mm");

        // TODO Sprint 2:
        // fadenspannungLabel = createDisplayLabel("Spannung: --");
        // geschwindigkeitLabel = createDisplayLabel("Geschw.: 0 U/min");

        // Labels hinzufügen
        add(stichmusterLabel);
        add(stichlaengeLabel);
        add(stichbreiteLabel);
        // TODO Sprint 2: add(fadenspannungLabel);
        // TODO Sprint 2: add(geschwindigkeitLabel);

        setPreferredSize(new Dimension(600, 200));
    }

    private JLabel createDisplayLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Monospaced", Font.BOLD, 20));
        label.setForeground(new Color(0, 255, 100));
        label.setOpaque(true);
        label.setBackground(new Color(20, 40, 60));
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return label;
    }

    // Sprint 1: Implementiert
    public void updateStichmuster(Stichmuster muster) {
        stichmusterLabel.setText(
                String.format("Muster: %d - %s", muster.getNummer(), muster.getName()));
    }

    public void updateStichlaenge(double laenge) {
        stichlaengeLabel.setText(String.format("Länge: %.1f mm", laenge));
    }

    public void updateStichbreite(double breite) {
        stichbreiteLabel.setText(String.format("Breite: %.1f mm", breite));
    }

    // TODO Sprint 2: Implementiere diese Methoden
    /*
    public void updateFadenspannung(double spannung) {
        fadenspannungLabel.setText(String.format("Spannung: %.1f", spannung));
    }

    public void updateGeschwindigkeit(double geschwindigkeit) {
        geschwindigkeitLabel.setText(
            String.format("Geschw.: %.0f U/min", geschwindigkeit));
    }
    */
}
