package test;

import naehmaschine.model.Naehmaschine;
import naehmaschine.model.Stichmuster;
import naehmaschine.model.LED;
import naehmaschine.model.Pedal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vollständige Testklasse für das Nähmaschinen-Projekt.
 * Enthält alle Modul- und Integrationstests aus Sprint 1 und Sprint 2.
 */
class NaehmaschineCompleteTest {

    private Naehmaschine model;

    @BeforeEach
    void setup() {
        model = new Naehmaschine();
    }

    // ========================================
    // SPRINT 1 - MODULTESTS
    // ========================================

    @Test
    @DisplayName("M1: Auswahl eines gültigen Stichmusters")
    void testSetStichmusterValid() {
        model.setStichmuster(5);
        Stichmuster muster = model.getAktuellesStichmuster();

        assertEquals(5, muster.getNummer(), "Musternummer sollte 5 sein");
        assertEquals("Blindstich", muster.getName(), "Mustername sollte 'Blindstich' sein");
    }

    @Test
    @DisplayName("M2: Änderung der Stichlänge innerhalb gültigem Bereich")
    void testSetStichlaengeValid() {
        Stichmuster muster = model.getAktuellesStichmuster();
        muster.setStichlaenge(3.0);

        assertEquals(3.0, muster.getStichlaenge(), 0.01,
                "Stichlänge sollte 3.0 mm sein");
    }

    @Test
    @DisplayName("M3: Versuch, Stichbreite außerhalb gültigem Bereich zu setzen")
    void testSetStichbreiteInvalid() {
        Stichmuster muster = model.getAktuellesStichmuster();
        muster.setStichbreite(4.5);

        muster.setStichbreite(10.0);

        assertEquals(4.5, muster.getStichbreite(), 0.01,
                "Stichbreite sollte bei 4.5 mm bleiben (ungültiger Wert ignoriert)");
    }

    // ========================================
    // SPRINT 1 - INTEGRATIONSTESTS
    // ========================================

    @Test
    @DisplayName("I1: DrehradPanel → Model setzt Stichmuster")
    void testDrehradPanelSetsStichmuster() {
        model.setStichmuster(2);

        assertEquals("Zickzack", model.getAktuellesStichmuster().getName(),
                "Stichmuster sollte 'Zickzack' sein");
    }

    @Test
    @DisplayName("I2: DrehradPanel → Stichlänge ändern")
    void testDrehradPanelSetsStichlange() {
        Stichmuster muster = model.getAktuellesStichmuster();
        muster.setStichlaenge(4.0);

        assertEquals(4.0, muster.getStichlaenge(), 0.01,
                "Stichlänge sollte auf 4.0 mm gesetzt sein");
    }

    @Test
    @DisplayName("I3: Controller → DisplayPanel bei Musterwechsel")
    void testControllerUpdatesStichmuster() {
        model.setStichmuster(13);
        Stichmuster muster = model.getAktuellesStichmuster();

        assertEquals(13, muster.getNummer(), "Musternummer sollte 13 sein");
        assertEquals("Blumenstich", muster.getName(), "Mustername sollte 'Blumenstich' sein");
    }

    // ========================================
    // SPRINT 2 - MODULTESTS
    // ========================================

    @Test
    @DisplayName("M4: Pedal - Geschwindigkeitsberechnung aus Pedalstellung")
    void testPedalGeschwindigkeitsberechnung() {
        Pedal pedal = model.getPedal();

        pedal.setPosition(0.5);

        assertEquals(550.0, pedal.getGeschwindigkeit(), 5.0,
                "Bei 50% Pedalstellung sollte Geschwindigkeit ~550 U/min sein");

        pedal.setPosition(0.0);
        assertEquals(0.0, pedal.getGeschwindigkeit(), 0.1,
                "Bei 0% Pedalstellung sollte Geschwindigkeit 0 U/min sein");

        pedal.setPosition(1.0);
        assertEquals(1100.0, pedal.getGeschwindigkeit(), 0.1,
                "Bei 100% Pedalstellung sollte Geschwindigkeit 1100 U/min sein");
    }

