package naehmaschine.view;

import javax.swing.*;
import java.awt.*;
import naehmaschine.model.Stichmuster;
import naehmaschine.model.LED;

/**
 * Hauptfenster der Nähmaschinen-GUI.
 * Verwendet JavaFX-ähnliche Struktur mit Swing.
 */
public class NaehmaschineView extends JFrame {

    // GUI-Komponenten
    private DisplayPanel displayPanel;
    private DrehradPanel drehradPanel;
    private PedalPanel pedalPanel;
    private LEDPanel ledPanel;
    private Naehflaeche naehflaeche;

    // Listener Interfaces
    private DrehradListener drehradListener;
    private PedalListener pedalListener;

    /**
     * Konstruktor - Erstellt das GUI-Layout.
     */
    public NaehmaschineView() {
        super("Nähmaschinen-Simulator");
        initializeComponents();
        setupLayout();
        setupFrame();
    }

    /**
     * Initialisiert alle GUI-Komponenten.
     */
    private void initializeComponents() {
        displayPanel = new DisplayPanel();
        drehradPanel = new DrehradPanel();
        pedalPanel = new PedalPanel();
        ledPanel = new LEDPanel();
        naehflaeche = new Naehflaeche();
    }

    /**
     * Erstellt das Layout mit allen Komponenten.
     */
    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));

        // Header mit Titel und LED
        JPanel headerPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Nähmaschinen-Simulator",
                SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(titleLabel, BorderLayout.CENTER);
        headerPanel.add(ledPanel, BorderLayout.EAST);
        add(headerPanel, BorderLayout.NORTH);

        // Zentrum: Display und Nähfläche
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.add(displayPanel, BorderLayout.NORTH);
        centerPanel.add(naehflaeche, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // Rechts: Drehrad-Steuerung
        add(drehradPanel, BorderLayout.EAST);

        // Unten: Pedal
        add(pedalPanel, BorderLayout.SOUTH);

        // Padding
        ((JPanel)getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    /**
     * Konfiguriert das JFrame.
     */
    private void setupFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // Listener Interfaces
    public interface DrehradListener {
        void onStichmusterChanged(int nummer);
        void onStichlaengeChanged(double laenge);
        void onStichbreiteChanged(double breite);
        void onFadenspannungChanged(double spannung);
        void onLEDHelligkeitChanged(int helligkeit);
        void onLEDModusChanged(LED.LEDModus modus);
    }

    public interface PedalListener {
        void onPedalPressed(double position);
        void onPedalReleased();
    }

    // Setter für Listener
    public void setDrehradListener(DrehradListener listener) {
        this.drehradListener = listener;
        drehradPanel.setDrehradListener(listener);
    }


    public void updateLEDAktiv(boolean aktiv) {
        ledPanel.setAktiv(aktiv);
    }


    public void setPedalListener(PedalListener listener) {
        this.pedalListener = listener;
        pedalPanel.setPedalListener(listener);
    }

    // Update-Methoden (werden vom Controller aufgerufen)
    public void updateStichmusterAnzeige(Stichmuster muster) {
        displayPanel.updateStichmuster(muster);
        naehflaeche.setStichmuster(muster);
    }

    public void updateStichlaengeAnzeige(double laenge) {
        displayPanel.updateStichlaenge(laenge);
    }

    public void updateStichbreiteAnzeige(double breite) {
        displayPanel.updateStichbreite(breite);
    }

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
}

