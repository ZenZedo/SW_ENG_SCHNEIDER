package naehmaschine.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * Hauptmodell der Nähmaschine.
 * Verwendet das Observer Pattern (PropertyChangeSupport) um Views zu benachrichtigen.
 *
 * Requirements:
 * F1.1-F1.4: Stichmuster (10-20 verschiedene)
 * F2.1-F2.3: Geschwindigkeitssteuerung
 * F3.1-F3.3: LED-Steuerung
 * F4.1, F4.3: Fadenspannung
 * F5.1-F5.3: Stichlänge und -breite
 */
public class Naehmaschine {

    // Property names für Observer Pattern
    public static final String PROP_STICHMUSTER = "stichmuster";
    public static final String PROP_GESCHWINDIGKEIT = "geschwindigkeit";
    public static final String PROP_STICHLAENGE = "stichlaenge";
    public static final String PROP_STICHBREITE = "stichbreite";
    public static final String PROP_FADENSPANNUNG = "fadenspannung";
    public static final String PROP_LED_MODUS = "ledModus";
    public static final String PROP_LED_HELLIGKEIT = "ledHelligkeit";
    public static final String PROP_SEWING_ACTIVE = "sewingActive";

    private final PropertyChangeSupport support;

    // Komponenten
    private final List<Stichmuster> verfuegbareMuster;
    private Stichmuster aktuellesStichmuster;
    private final LED led;
    private final Pedal pedal;
    private double fadenspannung;  // 1-9
    private boolean sewingActive;

    /**
     * Konstruktor - Initialisiert alle Stichmuster und Komponenten.
     */
    public Naehmaschine() {
        this.support = new PropertyChangeSupport(this);
        this.verfuegbareMuster = new ArrayList<>();
        this.led = new LED();
        this.pedal = new Pedal();
        this.fadenspannung = 5.0;
        this.sewingActive = false;

        // F1.1: 15 verschiedene Stichmuster initialisieren
        initializeStichmuster();

        // Erstes Muster als Standard wählen
        aktuellesStichmuster = verfuegbareMuster.get(0);

        // LED Observer hinzufügen
        led.addPropertyChangeListener(evt ->
                support.firePropertyChange(evt.getPropertyName(),
                        evt.getOldValue(),
                        evt.getNewValue()));

        // Pedal Observer hinzufügen
        pedal.addPropertyChangeListener(evt -> {
            support.firePropertyChange(PROP_GESCHWINDIGKEIT,
                    evt.getOldValue(),
                    evt.getNewValue());

            // F3.2: Bei Automatik-Modus LED einschalten
            if (led.getModus() == LED.LEDModus.AUTOMATISCH) {
                boolean pedalAktiv = (double)evt.getNewValue() > 0;
                if (pedalAktiv != sewingActive) {
                    setSewingActive(pedalAktiv);
                }
            }
        });
    }

    /**
     * F1.1: Initialisiert 15 verschiedene Stichmuster.
     */
    private void initializeStichmuster() {
        verfuegbareMuster.add(new Stichmuster(1, "Geradstich", 2.5, 0.0,
                Stichmuster.Nadelposition.MITTE));
        verfuegbareMuster.add(new Stichmuster(2, "Zickzack", 2.0, 5.0,
                Stichmuster.Nadelposition.MITTE));
        verfuegbareMuster.add(new Stichmuster(3, "Dreifach-Geradstich", 2.5, 0.0,
                Stichmuster.Nadelposition.MITTE));
        verfuegbareMuster.add(new Stichmuster(4, "Elastischer Zickzack", 1.5, 5.5,
                Stichmuster.Nadelposition.MITTE));
        verfuegbareMuster.add(new Stichmuster(5, "Blindstich", 2.0, 3.0,
                Stichmuster.Nadelposition.LINKS));
        verfuegbareMuster.add(new Stichmuster(6, "Überwendlingstich", 2.5, 5.0,
                Stichmuster.Nadelposition.RECHTS));
        verfuegbareMuster.add(new Stichmuster(7, "Knopflochstich", 2.0, 5.0,
                Stichmuster.Nadelposition.MITTE));
        verfuegbareMuster.add(new Stichmuster(8, "Federstich", 3.0, 4.0,
                Stichmuster.Nadelposition.MITTE));
        verfuegbareMuster.add(new Stichmuster(9, "Hexenstich", 2.5, 4.5,
                Stichmuster.Nadelposition.MITTE));
        verfuegbareMuster.add(new Stichmuster(10, "Kreuzstich", 3.0, 3.0,
                Stichmuster.Nadelposition.MITTE));
        verfuegbareMuster.add(new Stichmuster(11, "Muschelstich", 2.0, 6.0,
                Stichmuster.Nadelposition.MITTE));
        verfuegbareMuster.add(new Stichmuster(12, "Wellenstich", 2.5, 5.5,
                Stichmuster.Nadelposition.MITTE));
        verfuegbareMuster.add(new Stichmuster(13, "Blumenstich", 3.0, 5.0,
                Stichmuster.Nadelposition.MITTE));
        verfuegbareMuster.add(new Stichmuster(14, "Sternstich", 2.5, 4.5,
                Stichmuster.Nadelposition.MITTE));
        verfuegbareMuster.add(new Stichmuster(15, "Rautenstich", 3.0, 4.0,
                Stichmuster.Nadelposition.MITTE));
    }

