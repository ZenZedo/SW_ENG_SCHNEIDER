
# Requirements: Nähmaschine

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
      <td>Die Maschine hat eine Anzahl von 10-20 verschiedenen Stichmustern.</td>
    </tr>
    <tr class="muss">
      <td>F1.2</td>
      <td>Auswahl SM</td>
      <td>Die Stichmuster müssen über einen Knopf, ein Drehrad, oder das Display auswählbar sein.</td>
    </tr>
    <tr class="muss">
      <td>F1.3</td>
      <td>Einstellung</td>
      <td>Jedes Stichmuster hat 3 Parameter: Stichlänge/breite, Nadelposition und Stichmuster. Bei der Auswahl eines Musters werden die dazugehörigen Parameter geladen</td>
    </tr>
    <tr class="kann">
      <td>F1.4</td>
      <td>Anzeige SM</td>
      <td>Das aktuell gewählte Stichmuster soll im Display angezeigt werden.</td>
    </tr>
    <tr class="muss">
      <td>F2.1</td>
      <td>Stufenlose Geschw.</td>
      <td>Die Nähgeschwindigkeit wird durch das Fußpedal gesteuert und ist proportional zur Pedalstellung.</td>
    </tr>
    <tr class="muss">
      <td>F2.2</td>
      <td>Stopp loslassen</td>
      <td>Die Maschine muss bei Loslassen des Pedals sofort stoppen.</td>
    </tr>
    <tr class="muss">
      <td>F2.3</td>
      <td>Festlegung vmax</td>
      <td>Nähgeschwingigkeit beträgt 0 bis 1100 U/min.</td>
    </tr>
    <tr class="kann">
    <tr class="muss">
      <td>F3.1</td>
      <td>LED Benutzung</td>
      <td> Die Maschine muss den Nähbereich mit einer LED ausleuchten. </td>
    </tr>
    <tr class="soll">
      <td>F3.2</td>
      <td>Manuelle Bedienung LED</td>
      <td>Die Beleuchtung hat 3 Stufen: Aus, Ein, Automatisch. Bei Automatisch aktiviert sich die LED bei betätigung des Pedals. </td>
    </tr>
    <tr class="kann">
      <td>F3.3</td>
      <td>Helligkeit LED</td>
      <td>Die Helligkeit ist einstellbar von Helligkeitsstufe 1-5 wobei 1 dimmste und 5 hellste.</td>
    </tr>
    <tr class="muss">
      <td>F4.1</td>
      <td>Fadenspannung</td>
      <td>Die Fadenspannung muss einstellbar sein (manuell oder elektronisch). </td>
    </tr>
    <tr class="kann">
      <td>F4.3</td>
      <td>Anzeige Fadenspannung</td>
      <td>Die aktuelle Fadenspannung soll im Display angezeigt werden. </td>
    </tr>
    <tr class="muss">
      <td>F5.1</td>
      <td>Stichlänge</td>
      <td>Die Stichlänge muss im Bereich 1,5–5 mm einstellbar sein.</td>
    </tr>
    <tr class="muss">
      <td>F5.2</td>
      <td>Stichbreite</td>
      <td>Die Stichbreite muss im Bereich 2,5–7 mm einstellbar sein.</td>
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
      <td>NF7.1</td>
      <td>Programmiersprache</td>
      <td>Das Produkt soll in C++ entwicklet werden.</td>
    </tr>
    <tr class="soll">
      <td>NF7.2</td>
      <td>Budget</td>
      <td>Das Budget beträgt 1 Döner und n Redbull.</td>
    </tr>
    <tr class="soll">
      <td>NF1.1</td>
      <td>Menüführung</td>
      <td>Menüführung max. 3 Bedienebenen.</td>
    </tr>
    <tr class="soll">
      <td>NF4.1</td>
      <td>Einstellbereich Spannung</td>
      <td>Einstellbereich der Spannung soll die Stufen 1–9 haben, wobei 1 gerinste und 9 höchste Spannung.</td>
    </tr>
    <tr class="soll">
      <td>NF6.1</td>
      <td>Angenehme Anzeige</td>
      <td>Das Display muss unter Alltäglichen umständen klar lesbar sein und alle Funktionen darstellen.</td>
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
  </tbody>
</table>
