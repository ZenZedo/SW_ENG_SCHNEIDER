## Dokumentation der Testfälle (Sprint 1)
## **Modul-Testfälle**
### M1

Testziel: setStichmuster(int) setzt das richtige Muster

Vorgehen: Im Test wird setStichmuster(5) aufgerufen, danach getAktuellesStichmuster()

Ergebnis: Rückgabewert ist Objekt mit Name "Blindstich", Nummer 5
Status: Erfolgreich

### M2

Testziel: setStichlaenge akzeptiert nur Werte zwischen 1.5 und 5.0

Vorgehen: Bei einem Muster wird setStichlaenge(3.0) ausgeführt, danach getter geprüft

Ergebnis: Wert ist gesetzt
Status: Erfolgreich

### M3

Testziel: Zu große Stichbreite wird ignoriert

Vorgehen: Bei einem Muster wird setStichbreite(10.0) ausgeführt, davor war Wert 4.5; getter geprüft

Ergebnis: Wert bleibt 4.5
Status: Erfolgreich

## **Integrations testfälle++

### I1

Testziel: DrehradPanel löst Model-Update und Display-Refresh aus

Vorgehen: Drehrad wird im UI in Modus „Stichmuster“ auf 2 („Zickzack“) gedreht, Soll: Model.setStichmuster() wird aufgerufen

Ergebnis: DisplayPanel zeigt „Zickzack“, Model-Status korrekt
Status: Erfolgreich

### I2

Testziel: DrehradLänge setzt Model und Display richtig

Vorgehen: Im UI wird die Länge via Drehrad auf 4.0 gestellt

Ergebnis: Model.getAktuellesStichmuster().getStichlaenge() == 4.0, Display aktualisiert
Status: Erfolgreich

### I3

Testziel: Controller-zu-Display-Kommunikation bei Musterwechsel

Vorgehen: Controller ruft onStichmusterChanged(13), Model-Event feuert, View wird aktualisiert

Ergebnis: Display zeigt korrekt „Blumenstich“
Status: Erfolgreich
