package naehmaschine.view;

import javax.swing.*;
import java.awt.*;
import naehmaschine.model.LED;

/**
 * F3.1-F3.3: LED-Anzeige mit Modus und Helligkeit.
 */
public class LEDPanel extends JPanel {

    private LED.LEDModus modus;
    private int helligkeit;
    private boolean istAktiv;  // ← NEU: Speichert ob LED aktuell leuchten soll
    private JPanel ledLight;
    private JLabel modusLabel;

    public LEDPanel() {
        this.modus = LED.LEDModus.AUTOMATISCH;
        this.helligkeit = 3;
        this.istAktiv = false;  // ← Startet aus

        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createTitledBorder("LED-Beleuchtung"));

        // LED-Licht
        ledLight = new JPanel();
        ledLight.setPreferredSize(new Dimension(40, 40));
        ledLight.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        updateLEDColor();

        // Modus-Label
        modusLabel = new JLabel(getModeText(), SwingConstants.CENTER);
        modusLabel.setFont(new Font("Arial", Font.PLAIN, 10));

        add(ledLight, BorderLayout.CENTER);
        add(modusLabel, BorderLayout.SOUTH);
    }

    public void setModus(LED.LEDModus modus) {
        this.modus = modus;
        modusLabel.setText(getModeText());
        updateLEDColor();
    }

    public void setHelligkeit(int helligkeit) {
        this.helligkeit = helligkeit;
        updateLEDColor();  // ← Aktualisiere Farbe bei Helligkeitsänderung
    }

    // ← NEU: Methode zum Setzen des LED-Status (von außen aufrufbar)
    public void setAktiv(boolean aktiv) {
        this.istAktiv = aktiv;
        updateLEDColor();
    }

    private void updateLEDColor() {
        Color color;
        switch (modus) {
            case AUS:
                // LED immer aus
                color = new Color(50, 50, 50);
                break;
            case EIN:
                // LED immer an mit Helligkeit
                color = getLEDColorForBrightness();
                break;
            case AUTOMATISCH:
                // LED nur an wenn istAktiv == true (Pedal gedrückt)
                if (istAktiv) {
                    color = getLEDColorForBrightness();
                } else {
                    color = new Color(50, 50, 50);  // Dunkel wenn inaktiv
                }
                break;
            default:
                color = Color.DARK_GRAY;
        }
        ledLight.setBackground(color);
    }

    private Color getLEDColorForBrightness() {
        // Gelb-Töne basierend auf Helligkeit (1=dunkel, 5=hell)
        int brightness = 50 + (helligkeit * 40);  // 90 bis 250
        return new Color(brightness, brightness, 0);  // Gelb
    }

    private String getModeText() {
        return modus.toString();
    }
}
