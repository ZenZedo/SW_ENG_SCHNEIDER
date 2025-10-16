<!DOCTYPE html>
<html lang="de">
<head>
    <meta charset="UTF-8">
    <title>Lastenheft: Nähmaschine</title>
    <style>
        body { font-family: Arial, sans-serif; }
        h1, h2 { color: #003366; }
        table { border-collapse: collapse; width: 100%; margin-bottom: 20px; }
        th, td { border: 1px solid #ccc; padding: 8px; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h1>Lastenheft: Nähmaschine</h1>

    <h2>1. Funktionale Anforderungen</h2>
    <table>
        <thead>
            <tr>
                <th>Nr.</th>
                <th>Titel</th>
                <th>Beschreibung</th>
            </tr>
        </thead>
        <tbody>
            <tr><td>F1.1</td><td>Stichmuster</td><td>Die Maschine muss mindestens 10 Stichmuster bereitstellen.</td></tr>
            <tr><td>F1.2</td><td>Auswahl SM</td><td>Der Benutzer muss ein Stichmuster über Tasten, Drehregler oder Touchdisplay auswählen können.</td></tr>
            <tr><td>F1.3</td><td>Einstellung</td><td>Nach der Auswahl müssen die Parameter (Stichlänge, -breite, Nadelposition) automatisch geladen werden.</td></tr>
            <tr><td>F1.4</td><td>Anzeige SM</td><td>Das aktuell gewählte Stichmuster soll im Display angezeigt werden.</td></tr>
            <tr><td>F1.5</td><td>Selbstwahl SM</td><td>Die Maschine kann eigene Stichmustserkombinationen speichern.</td></tr>
            <tr><td>F2.1</td><td>Stufenlose Geschwindigkeit</td><td>Die Nähgeschwindigkeit muss stufenlos über das Fußpedal regelbar sein.</td></tr>
            <tr><td>F2.2</td><td>Stopplassen</td><td>Die Maschine muss bei Loslassen des Pedals stoppen.</td></tr>
            <tr><td>F2.3</td><td>Festlegung vmax</td><td>Eine maximale Geschwindigkeit soll festgelegt werden können.</td></tr>
            <tr><td>F2.4</td><td>Anzeige Geschwindigkeit</td><td>Die aktuelle Geschwindigkeit kann im Display angezeigt werden.</td></tr>
            <tr><td>F3.1</td><td>LED Benutzung</td><td>Die Maschine muss dem Nähbereich mit einer LED ausleuchten.</td></tr>
            <tr><td>F3.2</td><td>Manuelle Bedienung LED</td><td>Die Beleuchtung soll manuell ein- und ausschaltbar sein.</td></tr>
            <tr><td>F3.3</td><td>Helligkeit LED</td><td>Die Beleuchtung kann dimmbar sein.</td></tr>
            <tr><td>F4.1</td><td>Fadenspannung</td><td>Die Fadenspannung muss einstellbar sein (manuell oder elektronisch).</td></tr>
            <tr><td>F4.2</td><td>Fadenspannung Halten</td><td>Die Maschine muss die eingestellte Spannung während des Nähvorgangs konstant halten.</td></tr>
            <tr><td>F4.3</td><td>Anzeige Fadenspannung</td><td>Die aktuelle Fadenspannung soll im Display angezeigt werden.</td></tr>
            <tr><td>F5.1</td><td>Stichlänge</td><td>Die Stichlänge muss im Bereich 0–5 mm einstellbar sein.</td></tr>
            <tr><td>F5.2</td><td>Stichbreite</td><td>Die Stichbreite muss im Bereich 0–7 mm einstellbar sein.</td></tr>
            <tr><td>F5.3</td><td>Länge/Breite Anzeige</td><td>Die aktuellen Werte sollen im Display angezeigt werden.</td></tr>
        </tbody>
    </table>

    <h2>2. Nicht-funktionale Anforderungen</h2>
    <table>
        <thead>
            <tr>
                <th>Nr.</th>
                <th>Titel</th>
                <th>Beschreibung</th>
            </tr>
        </thead>
        <tbody>
            <tr><td>NF1.1</td><td>Menüführung</td><td>Menüführung max. 3 Bedienelemente.</td></tr>
            <tr><td>NF1.2</td><td>Programmiersprache</td><td>Das Produkt soll in C++ entwickelt werden.</td></tr>
            <tr><td>NF1.3</td><td>Budget</td><td>Das Budget beträgt 1 Döner und 1 Redbull.</td></tr>
            <tr><td>NF2.1</td><td>Geschw. Bereich</td><td>Geschwindigkeitsbereich: 200–900 Stiche/min.</td></tr>
            <tr><td>NF2.2</td><td>Einstellbereich</td><td>Einstellbereich 1–9.</td></tr>
            <tr><td>NF6.1</td><td>Angenehme Anzeige</td><td>Die Anzeige ist nicht zu hell oder visuell aufdringlich.</td></tr>
            <tr><td>NF6.2</td><td>Barrierefreie Anzeige (Farbenblindheit)</td><td>Die Anzeige ist auch für farbenblinde Nutzer eindeutig erkennbar.</td></tr>
            <tr><td>NF6.3</td><td>Barrierefreie Anzeige (Sehschwäche)</td><td>Die Anzeige ist auch für Nutzer mit eingeschränktem Sehvermögen gut lesbar.</td></tr>
            <tr><td>NF6.4</td><td>Anzeige Verzögerungen</td><td>Die Anzeige erfolgt innerhalb von &lt;1 Sekunde nach Benutzerinteraktion.</td></tr>
            <tr><td>NF12.1</td><td>Wertetoleranz</td><td>Die Genauigkeiten müssen mit einer Toleranz von &lt;5% gegenüber realen Werten eingehalten werden.</td></tr>
            <tr><td>NF13.1</td><td>Ressourcenschonende Einstellungen</td><td>Die Einstellungen dürfen nur minimal Rechen- und Speicherressourcen beanspruchen.</td></tr>
            <tr><td>NF6.5</td><td>Wahrnehmbarkeit der Warnung</td><td>Die Warnsignale müssen im typischen Alltagsumständen gut wahrnehmbar sein (z.B. im Bad oder bei Geräuschkulisse).</td></tr>
            <tr><td>NF6.6</td><td>Energieeffizienz</td><td>Die Nähmaschine muss Energieeffizient sein.</td></tr>
        </tbody>
    </table>
</body>
</html>