    @Test
    @DisplayName("M4-Zusatz: Pedal - Max. Geschwindigkeit nicht überschreiten")
    void testPedalMaxGeschwindigkeit() {
        Pedal pedal = model.getPedal();

        pedal.setPosition(1.5);

        assertTrue(pedal.getGeschwindigkeit() <= 1100.0,
                "Geschwindigkeit darf 1100 U/min nicht überschreiten");
    }

    @Test
    @DisplayName("M5: LED - Helligkeitsmapping (1-5)")
    void testLEDHelligkeitMapping() {
        LED led = model.getLED();

        led.setHelligkeit(3);
        assertEquals(3, led.getHelligkeit(), "Helligkeit sollte 3 sein");

        led.setHelligkeit(7);
        assertTrue(led.getHelligkeit() <= 5 && led.getHelligkeit() >= 1,
                "Helligkeit sollte auf gültigen Bereich (1-5) begrenzt sein");

        led.setHelligkeit(3);
        led.setHelligkeit(-1);
        assertTrue(led.getHelligkeit() >= 1,
                "Helligkeit sollte nicht unter 1 fallen");
    }

    @Test
    @DisplayName("M6: Fadenspannung - Wertebereich (1-9)")
    void testFadenspannungWertebereich() {
        model.setFadenspannung(5.0);
        assertEquals(5.0, model.getFadenspannung(), 0.01,
                "Fadenspannung sollte 5 sein");

        model.setFadenspannung(-1.0);
        assertTrue(model.getFadenspannung() >= 1.0,
                "Fadenspannung sollte nicht negativ sein");

        model.setFadenspannung(5.0);
        model.setFadenspannung(15.0);
        assertTrue(model.getFadenspannung() <= 9.0,
                "Fadenspannung sollte nicht über 9 liegen");
    }

    // ========================================
    // SPRINT 2 - INTEGRATIONSTESTS
    // ========================================

    @Test
    @DisplayName("I4: PedalPanel → Naehmaschine → Geschwindigkeit")
    void testPedalPanelSetsGeschwindigkeit() {
        Pedal pedal = model.getPedal();

        model.setPedalPosition(0.75);

        assertEquals(825.0, pedal.getGeschwindigkeit(), 5.0,
                "Bei 75% Pedalstellung sollte Geschwindigkeit ~825 U/min sein");
        assertEquals(825.0, model.getGeschwindigkeit(), 5.0,
                "Model sollte Geschwindigkeit von Pedal übernehmen");
    }

    @Test
    @DisplayName("I4-Zusatz: Pedal Loslassen → Sofortiger Stopp")
    void testPedalReleasedStopsImmediately() {
        model.setPedalPosition(0.8);
        assertTrue(model.getGeschwindigkeit() > 0, "Maschine sollte laufen");

        model.setPedalPosition(0.0);

        assertEquals(0.0, model.getGeschwindigkeit(), 0.01,
                "Geschwindigkeit sollte sofort 0 sein nach Loslassen");
    }

    @Test
    @DisplayName("I5: LED Automatikmodus - Pedal steuert LED")
    void testLEDAutomatikModusWithPedal() {
        LED led = model.getLED();
        led.setModus(LED.LEDModus.AUTOMATISCH);
        led.setHelligkeit(4);

        model.setPedalPosition(0.0);
        assertFalse(shouldLEDBeActive(led, model),
                "LED sollte im Automatikmodus ohne Pedaldruck aus sein");

        model.setPedalPosition(0.6);
        assertTrue(shouldLEDBeActive(led, model),
                "LED sollte im Automatikmodus bei Pedaldruck an sein");

        model.setPedalPosition(0.0);
        assertFalse(shouldLEDBeActive(led, model),
                "LED sollte nach Loslassen wieder aus sein");
    }

