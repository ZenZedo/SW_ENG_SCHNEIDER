
# Requirements: Nähmaschine

**Legende:** <p class="muss">Muss-Requirement<p> <p class="soll">Soll-Requirement<p> <p class="kann">Kann-Requirement<p>

### 1. Funktionale Requirements

<table>
  <thead>
    <tr>
      <th>Nr.</th>
      <th>Titel</th>
      <th>Beschreibung</th>
    </tr>
  </thead>
  <tbody>
    <tr class="muss">
      <td>F1.1</td>
      <td>Stichmuster</td>
      <td>Die Maschine muss mindestens 10 Stichmuster bereitstellen.</td>
    </tr>
    <tr class="muss">
      <td>F1.2</td>
      <td>Auswahl SM</td>
      <td>Der Benutzer muss ein Stichmuster über Tasten, Drehregler oder Touchdisplay auswählen können.</td>
    </tr>
    <tr class="muss">
      <td>F1.3</td>
      <td>Einstellung</td>
      <td>Nach der Auswahl müssen die Parameter (Stichlänge, -breite, Nadelposition) automatisch geladen werden.</td>
    </tr>
    <tr class="kann">
      <td>F1.4</td>
      <td>Anzeige SM</td>
      <td>Das aktuell gewählte Stichmuster soll im Display angezeigt werden.</td>
    </tr>
    <tr class="kann">
      <td>F1.5</td>
      <td>Selbstwahl SM</td>
      <td>Die Maschine kann eigene Stichmusterkombinationen speichern.</td>
    </tr>
    <tr class="muss">
      <td>F2.1</td>
      <td>Stufenlose Geschw.</td>
      <td>Die Nähgeschwindigkeit muss stufenlos über das Fußpedal regelbar sein.</td>
    </tr>
    <tr class="muss">
      <td>F2.2</td>
      <td>Stopp loslassen</td>
      <td>Die Maschine muss bei Loslassen des Pedals sofort stoppen.</td>
    </tr>
    <tr class="muss">
      <td>F2.3</td>
      <td>Festlegung vmax</td>
      <td>Eine maximale Geschwindigkeit soll festgelegt werden können.</td>
    </tr>
    <tr class="kann">
      <td>F2.4</td>
      <td>Anzeige Geschw.</td>
      <td>Die aktuelle Geschwindigkeit kann im Display angezeigt werden. </td>
    </tr>
    <tr class="muss">
      <td>F3.1</td>
      <td>LED Benutzung</td>
      <td> Die Maschine muss den Nähbereich mit einer LED ausleuchten. </td>
    </tr>
    <tr class="soll">
      <td>F3.2</td>
      <td>Manuelle Bedienung LED</td>
      <td>Die Beleuchtung soll manuell ein- und ausschaltbar sein. </td>
    </tr>
    <tr class="kann">
      <td>F3.3</td>
      <td>Helligkeit LED</td>
      <td>Die Beleuchtung kann dimmbar sein.</td>
    </tr>
    <tr class="muss">
      <td>F4.1</td>
      <td>Fadenspannung</td>
      <td>Die Fadenspannung muss einstellbar sein (manuell oder elektronisch). </td>
    </tr>
    <tr class="muss">
      <td>F4.2</td>
      <td>Fadenspannung Halten</td>
      <td>Die Maschine muss die eingestellte Spannung während des Nähvorgangs konstant halten.</td>
    </tr>
    <tr class="kann">
      <td>F4.3</td>
      <td>Anzeige Fadenspannung</td>
      <td>Die aktuelle Fadenspannung soll im Display angezeigt werden. </td>
    </tr>
    <tr class="muss">
      <td>F5.1</td>
      <td>Stichlänge</td>
      <td>Die Stichlänge muss im Bereich 0–5 mm einstellbar sein.</td>
    </tr>
    <tr class="muss">
      <td>F5.2</td>
      <td>Stichbreite</td>
      <td>Die Stichbreite muss im Bereich 0–7 mm einstellbar sein.</td>
    </tr>
    <tr class="kann">
      <td>F5.3</td>
      <td>Länge/Breite anzeige</td>
      <td>Die aktuellen Werte sollen im Display angezeigt werden. </td>
    </tr>
  </tbody>
