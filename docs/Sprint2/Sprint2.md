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
