package test;

import naehmaschine.model.Naehmaschine;
import naehmaschine.model.Stichmuster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NaehmaschineSprint1Test {

    private Naehmaschine model;

    @BeforeEach
    void setup() {
        model = new Naehmaschine();
    }

    // Modultest M1: Auswahl eines gültigen Stichmusters
    @Test
    void testSetStichmusterValid() {
        model.setStichmuster(5);  // Index 5 = Blindstich
        Stichmuster muster = model.getAktuellesStichmuster();
        assertEquals(5, muster.getNummer());
        assertEquals("Blindstich", muster.getName());
    }

    // Modultest M2: Änderung der Stichlänge innerhalb gültigem Bereich
    @Test
    void testSetStichlaengeValid() {
        Stichmuster muster = model.getAktuellesStichmuster();
        muster.setStichlaenge(3.0);
        assertEquals(3.0, muster.getStichlaenge());
    }

    // Modultest M3: Versuch, Stichbreite außerhalb gültigem Bereich zu setzen
    @Test
    void testSetStichbreiteInvalid() {
        Stichmuster muster = model.getAktuellesStichmuster();
        muster.setStichbreite(4.5);
        muster.setStichbreite(10.0); // ungültig!
        // Wert bleibt 4.5
        assertEquals(4.5, muster.getStichbreite());
    }

    // Integrationstest I1: DrehradPanel → Model (hier simuliert)
    @Test
    void testDrehradPanelAufrufSetztStichmuster() {
        // Simuliere: User dreht Drehrad auf Muster Nr. 2 (Zickzack)
        model.setStichmuster(2);
        assertEquals("Zickzack", model.getAktuellesStichmuster().getName());
        // Display-Anzeige würde zur Model-Änderung passen – GUI Test separat
    }

    // Integrationstest I2: DrehradPanel → Stichlänge ändern
    @Test
    void testDrehradPanelSetztStichlaenge() {
        // Simuliere: User dreht im Modus „Stichlänge“ auf 4.0 mm
        Stichmuster muster = model.getAktuellesStichmuster();
        muster.setStichlaenge(4.0);
        assertEquals(4.0, muster.getStichlaenge());
        // DisplayPanel synchronisiert via PropertyChange (manuell geprüft)
    }

    // Integrationstest I3: Controller → DisplayPanel (durch Model-Änderung)
    @Test
    void testControllerUpdatesDisplayBeiMusterWechsel() {
        // Simuliere: Controller ruft setStichmuster(13)
        model.setStichmuster(13);
        Stichmuster muster = model.getAktuellesStichmuster();
        assertEquals(13, muster.getNummer());
        assertEquals("Blumenstich", muster.getName());
        // Ein echter Integrationstest würde den View/Display-Update prüfen
    }
}

