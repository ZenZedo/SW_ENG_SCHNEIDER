# Benutzerhandbuch – Nähmaschinen-Steuerungssystem

**Version:** 1.0  
**Datum:** Dezember 2025  
**Verfasser:** David Schneider

---

## 1. Übersicht der Bedienelemente

Die Nähmaschine verfügt über eine intuitive Benutzeroberfläche mit mehreren Bedienelementen und einer digitalen Anzeige. Im Folgenden werden alle Komponenten und ihre Funktionen beschrieben.

---

## 2. Display (Zentrale Informationsanzeige)

Das Display zeigt die wichtigsten Betriebsinformationen der Nähmaschine in Echtzeit an und kann zwischen verschiedenen Informationsbereichen wechseln.

### 2.1 Anzeigebereiche

#### Stichmuster-Anzeige
Das Display zeigt das aktuell ausgewählte Stichmuster mit seiner Nummer und seinem Namen an.

**Anzeigeformat:** `Muster: Zickzack (2/20)`

- **Mustername:** Der Name des gewählten Musters (z.B. „Geradstich", „Zickzack", „Blindstich")
- **Musternummer:** Die aktuelle Nummer des Musters und die Gesamtanzahl verfügbarer Muster
- **Aktualisierung:** Sofort nach Musterwechsel (< 50 ms)

#### Stichlängen- und Stichbreiten-Anzeige
Das Display zeigt die aktuell eingestellten Werte für Stichlänge und Stichbreite an.

**Anzeigeformat:** `Länge: 3,0 mm | Breite: 4,5 mm`

- **Stichlänge:** Bereich von 1,5 bis 5,0 mm
- **Stichbreite:** Bereich von 2,5 bis 7,0 mm
- **Aktualisierung:** Bei jeder Änderung sofort sichtbar

#### LED-Status-Anzeige
Das Display zeigt den aktuellen Modus und die Helligkeit der LED an.

**Anzeigeformat:** `LED: Automatisch | Helligkeit: 3/5`

- **LED-Modus:** Zeigt an, ob die LED auf „Aus", „Ein" oder „Automatisch" eingestellt ist
- **Helligkeit:** Aktuelle Stufe von 1 (dunkel) bis 5 (hell)
- **Aktualisierung:** Sofort nach Änderung

#### Fadenspannungs-Anzeige
Das Display zeigt die aktuell eingestellte Fadenspannung an.

**Anzeigeformat:** `Fadenspannung: 5`

- **Wertebereich:** 1 bis 9
- **Bedeutung:** Höhere Werte = stärkere Spannung, niedrigere Werte = schwächere Spannung
- **Aktualisierung:** Bei jeder Änderung sofort sichtbar

---

## 3. Bedienschnittstellen

### 3.1 Drehrad für Stichmusterwahl

Das Drehrad befindet sich auf der linken Seite der Maschine und dient zur Auswahl des Stichmusters.

**Bedienung:**

- **Drehen nach rechts:** Nächstes Stichmuster auswählen (Nummer erhöht sich)
- **Drehen nach links:** Vorheriges Stichmuster auswählen (Nummer sinkt)
- **Bereichs-Wrap-Around:** Nach Muster 20 folgt Muster 1 (und umgekehrt)

**Feedback:**

- Das Display aktualisiert sich sofort und zeigt das neue Muster an
- Ungültige Eingaben werden automatisch auf den zulässigen Bereich begrenzt

**Beispiel:**

```
Aktuelles Muster: Geradstich (1/20)
→ Drehen nach rechts
→ Neues Muster: Zickzack (2/20)
```

---

### 3.2 Stichlängen-Einstellung (Drehrad/Schieber)

Der Stichlängen-Regler befindet sich oben mittig und ermöglicht die Einstellung der Stichlänge.

**Bedienung:**

- **Bewegung nach oben:** Stichlänge erhöhen
- **Bewegung nach unten:** Stichlänge verringern
- **Bereich:** 1,5 mm bis 5,0 mm
- **Schrittweite:** Kontinuierlich oder in 0,1 mm Schritten (je nach Modell)

**Validierung:**

- Werte unter 1,5 mm werden automatisch auf 1,5 mm begrenzt
- Werte über 5,0 mm werden automatisch auf 5,0 mm begrenzt

**Feedback:**

- Das Display zeigt die aktuelle Stichlänge in Echtzeit an
- Beispiel: `Länge: 3,0 mm`

---

### 3.3 Stichbreiten-Einstellung (Drehrad/Schieber)

Der Stichbreiten-Regler befindet sich oben rechts und ermöglicht die Einstellung der Stichbreite.

**Bedienung:**

- **Bewegung nach oben:** Stichbreite erhöhen
- **Bewegung nach unten:** Stichbreite verringern
- **Bereich:** 2,5 mm bis 7,0 mm
- **Schrittweite:** Kontinuierlich oder in 0,1 mm Schritten

**Validierung:**

- Werte unter 2,5 mm werden automatisch auf 2,5 mm begrenzt
- Werte über 7,0 mm werden automatisch auf 7,0 mm begrenzt

**Feedback:**

- Das Display zeigt die aktuelle Stichbreite in Echtzeit an
- Beispiel: `Breite: 4,5 mm`

---

### 3.4 Fadenspannungs-Drehregler

Der Fadenspannungs-Regler befindet sich an der Vorderseite und ermöglicht die Anpassung der Fadenspannung.

**Bedienung:**

- **Nach rechts drehen:** Fadenspannung erhöhen (bis Stufe 9)
- **Nach links drehen:** Fadenspannung verringern (bis Stufe 1)
- **Bereich:** Stufe 1 bis 9 (9 diskrete Positionen)

**Validierung:**

- Werte unter 1 werden auf 1 begrenzt
- Werte über 9 werden auf 9 begrenzt

**Feedback:**

- Das Display zeigt die aktuelle Spannung an
- Beispiel: `Fadenspannung: 5` (mittlere Spannung, Standard)

**Tipps:**

- Stufe 1–3: Für dünne oder empfindliche Stoffe
- Stufe 5: Standard-Einstellung für die meisten Stoffe
- Stufe 7–9: Für dicke oder robuste Materialien

---

### 3.5 LED-Modus-Tastenblock

Der LED-Modus-Tastenblock befindet sich rechts neben dem Display und ermöglicht die Wahl zwischen drei Betriebsmodi.

**Verfügbare Modi:**

| Modus | Beschreibung | Verwendung |
|---|---|---|
| **Aus** | LED ist ausgeschaltet | Energiesparen, Dunkelheit nicht erforderlich |
| **Ein** | LED leuchtet dauerhaft mit eingestellter Helligkeit | Kontinuierliche Beleuchtung beim Nähen |
| **Automatisch** | LED schaltet sich automatisch ein, wenn die Maschine läuft | Praktisch: LED folgt der Nähgeschwindigkeit |

**Bedienung:**

- **Taste „Aus" drücken:** LED-Modus auf „Aus" stellen
- **Taste „Ein" drücken:** LED-Modus auf „Ein" stellen
- **Taste „Auto" drücken:** LED-Modus auf „Automatisch" stellen

**Feedback:**

- Das Display zeigt den aktuellen Modus an
- Beispiel: `LED: Automatisch`

**Automatik-Modus Erklärung:**

- **Maschine läuft (Pedal gedrückt):** LED leuchtet mit eingestellter Helligkeit
- **Maschine steht (Pedal nicht gedrückt):** LED erlischt automatisch

---

### 3.6 LED-Helligkeit-Drehrad

Das Helligkeit-Drehrad befindet sich unter den LED-Modi-Tasten und ermöglicht die Einstellung der LED-Leuchtkraft.

**Bedienung:**

- **Nach rechts drehen:** Helligkeit erhöhen
- **Nach links drehen:** Helligkeit verringern
- **Bereich:** 5 Stufen (1 = dunkel bis 5 = sehr hell)

**Helligkeit-Stufen:**

| Stufe | Beschreibung | Leuchtkraft |
|---|---|---|
| 1 | Minimal (sehr dunkel) | ~5% |
| 2 | Schwach (dunkel) | ~30% |
| 3 | Mittel (Standard) | ~60% |
| 4 | Stark (hell) | ~90% |
| 5 | Maximal (sehr hell) | ~100% |

**Feedback:**

- Das Display zeigt die aktuelle Stufe an
- Beispiel: `Helligkeit: 3/5`

**Tipps:**

- Stufe 1–2: Für Nachtarbeit oder Energiesparen
- Stufe 3: Standard-Einstellung
- Stufe 4–5: Für detaillierte Arbeiten mit schlechtem Licht

---

### 3.7 Pedal (Geschwindigkeitssteuerung)

Das Pedal befindet sich am Boden und dient der Kontrolle der Nähgeschwindigkeit.

**Bedienung:**

- **Pedal nicht gedrückt:** Maschine steht still (0 U/min)
- **Pedal teilweise gedrückt:** Maschine läuft mit reduzierter Geschwindigkeit
- **Pedal vollständig gedrückt:** Maschine läuft mit maximaler Geschwindigkeit (1.100 U/min)

**Geschwindigkeit-Berechnung:**

```
Geschwindigkeit [U/min] = Pedalposition [0–100%] × 1.100
```

**Beispiele:**

| Pedalstellung | Geschwindigkeit | Verwendung |
|---|---|---|
| 0% (nicht gedrückt) | 0 U/min | Stillstand, Fadeneinfädeln |
| 25% | ~275 U/min | Sehr langsames Nähen, Anfänger |
| 50% | ~550 U/min | Normales Nähen mit Kontrolle |
| 75% | ~825 U/min | Schnelleres Nähen |
| 100% (vollständig) | 1.100 U/min | Maximale Geschwindigkeit |

**Sicherheits-Features:**

- **Sofortiger Stopp:** Beim Loslassen des Pedals stoppt die Maschine sofort (< 100 ms)
- **Keine Trägheit:** Die Maschine verzögert nicht sanft – sie stoppt unmittelbar
- **Maximale Geschwindigkeit:** Die Maschine kann nicht schneller als 1.100 U/min laufen

**Tipps:**

- Für Anfänger: Mit niedrigen Geschwindigkeiten (25–50%) üben
- Für Kontrollarbeiten: 50% Pedalstellung verwenden
- Für schnelle Arbeiten: 75–100% nutzen
- **Wichtig:** Immer mit leichtem Pedaldruck starten, um die Kontrolle zu behalten

---

## 4. Betriebsmodi und Zustände

### 4.1 LED-Modus: Aus

**Zustand:** Die LED ist ausgeschaltet.

**Wann verwenden:**

- Wenn die Maschine stillsteht
- Um Energie zu sparen
- Wenn die Beleuchtung nicht erforderlich ist

**Helligkeit-Einstellung:** Ist irrelevant, wenn der Modus auf „Aus" eingestellt ist

---

### 4.2 LED-Modus: Ein

**Zustand:** Die LED leuchtet dauerhaft mit der eingestellten Helligkeit.

**Verhalten:**

- LED leuchtet unabhängig davon, ob die Maschine läuft oder stillsteht
- Helligkeit bleibt konstant

**Wann verwenden:**

- Bei schlechten Lichtverhältnissen
- Wenn kontinuierliche Beleuchtung gewünscht ist
- Für detaillierte Arbeiten

---

### 4.3 LED-Modus: Automatisch

**Zustand:** Die LED folgt dem Betriebszustand der Nähmaschine.

**Verhalten:**

- **Maschine läuft (Pedal > 0):** LED leuchtet mit eingestellter Helligkeit
- **Maschine stillsteht (Pedal = 0):** LED erlischt automatisch

**Wann verwenden:**

- Standard-Betriebsmodus für tägliche Arbeiten
- Automatische Energieeinsparung
- Intuitive Bedienung ohne manuelle Kontrolle

**Vorteile:**

- Praktisch und energieeffizient
- LED leuchtet automatisch auf, wenn die Maschine läuft
- Spart Energie, wenn die Maschine nicht in Gebrauch ist

---

## 5. Typische Arbeitsabläufe

### 5.1 Arbeitsprozess: Nähen mit Zickzack-Stich

1. **Stichmuster einstellen:**
   - Drehrad drehen, bis das Display „Muster: Zickzack (2/20)" anzeigt
   - Ggf. bestätigen mit kurzem Tastendruck

2. **Stichlänge anpassen:**
   - Stichlängen-Schieber auf gewünschte Position stellen (z.B. 3,0 mm)
   - Display zeigt: `Länge: 3,0 mm`

3. **Stichbreite anpassen:**
   - Stichbreiten-Schieber auf gewünschte Position stellen (z.B. 4,5 mm)
   - Display zeigt: `Breite: 4,5 mm`

4. **Fadenspannung einstellen:**
   - Drehregler auf Stufe 5 (Standard) drehen
   - Display zeigt: `Fadenspannung: 5`

5. **LED aktivieren:**
   - LED-Modus-Taste „Auto" drücken für automatische Beleuchtung
   - Display zeigt: `LED: Automatisch | Helligkeit: 3/5`

6. **Nähen starten:**
   - Stoff unter den Fuß schieben
   - Pedal langsam drücken, um mit niedriger Geschwindigkeit zu starten
   - Pedalposition nach Bedarf erhöhen
   - Beim Loslassen des Pedals stoppt die Maschine sofort

---

### 5.2 Arbeitsprozess: Sehr feines Nähen mit erhöhter Helligkeit

1. **Stichmuster:** Geradstich (1/20)
2. **Stichlänge:** 1,5 mm (sehr klein)
3. **Stichbreite:** 0 mm (Geradstich, nicht zutreffend)
4. **Fadenspannung:** 3 (schwächer für dünne Stoffe)
5. **LED:** Modus „Ein" + Helligkeit 5 (maximale Helligkeit)
6. **Geschwindigkeit:** 25–50% Pedal (sehr langsam)

---

### 5.3 Arbeitsprozess: Schnelles Nähen mit Ziermustern

1. **Stichmuster:** Blumenstich (5/20)
2. **Stichlänge:** 4,0 mm (länger)
3. **Stichbreite:** 6,0 mm (breiter)
4. **Fadenspannung:** 7 (stärker für Kontrollkontrolle)
5. **LED:** Modus „Auto" (automatisch bei Bedarf)
6. **Geschwindigkeit:** 75–100% Pedal (schnell)

---

## 6. Wartung und Fehlerbehebung

### 6.1 Häufig gestellte Fragen

**F: Die Maschine näht nicht gleichmäßig. Was kann ich tun?**

A: Überprüfen Sie die folgenden Punkte:
- Fadenspannung ist zu hoch oder zu niedrig → Regler auf Stufe 5 zurücksetzen
- Falsche Stichlänge eingestellt → Auf 3,0 mm einstellen
- Nadel könnte beschädigt sein → Nadel austauschen

**F: Die LED leuchtet nicht, obwohl der Modus auf „Ein" steht.**

A:
- Überprüfen Sie, ob der Helligkeit-Regler auf 0 steht → Auf mindestens Stufe 1 erhöhen
- Überprüfen Sie die Stromversorgung der LED
- LED könnte defekt sein → Service kontaktieren

**F: Das Pedal reagiert nicht richtig auf Druck.**

A:
- Überprüfen Sie, ob das Pedal verschmutzt ist → Reinigen
- Überprüfen Sie die Pedalverbindung → Ggf. nachziehen
- Elektronischer Kontakt könnte unterbrochen sein → Service kontaktieren

**F: Der Automatikmodus der LED funktioniert nicht – LED bleibt an, obwohl die Maschine stillsteht.**

A:
- Überprüfen Sie den LED-Modus → Muss auf „Automatisch" stehen
- Überprüfen Sie, ob das Pedal vollständig losgelassen wurde
- Es könnte ein Softwarefehler vorliegen → System neu starten oder Service kontaktieren

---

### 6.2 Kurze Fehlerbehebung

| Problem | Mögliche Ursache | Lösung |
|---|---|---|
| Maschine näht nicht | Pedal nicht gedrückt | Pedal drücken |
| Ungleichmäßige Stiche | Fadenspannung falsch | Fadenspannung auf Stufe 5 zurücksetzen |
| Faden reißt | Spannung zu hoch | Fadenspannung reduzieren (Stufe 3–4) |
| Display zeigt nichts | Stromversorgung aus | Gerät einschalten |
| LED leuchtet nicht | Helligkeit auf 0 | Helligkeit erhöhen |
| Pedal reagiert langsam | Verschmutzung | Pedal reinigen |

---

## 7. Sicherheitshinweise

### Wichtige Sicherheitsregeln

- ✓ **Nie während des Nähens Finger unter den Fuß stecken**
- ✓ **Pedal sofort loslassen, wenn etwas Ungewöhnliches passiert**
- ✓ **Die Maschine stoppt sofort beim Loslassen des Pedals**
- ✓ **Nicht mit nassen Händen bedienen**
- ✓ **Keine Fremdkörper in die Maschine stecken**
- ✓ **Stromversorgung überprüfen, bevor Sie die Maschine nutzen**
- ✓ **Bei Fehlfunktionen sofort den Betrieb einstellen und Service kontaktieren**

---

## 8. Technische Daten (Zusammenfassung)

| Eigenschaft | Wert |
|---|---|
| **Anzahl Stichmuster** | 10–20 |
| **Stichlängen-Bereich** | 1,5–5,0 mm |
| **Stichbreiten-Bereich** | 2,5–7,0 mm |
| **Fadenspannungs-Bereich** | 1–9 (9 Stufen) |
| **Max. Nähgeschwindigkeit** | 1.100 U/min |
| **LED Helligkeit-Stufen** | 5 (1–5) |
| **LED Modi** | Aus, Ein, Automatisch |
| **Display-Aktualisierung** | < 50 ms |
| **Pedal-Reaktionszeit** | < 100 ms |
| **Notbremse** | Sofortiger Stopp beim Loslassen |

---

## 9. Kontakt und Support

Bei Fragen, Problemen oder zur Wartung kontaktieren Sie bitte:

- **Technischer Support:** support@naehmaschine.de
- **Hotline:** +49 (0) XXX / XXXXXX
- **Öffnungszeiten:** Mo.–Fr. 9:00–17:00 Uhr

---

**Ende des Benutzerhandbuchs**
