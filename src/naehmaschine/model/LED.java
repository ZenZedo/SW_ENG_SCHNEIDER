package naehmaschine.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Modellklasse für die LED-Beleuchtung.
 *
 * Sprint 1: Stub-Implementierung (Platzhalter)
 * Sprint 2 (TODO): Vollständige Implementierung
 *
 * Requirements:
 * F3.1: LED-Beleuchtung
 * F3.2: 3 Modi (Aus, Ein, Automatisch)
 * F3.3: Helligkeit 1-5
 */
public class LED {

    public static final String PROP_MODUS = "modus";
    public static final String PROP_HELLIGKEIT = "helligkeit";

    private final PropertyChangeSupport support;

    public enum LEDModus {
        AUS, EIN, AUTOMATISCH
    }

    private LEDModus modus;
    private int helligkeit;  // 1-5

    public LED() {
        this.support = new PropertyChangeSupport(this);
        this.modus = LEDModus.AUTOMATISCH;
        this.helligkeit = 3;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    // TODO Sprint 2: Implementiere setModus mit Logic
    public void setModus(LEDModus modus) {
        LEDModus old = this.modus;
        this.modus = modus;
        support.firePropertyChange(PROP_MODUS, old, modus);
    }

    // TODO Sprint 2: Implementiere setHelligkeit mit Logic
    public void setHelligkeit(int helligkeit) {
        if (helligkeit >= 1 && helligkeit <= 5) {
            int old = this.helligkeit;
            this.helligkeit = helligkeit;
            support.firePropertyChange(PROP_HELLIGKEIT, old, helligkeit);
        }
    }

    public LEDModus getModus() { return modus; }
    public int getHelligkeit() { return helligkeit; }
}