</table>




### 2. Nicht-funktionale Requirements

<table>
  <thead>
    <tr>
      <th>Nr.</th>
      <th>Titel</th>
      <th>Beschreibung</th>
    </tr>
  </thead>
  <tbody>
    <tr class="soll">
      <td>NF1.1</td>
      <td>Menüführung</td>
      <td>Menüführung max. 3 Bedienebenen.</td>
    </tr>
    <tr class="muss">
      <td>NF2.1</td>
      <td>Geschw. Bereich</td>
      <td>Geschwindigkeitsbereich: 200–900 Stiche/min.</td>
    </tr>
    <tr class="soll">
      <td>NF4.1</td>
      <td>Einstellbereich</td>
      <td>Einstellbereich 1–9.</td>
    </tr>
    <tr class="soll">
      <td>NF6.1</td>
      <td>Angenehme Anzeige</td>
      <td>Die Anzeige ist nicht zu hell oder visuell aufdringlich.</td>
    </tr>
    <tr class="kann">
      <td>NF6.2</td>
      <td>Barrierefreie Anzeige (Farbenblindheit)</td>
      <td>Die Anzeige ist auch für farbenblinde Nutzer eindeutig erkennbar.</td>
    </tr>
    <tr class="kann">
      <td>NF6.3</td>
      <td>Barrierefreie Anzeige (Sehschwäche)</td>
      <td>Die Anzeige ist auch für Nutzer mit eingeschränktem Sehvermögen gut lesbar.</td>
    </tr>
    <tr class="soll">
      <td>NF6.4</td>
      <td>Anzeige ohne Verzögerungen</td>
      <td>Die Anzeige erfolgt innerhalb von &lt;1 Sekunde nach Benutzerinteraktion.</td>
    </tr>
    <tr class="muss">
      <td>NF1.2</td>
      <td>Wertetoleranzz</td>
      <td>Die Genauigkeiten müssen mit einer Toleranz von ±5 % gegenüber der realen werte übereinstimmen.</td>
    </tr>
    <tr class="kann">
      <td>NF1.3</td>
      <td>Ressourcenschonende Einstellung</td>
      <td>Die Einstellungen dürfen nur minimal Rechen- und Speicherressourcen beanspruchen.</td>
    </tr>
    <tr class="soll">
      <td>NF6.5</td>
      <td>Wahrnehmbarkeit der Warnung</td>
      <td>Die Warnsignale müssen in typischen Alltagssituationen gut wahrnehmbar sein (z. B. im Bad oder bei Geräuschkulisse).</td>
    </tr>
    <tr class="soll">
      <td>5.6</td>
      <td>Energieeffizient</td>
      <td>Die Nähmaschine muss Energieeffizient sein.</td>
    </tr>
  </tbody>
</table>


### 3. Abhängigkeiten zwischen Requirements

