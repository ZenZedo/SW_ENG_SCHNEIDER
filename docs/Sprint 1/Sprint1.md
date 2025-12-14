# Sprint 1

### Sprint Planung

Ziel: Entwicklung des Grundbausteins

- Interface einrichten

- Stichpatternmanager entwickeln

- Systemcontroller entwickeln

- Input Handler für grundbausteine entwickeln



**Requirements:**

| **ID**   | **Titel**               | **Beschreibung (Kurz)**                                         | **Zugehörige Komponenten**                               |
| -------- | ----------------------- | --------------------------------------------------------------- | -------------------------------------------------------- |
| **F1.1** | Stichmuster             | Maschine hat 10–20 verschiedene Stichmuster.                    | `StitchPatternManager`                                   |
| **F1.2** | Auswahl SM              | Stichmuster müssen über ein Drehrad auswählbar sein.            | `InputHandler`, `StitchPatternManager`, `DisplayManager` |
| **F1.3** | Voreinstellung          | Jedes Stichmuster hat Parameter (Länge, Breite, Nadelposition). | `SystemController`, `StitchPatternManager`               |
| **F1.4** | Anzeige SM              | Aktuell gewähltes Stichmuster soll im Display angezeigt werden. | `DisplayManager`, `StitchPatternManager`                 |
| **F5.1** | Stichlänge              | Einstellbar im Bereich 1.5–5 mm.                                | `InputHandler`, `StitchPatternManager`                   |
| **F5.2** | Stichbreite             | Einstellbar im Bereich 2.5–7 mm.                                | `InputHandler`, `StitchPatternManager`                   |
| **F5.3** | Länge/Breite Anzeige    | Aktuelle Werte im Display anzeigen.                             | `DisplayManager`, `StitchPatternManager`                 |

**Sprint-Zeitraum:** Xx.Xx.2025 - Xx.Xx.2025

**Sprintziel:**

1. Die Voreinstellungen für die Stichmuster sollen über das Bedienelement eingestellt werden können.
2. Das Gerät soll eine Funktionierende Anzeige haben.

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
Alle Kernanforderungen an die Nähmaschine (Stichmuster, Pedal, LED, Fadenspannung) konnten implementiert werden.

Die frühzeitige Beschäftigung mit den fachlichen Anforderungen (Sticharten, Wertebereiche, LED-Modi) hat geholfen, das Datenmodell sinnvoll zu strukturieren.

Die Testabdeckung ist gut: Modultests für Stichmuster, Pedal, LED und Naehmaschine sowie Integrationstests über das Modell hinweg.

Die Trennung in Modellklassen (z.B. Naehmaschine, Stichmuster, Pedal, LED) hat die Implementierung übersichtlicher gemacht.

Die Geschwindigkeitsskalierung über das Pedal sowie die LED-Automatik in Abhängigkeit von der Nähgeschwindigkeit funktionieren wie geplant.

Was lief nicht so gut?
Das ursprüngliche Klassendiagramm zur Nähmaschine musste im Verlauf mehrfach überarbeitet werden, weil neue Zusammenhänge (z.B. LED-Automatikmodus, Pedal → Geschwindigkeit → LED) erst beim Implementieren klar wurden.

Es gab am Anfang keinen klaren Startpunkt: Modell, GUI-Sicht und Tests wurden teilweise parallel gedacht, statt zuerst das Domänenmodell sauber zu definieren.

Die Wertebereiche (z.B. Stichlänge, Stichbreite, Fadenspannung) mussten an mehreren Stellen nachjustiert werden, weil sie nicht von Anfang an konsequent validiert wurden.

Einige Tools und IDE-Einstellungen (z.B. Testkonfiguration, Code-Formatierung, Metriken) wurden erst mitten im Sprint angepasst, was zu kleineren Reibungsverlusten führte.

Die Dokumentation (insbesondere die erste Version des Klassendiagramms und die Beschreibung der LED-Modi) wurde nicht immer direkt bei Änderungen aktualisiert und hinkt stellenweise hinterher.

Was werde ich im nächsten Sprint anders machen?
Zu Beginn des Sprints werde ich das Domänenmodell der Nähmaschine (Stichmuster, Pedal, LED, Fadenspannung, Zustände) klarer definieren und erst danach in die Implementierung gehen.

Ich werde das Klassendiagramm und die technische Dokumentation parallel zur Entwicklung pflegen, damit Design-Entscheidungen nachvollziehbar bleiben.

Die Entwicklung wird stärker feature-orientiert strukturiert (z.B. zuerst „Stichmusterverwaltung“, dann „Pedal & Geschwindigkeit“, dann „LED & Automatikmodus“), statt zu viele Aspekte gleichzeitig anzufangen.

Die Tool-Chain (IDE, Test-Setup, eventuell Code-Analyse) werde ich vor Sprintstart stabil festlegen und im Sprint möglichst nicht mehr wechseln.

Für neue Anforderungen (z.B. weitere Stichmuster oder zusätzliche LED-Zustände) werde ich frühzeitig Erweiterungspunkte im Design vorsehen, um spätere Anpassungen zu erleichtern.

Lessons Learned
Ein sauberes, durchdachtes Modell der Nähmaschine spart später viele Refactorings, besonders wenn mehrere Komponenten (Pedal, LED, Stichmuster, Fadenspannung) gegenseitig voneinander abhängen.

Klare Wertebereiche und Validierungen (z.B. für Stichlänge, Stichbreite, Fadenspannung, Pedalposition) sollten früh definiert und in Tests abgedeckt werden, um Fehlbedienung und Inkonsistenzen zu vermeiden.

Automatikfunktionen wie der LED-Automatikmodus profitieren davon, früh mit realistischen Szenarien (Pedal gedrückt/losgelassen, Maschine steht/läuft) durchdacht zu werden.

Barrierefreiheit spielt auch bei einer Nähmaschine eine Rolle: Statusanzeigen (z.B. LED-Helligkeit oder Farbzustände) sollten so gestaltet sein, dass sie auch von Personen mit Farbsehschwächen verstanden werden können.

Kontinuierliche Tests (Unit- und Integrationstests) geben Sicherheit bei Refactorings, insbesondere wenn sich das Klassendiagramm im Laufe der Entwicklung noch verändert.

