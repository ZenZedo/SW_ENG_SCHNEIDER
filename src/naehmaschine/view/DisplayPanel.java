package naehmaschine.view;

import javax.swing.*;
import java.awt.*;
import naehmaschine.model.Stichmuster;

/**
 * F1.4, F4.3, F5.3: Display-Panel zeigt alle aktuellen Einstellungen.
 */
public class DisplayPanel extends JPanel {

    private JLabel stichmusterLabel;
    private JLabel stichlaengeLabel;
    private JLabel stichbreiteLabel;
    private JLabel fadenspannungLabel;
    private JLabel geschwindigkeitLabel;

    public DisplayPanel() {
        setLayout(new GridLayout(2, 3, 10, 5));
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2),
                "Digital Display",
                0,
                0,
                new Font("Arial", Font.BOLD, 14)));
        setBackground(new Color(50, 100, 150));

        // Labels initialisieren
        stichmusterLabel = createDisplayLabel("Muster: --");
        stichlaengeLabel = createDisplayLabel("Länge: -- mm");
        stichbreiteLabel = createDisplayLabel("Breite: -- mm");
        fadenspannungLabel = createDisplayLabel("Spannung: --");
        geschwindigkeitLabel = createDisplayLabel("Geschw.: 0 U/min");

        // Labels hinzufügen
        add(stichmusterLabel);
        add(stichlaengeLabel);
        add(stichbreiteLabel);
        add(fadenspannungLabel);
        add(geschwindigkeitLabel);
        add(new JLabel()); // Platzhalter
    }

    private JLabel createDisplayLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Monospaced", Font.BOLD, 16));
        label.setForeground(new Color(0, 255, 100));
        label.setOpaque(true);
        label.setBackground(new Color(20, 40, 60));
        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return label;
    }

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

    public void updateFadenspannung(double spannung) {
        fadenspannungLabel.setText(String.format("Spannung: %.1f", spannung));
    }

    public void updateGeschwindigkeit(double geschwindigkeit) {
        geschwindigkeitLabel.setText(
                String.format("Geschw.: %.0f U/min", geschwindigkeit));
    }
}
