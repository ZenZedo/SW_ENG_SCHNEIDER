# Pflichtenheft: Elektronische Nähmaschine

## 1. Einleitung
Dieses Pflichtenheft beschreibt die technische Umsetzung der Anforderungen für eine elektronische Nähmaschine mit programmierbaren Stichmustern, stufenlos regelbarer Geschwindigkeit, LED-Beleuchtung und Fadenspannungskontrolle. Ziel ist eine benutzerfreundliche und energieeffiziente Maschine.

## 2. Projektbeschreibung
Die Maschine soll mindestens 10 Stichmuster bereitstellen, die per Tasten, Drehregler oder Touchdisplay auswählbar sind. Parameter wie Stichlänge, -breite und Nadelposition laden sich automatisch nach Musterwahl. Die Stichmuster können auch kombiniert und gespeichert werden. Geschwindigkeit wird stufenlos über ein Fußpedal gesteuert, mit automatischem Stopp bei Pedallosslassen.

## 3. Technische Umsetzung

### 3.1 Hardware
- Mikrocontroller mit C++ Softwaresteuerung
- Display (LCD oder TFT) zur Anzeige von Stichmuster, Geschwindigkeit, Fadenspannung und Einstellungen
- LEDs für Nähbereich-Beleuchtung, dimmbar und manuell schaltbar
- Motoransteuerung via PWM für stufenlose Geschwindigkeit
- Sensorsystem zur Messung und Halten der Fadenspannung
- Speicher für Stichmuster und Einstellungen

### 3.2 Software
- Implementierung in C++ mit modularer Architektur
- Interrupt-Basierte Bedienung für Tasten, Drehregler und Fußpedal
- Menüführung mit max. 3 Ebenen
- Anzeigeanpassung für Barrierefreiheit (Farbenblindheit/Sehschwäche)
- Energieeffiziente Betriebsmodi und Warnsignale

## 4. Umsetzung der funktionalen Anforderungen

| Anforderungsnummer | Umsetzung |
|--------------------|-----------|
| F1.1 – F1.5        | Speicherung und Auswahl von mindestens 10 Stichmustern, automatische Parameterladung, eigene Musterkombinationen speicherbar |
| F2.1 – F2.4        | PWM-gesteuerte, Pedalbasierte Motorregelung, sofortiger Stopp bei Pedallosslassen, vmax begrenzbar, Geschwindigkeit im Display sichtbar |
| F3.1 – F3.3        | LED-Beleuchtung steuerbar, manuell schaltbar, dimmbar via Software PWM |
| F4.1 – F4.3        | Elektronische Regelung der Fadenspannung mit Messwertanzeige und Konstanthaltung |
| F5.1 – F5.3        | Einstellbare Stichlänge (1.5–5 mm), Stichbreite (2.5–7 mm), Anzeige der Werte im Display |

## 5. Umsetzung der nicht-funktionalen Anforderungen

| Anforderungsnummer | Umsetzung |
|--------------------|-----------|
| NF1.1 – NF1.3      | Klare Menüführung mit max. 3 Ebenen, Softwareentwicklung in C++, Budgetvorgaben berücksichtigen |
| NF2.1 – NF4.1      | Geschwindigkeitsbereich 200–900 Stiche/min, Einstellbereich 1–9 |
| NF6.1 – NF6.6      | Angenehme, verzögerungsfreie Anzeige |

## 6. Tests und Abnahme
- Funktionsprüfung aller Stichmuster und Bedienarten
- Messung der Geschwindigkeit und Fadenspannung im vorgegebenen Bereich
- Überprüfung der Anzeige- und Warnfunktionalitäten
- Bedienbarkeitstest und Barrierefreiheitstest
- Energieverbrauchsmessung

## 7. Abnahmekriterien
Die Maschine erfüllt alle funktionalen und nicht-funktionalen Anforderungen gemäß Lastenheft, zeigt alle Werte korrekt an, reagiert innerhalb 1 Sekunde auf Benutzerinteraktion und arbeitet energieeffizient.

---

Dieses Pflichtenheft gibt die Details zum technischen Vorgehen bei der Entwicklung der Nähmaschine vor und dient als Grundlage für Umsetzung und Kontrolle.