| Requirement-Nr.          | Zusammenhang / Abhängigkeit / Konfliktbeschreibung                                                                                                                                                             |
|--------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1.1 → 1.2, 1.3           | Die Spannungsmessung (1.1) ist Voraussetzung für die Umrechnung in Prozent (1.2) und muss dabei automatisch & benutzerfrei (1.3) erfolgen.                                                                     |
| 3.1 → 1.2, 3.2, 5.5      | Die Definition der Referenzspannungen (3.1) ist Grundlage für die Prozentanzeige (1.2) und das Signalisieren, dass wieder eine Rasur möglich ist, (5.5) und Voraussetzung für die initiale Kalibrierung (3.2). |
| 3.2 → 3.3                | Die Definition der initialen Kalibrierung (3.2) ist Vorraussetzung für die regelmäßige Rekalibrierung (3.3).                                                                                                   |
| 3.3 → 3.4                | Regelmäßige Rekalibrierung (3.3) ist notwendig, um die Anzeigetoleranz von ±5 % (3.4) dauerhaft zu gewährleisten.                                                                                              |
| 5.4 → 5.1, 5.2, 5.3, 5.5 | Die Anzeige des Ladezustands (5.1, 5.2, 5.3, 5.5) basiert auf der Erkennung durch die Elektronik (5.4).                                                                                                        |
| 1.2 → 2                  | Der Ladezustand der Batterie muss zuverlässig in Prozent umgerechnet werden (1.2), um die adäquate Anzeige zu ermöglichen (2).                                                                                 |
| 2.1 → 2.*                | Die generelle Anzeige des Batteriezustandes (2.1) bildet die Grundlage für alle weiterführenden Anzeigen (2.3) bzw. die Anzeige als Folge von konkreten Aktionen (2.2, 2.5).                                   |
| 3 → 2.1                  | Die Spannungsreferenz und die richtige Kalibrierung (3) ist Vorraussetzung für eine korrekte Anzeige (2.1).                                                                                                    |
| 1.1, 3.1 → 6.1, 6.2      | Die definierte Spannungsreferenz (3.1) und die zuverlässige Messung der Akkuspannung (1.1) ist Vorraussetzung für einen gelungenen Unterspannungs- (6.1) und Überladeschutz (6.2).                             |
| 6, 3.3 → 3.5             | Die Umsetzung der Schutzfunktionen für die Sicherheit und die Langlebigkeit der Batterie (6), sowie die regelmäßige Rekalibrierung der Spannungsreferenz (3.3) sind maßgeblich für die Altersrobustheit (3.5). |

### 4. Konflikte zwischen Requirements

| Requirement-Nr. | Zusammenhang / Abhängigkeit / Konfliktbeschreibung                                                                                       |
|-----------------|------------------------------------------------------------------------------------------------------------------------------------------|
| 2.10 ↔ 3.6, 5.6 | Ressourcenschonung (3.6)  oder energieeffizienter Ladeanzeige (5.6) kann mit schneller Anzeigeaktualisierung (2.10) in Konflikt stehen . |
| 2.7 ↔ 4.3       | Nicht störende Helligkeit (2.7) kann im Widerspruch stehen zu gut wahrnehmbaren Warnungen (4.4).                                         |

### 5. Zusammengehörigkeiten zwischen Requirements

| Requirement-Nr. | Beschreibung / Begründung                                                                                                                                                                                                             |
|-----------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1.1, 1.2, 3.1   | Spannungsmessung (1.1), Umrechnung in Prozent (1.2) und Referenzwerte (3.1) bilden die Grundlage der Anzeige.                                                                                                                         |
| 1.2, 3.4, 3.5   | Prozentanzeige (1.2) ist nur sinnvoll, wenn sie innerhalb einer definierten Toleranz (3.4) und auch bei alternden Akkus (3.5) stabil funktioniert.                                                                                    |
| 4.1, 4.2        | Die Einstellung der Warnschwelle (4.2) ist nur sinnvoll, wenn es auch eine Warnung bei niedrigem Akkustand (4.1) gibt und diese ist von der Warnschwelle abhängig.                                                                    |
| 6.2, 6.3, 5     | Der Überladeschutz (6.2) und die Temperaturüberwachung beim Laden (6.3) hängen mit dem Ladevorgang und seiner Anzeige im generellen (5) zusammen.                                                                                     |
| 6.1, 1          | Der Unterspannungsschutz (6.1) hängt eng mit der Erkennung des aktuellen Batteriestandes (1) zusammen, da sonst keine Unterspannung ausgemacht werden kann.                                                                           |
| 2.6, 4.3        | Die intuitive Batteriestandsanzeige (2.6) hängt mit der guten Wahrnehmbarkeit der Warnung bei niedrigem Batteriestand (4.4) zusammen, da beide dasselbe Ziel verfolgen. Für den Nutzer gut erkennbar und leicht verständlich zu sein. |
