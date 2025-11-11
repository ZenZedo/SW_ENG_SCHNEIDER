# Pflichtenheft: Elektronische Nähmaschine

## 1. Einleitung
Dieses Pflichtenheft beschreibt die technische Umsetzung der Anforderungen für eine elektronische Nähmaschine mit programmierbaren Stichmustern, stufenlos regelbarer Geschwindigkeit, LED-Beleuchtung und Fadenspannungskontrolle. Ziel ist eine benutzerfreundliche und energieeffiziente Maschine.

## 2. Projektbeschreibung
Die Maschine soll 10-20 Stichmuster bereitstellen, die per Tasten, Drehregler oder Touchdisplay auswählbar sind. Parameter wie Stichlänge, -breite und Nadelposition laden sich automatisch nach Musterwahl. Geschwindigkeit wird stufenlos über ein Fußpedal gesteuert, mit automatischem Stopp bei Pedallosslassen.

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

## 4. Tests und Abnahme
- Funktionsprüfung aller Stichmuster und Bedienarten
- Messung der Geschwindigkeit und Fadenspannung im vorgegebenen Bereich
- Überprüfung der Anzeige- und Warnfunktionalitäten
- Bedienbarkeitstest und Barrierefreiheitstest
- Energieverbrauchsmessung

## 5. Abnahmekriterien
Die Maschine erfüllt alle funktionalen und nicht-funktionalen Anforderungen gemäß Lastenheft, zeigt alle Werte korrekt an, reagiert innerhalb 1 Sekunde auf Benutzerinteraktion und arbeitet energieeffizient.

---

Dieses Pflichtenheft gibt die Details zum technischen Vorgehen bei der Entwicklung der Nähmaschine vor und dient als Grundlage für Umsetzung und Kontrolle.