    // Observer Pattern Methoden
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    /**
     * F1.2, F1.3: Stichmuster auswählen und Parameter laden.
     */
    public void setStichmuster(int nummer) {
        if (nummer >= 1 && nummer <= verfuegbareMuster.size()) {
            Stichmuster old = this.aktuellesStichmuster;
            this.aktuellesStichmuster = verfuegbareMuster.get(nummer - 1);
            support.firePropertyChange(PROP_STICHMUSTER, old, aktuellesStichmuster);

            // Parameter des Musters automatisch übernehmen
            support.firePropertyChange(PROP_STICHLAENGE,
                    old.getStichlaenge(),
                    aktuellesStichmuster.getStichlaenge());
            support.firePropertyChange(PROP_STICHBREITE,
                    old.getStichbreite(),
                    aktuellesStichmuster.getStichbreite());
        }
    }

    /**
     * F5.1: Stichlänge einstellen (1.5-5.0 mm).
     */
    public void setStichlaenge(double laenge) {
        if (laenge >= 1.5 && laenge <= 5.0) {
            double old = aktuellesStichmuster.getStichlaenge();
            aktuellesStichmuster.setStichlaenge(laenge);
            support.firePropertyChange(PROP_STICHLAENGE, old, laenge);
        }
    }

    /**
     * F5.2: Stichbreite einstellen (2.5-7.0 mm).
     */
    public void setStichbreite(double breite) {
        if (breite >= 2.5 && breite <= 7.0) {
            double old = aktuellesStichmuster.getStichbreite();
            aktuellesStichmuster.setStichbreite(breite);
            support.firePropertyChange(PROP_STICHBREITE, old, breite);
        }
    }

    /**
     * F4.1: Fadenspannung einstellen.
     */
    public void setFadenspannung(double spannung) {
        if (spannung >= 1.0 && spannung <= 9.0) {
            double old = this.fadenspannung;
            this.fadenspannung = spannung;
            support.firePropertyChange(PROP_FADENSPANNUNG, old, spannung);
        }
    }

    /**
     * F2.1: Geschwindigkeit über Pedal setzen (0-1100 U/min).
     */
    public void setPedalPosition(double position) {
        pedal.setPosition(position);
    }

    private void setSewingActive(boolean active) {
        boolean old = this.sewingActive;
        this.sewingActive = active;
        support.firePropertyChange(PROP_SEWING_ACTIVE, old, active);
    }

    // Getter
    public Stichmuster getAktuellesStichmuster() { return aktuellesStichmuster; }
    public double getFadenspannung() { return fadenspannung; }
    public double getGeschwindigkeit() { return pedal.getGeschwindigkeit(); }
    public LED getLED() { return led; }
    public Pedal getPedal() { return pedal; }
    public List<Stichmuster> getVerfuegbareMuster() {
        return new ArrayList<>(verfuegbareMuster);
    }
    public boolean isSewingActive() { return sewingActive; }
}

