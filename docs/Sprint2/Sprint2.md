# Sprint 2

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

Was lief gut?

Die Zusammenarbeit im Team hat gut funktioniert, Rückfragen konnten schnell geklärt werden.

Die Aufteilung der Aufgaben nach Themenbereichen (UI, Logik, Tests) hat geholfen, Überschneidungen zu vermeiden.

Code Reviews wurden regelmäßig durchgeführt und haben früh auf mögliche Designprobleme hingewiesen.

Kleine, häufige Commits haben die Nachverfolgung von Änderungen vereinfacht.


Was lief nicht so gut?

Schätzungen für einige Stories waren zu optimistisch, wodurch gegen Ende des Sprints Zeitdruck entstanden ist.

Die Kommunikation zu Abhängigkeiten zwischen Modulen war teilweise unklar, was zu Wartezeiten geführt hat.

Nicht alle Tests wurden automatisiert, einige manuelle Tests haben viel Zeit in Anspruch genommen.

Es gab kaum technische Spikes, sodass Entscheidungen zu Architekturfragen teilweise spontan getroffen werden mussten.


Was werde ich im nächsten Sprint anders machen?

Die Aufwandsschätzungen werden konservativer angesetzt und Pufferzeiten eingeplant.

Abhängigkeiten zwischen Stories werden vor Sprintstart explizit identifiziert und im Board sichtbar gemacht.

Der Anteil automatisierter Tests soll steigen, damit Regressionen schneller erkannt werden.

Für größere technische Fragen werden kurze Spikes geplant, um gezielt Lösungen zu evaluieren, bevor implementiert wird.
