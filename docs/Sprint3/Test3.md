Die Sprint‑2‑Tests können so in Markdown dokumentiert werden:

## Dokumentation der Testfälle (Sprint 2)

Es werden nur Requirements getestet, die in Sprint 1 noch nicht behandelt wurden (F2.x, F3.x, F4.x).

## Modul-Testfälle

**M4 – Pedal: Geschwindigkeitsberechnung aus Pedalstellung (F2.1, F2.3)**  
- **Komponente:** `Pedal` (Model)  
- **Ziel:** Berechnung einer Drehzahl im Bereich 0–1100 U/min aus der Pedalstellung.  
- **Eingang:** `setPosition(0.5)`  
- **Erwartet:** `getGeschwindigkeit()` ≈ 550 U/min (Toleranz ±5 U/min).  
- **Status:** Noch nicht durchgeführt (Sprint 2 geplant).

**M5 – LED: Helligkeitsmapping (F3.3)**  
- **Komponente:** `LED` (Model)  
- **Ziel:** Helligkeitsstufe 1–5 korrekt übernehmen, Werte außerhalb des Bereichs begrenzen oder ignorieren.  
- **Eingang:** `setHelligkeit(3)`; danach `setHelligkeit(7)`.  
- **Erwartet:**  
  - Nach `3`: `getHelligkeit() == 3`.  
  - Nach `7`: Wert bleibt 3 oder wird auf 5 gecappt (je nach Designentscheidung).  
- **Status:** Noch nicht durchgeführt (Sprint 2 geplant).

**M6 – Fadenspannung: Wertebereich (F4.1)**  
- **Komponente:** `Naehmaschine` (Fadenspannungs-Attribut im Model)  
- **Ziel:** Nur definierte Spannungswerte (z. B. 1–9) akzeptieren, ungültige Werte abweisen.  
- **Eingang:** `setFadenspannung(5)`; danach `setFadenspannung(-1)`.  
- **Erwartet:**  
  - Nach `5`: `getFadenspannung() == 5`.  
  - Nach `-1`: Wert bleibt 5; kein Fehler/Absturz.  
- **Status:** Noch nicht durchgeführt (Sprint 2 geplant).

## Integrations testfälle

**I4 – PedalPanel → Naehmaschine → Geschwindigkeit im Display (F2.1, F2.3)**  
- **Komponenten:** `PedalPanel`, `NaehmaschineController`, `Naehmaschine`, `DisplayPanel`  
- **Ziel:** Änderung der Pedalstellung über das UI setzt die Geschwindigkeit im Model und zeigt sie im Display an.  
- **Schritte/Eingang:**  
  1. Im UI Pedal auf 75 % drücken (`onPedalPressed(0.75)`).  
  2. Controller ruft `model.setPedalPosition(0.75)`.  
- **Erwartet:**  
  - `model.getPedal().getGeschwindigkeit()` ≈ 825 U/min.  
  - `DisplayPanel` zeigt etwa 825 U/min an.  
- **Status:** Noch nicht durchgeführt (Sprint 2 geplant).

**I5 – LED Automatikmodus: Pedal steuert LEDPanel (F3.1, F3.2, F3.3)**  
- **Komponenten:** `LED`, `Naehmaschine`, `NaehmaschineController`, `LEDPanel`, `PedalPanel`  
- **Ziel:** Im Modus „AUTOMATISCH“ leuchtet die LED nur bei gedrücktem Pedal und berücksichtigt die Helligkeitsstufe.  
- **Schritte/Eingang:**  
  1. `model.getLED().setModus(AUTOMATISCH)` und `setHelligkeit(4)`.  
  2. Pedal drücken: `onPedalPressed(0.6)` → Controller ruft `view.updateLEDAktiv(true)`.  
  3. Pedal loslassen: `onPedalReleased()` → Controller ruft `view.updateLEDAktiv(false)`.  
- **Erwartet:**  
  - Während gedrückt: LEDPanel zeigt leuchtende LED mit Helligkeit 4.  
  - Nach Loslassen: LEDPanel zeigt LED aus.  
- **Status:** Noch nicht durchgeführt (Sprint 2 geplant).

**I6 – DrehradPanel → Fadenspannung → DisplayPanel (F4.1, F4.3)**  
- **Komponenten:** `DrehradPanel`, `NaehmaschineController`, `Naehmaschine`, `DisplayPanel`  
- **Ziel:** Änderung der Fadenspannung über das Drehrad wird im Model gesetzt und im Display angezeigt.  
- **Schritte/Eingang:**  
  1. Drehrad in Modus „Fadenspannung“ schalten.  
  2. Wert auf Stufe 7 drehen → `onFadenspannungChanged(7)` im Controller.  
- **Erwartet:**  
  - `model.getFadenspannung() == 7`.  
  - `DisplayPanel` zeigt Fadenspannung 7 an.  
- **Status:** Noch nicht durchgeführt (Sprint 2 geplant).
