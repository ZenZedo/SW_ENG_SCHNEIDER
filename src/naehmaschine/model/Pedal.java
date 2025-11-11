package naehmaschine.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Modellklasse für das Fußpedal.
 *
 * Requirements:
 * F2.1: Stufenlose Geschwindigkeitssteuerung
 * F2.2: Sofortiger Stopp beim Loslassen
 * F2.3: 0-1100 U/min
 */
public class Pedal {

    public static final String PROP_GESCHWINDIGKEIT = "geschwindigkeit";
    private static final double MAX_GESCHWINDIGKEIT = 1100.0;

    private final PropertyChangeSupport support;
    private double position;  // 0.0 - 1.0

    public Pedal() {
        this.support = new PropertyChangeSupport(this);
        this.position = 0.0;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    /**
     * F2.1: Pedalposition setzen (0.0 = nicht gedrückt, 1.0 = voll gedrückt).
     * Geschwindigkeit ist proportional zur Pedalstellung.
     */
    public void setPosition(double position) {
        if (position >= 0.0 && position <= 1.0) {
            double oldSpeed = getGeschwindigkeit();
            this.position = position;
            double newSpeed = getGeschwindigkeit();
            support.firePropertyChange(PROP_GESCHWINDIGKEIT, oldSpeed, newSpeed);
        }
    }

    /**
     * F2.3: Berechnet Geschwindigkeit (0-1100 U/min) proportional zur Position.
     */
    public double getGeschwindigkeit() {
        return position * MAX_GESCHWINDIGKEIT;
    }

    public double getPosition() { return position; }
}
