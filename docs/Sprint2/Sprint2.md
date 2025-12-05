# Sprint 1

### Sprint Planung

Ziel: Vervollständigung des Programms

- Restliche requirements einrichten



**Requirements:**

| ** ID **   | ** Titel **                      | ** Beschreibung (Kurz) **                                                                                                | ** Zugehörige Komponenten **                 |
| ---- | -------------------------- | ------------------------------------------------------------------------------------------------------------------ | --------------------------------------- |
| F2.1 | Stufenlose Geschwindigkeit | Nähgeschwindigkeit wird mit dem Fußpedal geregelt und ist proportional zur Pedalstellung.                          | MotorController, InputHandler           |
| F2.2 | Stopp bei Loslassen Pedal  | Maschine stoppt sofort, wenn das Fußpedal losgelassen wird.                                                        | MotorController, SafetyManager          |
| F2.3 | Max. Nähgeschwindigkeit    | Maximale Nähgeschwindigkeit beträgt 0 bis 1100 U/min.                                                              | MotorController                         |
| F3.1 | LED‑Nähbereichsbeleuchtung | Nähbereich der Maschine wird mit einer LED beleuchtet.                                                             | LEDController, DisplayManager           |
| F3.2 | Manuelle LED‑Bedienung     | LED‑Beleuchtung hat 3 Zustände: Aus, Ein, Automatik; im Automatik‑Modus schaltet sich LED bei Pedalbetätigung ein. | LEDController, InputHandler             |
| F3.3 | Helligkeit LED             | LED‑Helligkeit ist in fünf Stufen von 1 (dunkel) bis 5 (hell) einstellbar.                                         | LEDController, DisplayManager           |
| F4.1 | Fadenspannung einstellen   | Fadenspannung ist einstellbar, entweder manuell oder elektronisch.                                                 | ThreadTensionController, InputHandler   |
| F4.3 | Anzeige Fadenspannung      | Aktuelle Fadenspannung wird im Display angezeigt.                                                                  | DisplayManager, ThreadTensionController |

**Sprint-Zeitraum:** Xx.Xx.2025 - Xx.Xx.2025

**Sprintziel:**

1. Es sol eine funktionsfähige Nähmaschine entstehen

### Schritt 2: Architektur

[Architektur](Architektur1.md)

### Schritt 3: Design

[Design](Design1.md)

### Schritt 4: Implementierung

[Implementierung](Implementierung1.md)

### Schritt 5: Test

[Test](Test1.md)

### Schritt 6: Review & Retro
