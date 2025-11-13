package naehmaschine.view;

import javax.swing.*;
import java.awt.*;
import naehmaschine.model.Stichmuster;
import naehmaschine.model.LED;

/**
 * Hauptfenster der Nähmaschinen-GUI.
 * Sprint 1: Display und Drehrad für Stichmuster/Länge/Breite
 * Sprint 2 (TODO): LED, Pedal, Naehflaeche
 */
public class NaehmaschineView extends JFrame {

    // GUI-Komponenten
    private DisplayPanel displayPanel;
    private DrehradPanel drehradPanel;
    // TODO Sprint 2: private PedalPanel pedalPanel;
    // TODO Sprint 2: private LEDPanel ledPanel;
    // TODO Sprint 2: private Naehflaeche naehflaeche;

    // Listener Interfaces
    private DrehradListener drehradListener;
    // TODO Sprint 2: private PedalListener pedalListener;

    /**
     * Konstruktor - Erstellt das GUI-Layout.
     */
    public NaehmaschineView() {
        super("Nähmaschinen-Simulator (Sprint 1)");
        initializeComponents();
        setupLayout();
        setupFrame();
    }

    /**
     * Initialisiert alle GUI-Komponenten.
     * Sprint 1: Display, Drehrad
     */
    private void initializeComponents() {
        displayPanel = new DisplayPanel();
        drehradPanel = new DrehradPanel();
        // TODO Sprint 2: pedalPanel = new PedalPanel();
        // TODO Sprint 2: ledPanel = new LEDPanel();
        // TODO Sprint 2: naehflaeche = new Naehflaeche();
    }

    /**
     * Erstellt das Layout mit allen Komponenten.
     */
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));

        // Header
        JLabel titleLabel = new JLabel("Nähmaschinen-Simulator (Sprint 1)",
                SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Zentrum: Display
        add(displayPanel, BorderLayout.CENTER);

        // Rechts: Drehrad-Steuerung
        add(drehradPanel, BorderLayout.EAST);

        // TODO Sprint 2: LED und Nähfläche hinzufügen
        // TODO Sprint 2: Pedal hinzufügen

        // Padding
        ((JPanel)getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    /**
     * Konfiguriert das JFrame.
     */
    private void setupFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // Listener Interfaces (vollständig definiert für Sprint 2)
    public interface DrehradListener {
        void onStichmusterChanged(int nummer);
        void onStichlaengeChanged(double laenge);
        void onStichbreiteChanged(double breite);
        void onFadenspannungChanged(double spannung);
        void onLEDHelligkeitChanged(int helligkeit);
        void onLEDModusChanged(LED.LEDModus modus);
    }

    // TODO Sprint 2: PedalListener Interface
    /*
    public interface PedalListener {
        void onPedalPressed(double position);
        void onPedalReleased();
    }
    */

    // Setter für Listener
    public void setDrehradListener(DrehradListener listener) {
        this.drehradListener = listener;
        drehradPanel.setDrehradListener(listener);
    }

    // TODO Sprint 2:
    /*
    public void setPedalListener(PedalListener listener) {
        this.pedalListener = listener;
        pedalPanel.setPedalListener(listener);
    }
    */

    // Update-Methoden (Sprint 1: Implementiert)
    public void updateStichmusterAnzeige(Stichmuster muster) {
        displayPanel.updateStichmuster(muster);
        // TODO Sprint 2: naehflaeche.setStichmuster(muster);
    }

    public void updateStichlaengeAnzeige(double laenge) {
        displayPanel.updateStichlaenge(laenge);
    }

    public void updateStichbreiteAnzeige(double breite) {
        displayPanel.updateStichbreite(breite);
    }

    // TODO Sprint 2: Update-Methoden für weitere Features
    /*
    public void updateFadenspannungAnzeige(double spannung) {
        displayPanel.updateFadenspannung(spannung);
    }

    public void updateGeschwindigkeitAnzeige(double geschwindigkeit) {
        displayPanel.updateGeschwindigkeit(geschwindigkeit);
        naehflaeche.setGeschwindigkeit(geschwindigkeit);
    }

    public void updateLEDModus(LED.LEDModus modus) {
        ledPanel.setModus(modus);
    }

    public void updateLEDHelligkeit(int helligkeit) {
        ledPanel.setHelligkeit(helligkeit);
    }

    public void updateSewingAnimation(boolean active) {
        if (active) {
            naehflaeche.startSewing();
        } else {
            naehflaeche.stopSewing();
        }
    }
    */
}