    @Test
    @DisplayName("I5-Zusatz: LED Modi - Aus, Ein, Automatik")
    void testLEDModi() {
        LED led = model.getLED();

        led.setModus(LED.LEDModus.AUS);
        model.setPedalPosition(1.0);
        assertEquals(LED.LEDModus.AUS, led.getModus(),
                "Modus sollte AUS sein");

        led.setModus(LED.LEDModus.EIN);
        model.setPedalPosition(0.0);
        assertEquals(LED.LEDModus.EIN, led.getModus(),
                "Modus sollte EIN sein");

        led.setModus(LED.LEDModus.AUTOMATISCH);
        assertEquals(LED.LEDModus.AUTOMATISCH, led.getModus(),
                "Modus sollte AUTOMATISCH sein");
    }

    @Test
    @DisplayName("I6: DrehradPanel → Fadenspannung → Display")
    void testDrehradPanelSetsFadenspannung() {
        model.setFadenspannung(7.0);

        assertEquals(7.0, model.getFadenspannung(), 0.01,
                "Fadenspannung sollte auf 7 gesetzt sein");
    }

    // ========================================
    // ZUSÄTZLICHE EDGE-CASE TESTS
    // ========================================

    @Test
    @DisplayName("Edge-Case: Alle Stichmuster durchlaufen")
    void testAlleStichmusterSindVerfuegbar() {
        assertTrue(model.getVerfuegbareMuster().size() >= 10,
                "Mindestens 10 Stichmuster sollten verfügbar sein");
        assertTrue(model.getVerfuegbareMuster().size() <= 20,
                "Maximal 20 Stichmuster sollten verfügbar sein");

        for (int i = 1; i <= model.getVerfuegbareMuster().size(); i++) {
            model.setStichmuster(i);
            assertEquals(i, model.getAktuellesStichmuster().getNummer(),
                    "Muster " + i + " sollte auswählbar sein");
        }
    }

    @Test
    @DisplayName("Edge-Case: Stichlänge Grenzwerte (1.5 - 5.0 mm)")
    void testStichlaengeGrenzwerte() {
        Stichmuster muster = model.getAktuellesStichmuster();

        muster.setStichlaenge(1.5);
        assertEquals(1.5, muster.getStichlaenge(), 0.01);

        muster.setStichlaenge(5.0);
        assertEquals(5.0, muster.getStichlaenge(), 0.01);

        muster.setStichlaenge(1.0);
        assertTrue(muster.getStichlaenge() >= 1.5,
                "Stichlänge sollte nicht unter 1.5 mm sein");

        muster.setStichlaenge(5.0);
        muster.setStichlaenge(6.0);
        assertTrue(muster.getStichlaenge() <= 5.0,
                "Stichlänge sollte nicht über 5.0 mm sein");
    }

    @Test
    @DisplayName("Edge-Case: Stichbreite Grenzwerte (2.5 - 7.0 mm)")
    void testStichbreiteGrenzwerte() {
        Stichmuster muster = model.getAktuellesStichmuster();

        muster.setStichbreite(2.5);
        assertEquals(2.5, muster.getStichbreite(), 0.01);

        muster.setStichbreite(7.0);
        assertEquals(7.0, muster.getStichbreite(), 0.01);

        muster.setStichbreite(1.0);
        assertTrue(muster.getStichbreite() >= 2.5,
                "Stichbreite sollte nicht unter 2.5 mm sein");

        muster.setStichbreite(7.0);
        muster.setStichbreite(10.0);
        assertTrue(muster.getStichbreite() <= 7.0,
                "Stichbreite sollte nicht über 7.0 mm sein");
    }

    // ========================================
    // HILFSMETHODEN
    // ========================================

    private boolean shouldLEDBeActive(LED led, Naehmaschine model) {
        switch (led.getModus()) {
            case AUS:
                return false;
            case EIN:
                return true;
            case AUTOMATISCH:
                return model.getGeschwindigkeit() > 0;
            default:
                return false;
        }
    }
}
