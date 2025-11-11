## Traceability - Matrix

| **ID**   | **Titel**               | **Beschreibung (Kurz)**                                         | **Zugehörige Komponenten**                               | **Sprint**    |
| -------- | ----------------------- | --------------------------------------------------------------- | -------------------------------------------------------- |---------------|
| **F1.1** | Stichmuster             | Maschine hat 10–20 verschiedene Stichmuster.                    | `StitchPatternManager`                                   | **Sprint1**   |
| **F1.2** | Auswahl SM              | Stichmuster müssen über ein Drehrad auswählbar sein.            | `InputHandler`, `StitchPatternManager`, `DisplayManager` | **Sprint1**   |
| **F1.3** | Voreinstellung          | Jedes Stichmuster hat Parameter (Länge, Breite, Nadelposition). | `SystemController`, `StitchPatternManager`               | **Sprint1**   |
| **F1.4** | Anzeige SM              | Aktuell gewähltes Stichmuster soll im Display angezeigt werden. | `DisplayManager`, `StitchPatternManager`                 | **Sprint1**   |
| **F2.1** | Eingabe Geschwindigkeit | Nähgeschwindigkeit proportional zur Pedalstellung.              | `InputHandler`, `MotorController`                        |                
| **F2.2** | Stop loslassen          | Maschine stoppt sofort bei Loslassen des Pedals.                | `SystemController`, `MotorController`                    |
| **F2.3** | Festlegung vmax         | Max. Nähgeschwindigkeit = 1100 U/min.                           | `MotorController`                                        |
| **F3.1** | LED Benutzung           | Nähbereich mit LED ausleuchten.                                 | `LEDController`                                          |
| **F3.2** | Manuelle Bedienung LED  | Drei Modi: Aus, Ein, Automatik.                                 | `InputHandler`, `SystemController`, `LEDController`      |
| **F3.3** | Helligkeit LED          | Helligkeit über Drehrad (1–5) einstellbar.                      | `InputHandler`, `LEDController`                          |
| **F3.4** | LED Anzeige             | Anzeige von Helligkeit und Modus im Display.                    | `SystemController`, `DisplayManager`, `LEDController`    |
| **F4.1** | Fadenspannung           | Fadenspannung einstellbar über Drehrad.                         | `InputHandler`, `TensionController`                      |
| **F4.3** | Anzeige Fadenspannung   | Aktuelle Fadenspannung im Display anzeigen.                     | `DisplayManager`, `TensionController`                    |
| **F5.1** | Stichlänge              | Einstellbar im Bereich 1.5–5 mm.                                | `InputHandler`, `StitchPatternManager`                   | **Sprint1**   |
| **F5.2** | Stichbreite             | Einstellbar im Bereich 2.5–7 mm.                                | `InputHandler`, `StitchPatternManager`                   | **Sprint1**   |
| **F5.3** | Länge/Breite Anzeige    | Aktuelle Werte im Display anzeigen.                             | `DisplayManager`, `StitchPatternManager`                 | **Sprint1**   |
