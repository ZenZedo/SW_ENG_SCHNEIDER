package naehmaschine.controller;

import naehmaschine.model.Naehmaschine;
import naehmaschine.model.LED;
import naehmaschine.view.NaehmaschineView;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Controller im MVC-Pattern.
 * Vermittelt zwischen Model und View.
 * Verarbeitet Benutzeraktionen und aktualisiert das Model.
 */
public class NaehmaschineController {

    private final Naehmaschine model;
    private final NaehmaschineView view;

    /**
     * Konstruktor - Verbindet Model und View.
     */
    public NaehmaschineController(Naehmaschine model, NaehmaschineView view) {
        this.model = model;
        this.view = view;

        // Model-Observer hinzufügen um View zu aktualisieren
        setupModelListeners();

        // View-Listener hinzufügen um auf Benutzeraktionen zu reagieren
        setupViewListeners();

        // Initiale Anzeige aktualisieren
        updateAllDisplays();
    }

    /**
     * Registriert Listener für Model-Änderungen.
     */
    private void setupModelListeners() {
        model.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                switch (evt.getPropertyName()) {
                    case Naehmaschine.PROP_STICHMUSTER:
                        view.updateStichmusterAnzeige(model.getAktuellesStichmuster());
                        view.updateStichlaengeAnzeige(
                                model.getAktuellesStichmuster().getStichlaenge());
                        view.updateStichbreiteAnzeige(
                                model.getAktuellesStichmuster().getStichbreite());
                        break;
                    case Naehmaschine.PROP_STICHLAENGE:
                        view.updateStichlaengeAnzeige((Double) evt.getNewValue());
                        break;
                    case Naehmaschine.PROP_STICHBREITE:
                        view.updateStichbreiteAnzeige((Double) evt.getNewValue());
                        break;
                    case Naehmaschine.PROP_FADENSPANNUNG:
                        view.updateFadenspannungAnzeige((Double) evt.getNewValue());
                        break;
                    case Naehmaschine.PROP_GESCHWINDIGKEIT:
                        view.updateGeschwindigkeitAnzeige((Double) evt.getNewValue());
                        break;
                    case LED.PROP_HELLIGKEIT:
                        view.updateLEDHelligkeit((Integer) evt.getNewValue());
                        break;
                    case Naehmaschine.PROP_SEWING_ACTIVE:
                        view.updateSewingAnimation((Boolean) evt.getNewValue());
                        break;
                    case LED.PROP_MODUS:
                        view.updateLEDModus((LED.LEDModus) evt.getNewValue());

                        // ← NEU: Wenn Modus auf EIN gewechselt wird
                        if (evt.getNewValue() == LED.LEDModus.EIN) {
                            view.updateLEDAktiv(true);
                        }
                        // Wenn auf AUS gewechselt wird
                        else if (evt.getNewValue() == LED.LEDModus.AUS) {
                            view.updateLEDAktiv(false);
                        }
                        // Bei AUTOMATISCH vom Pedal-Status abhängig
                        else if (evt.getNewValue() == LED.LEDModus.AUTOMATISCH) {
                            view.updateLEDAktiv(model.getGeschwindigkeit() > 0);
                        }
                        break;

                }
            }
        });
    }

    /**
     * Registriert Listener für View-Aktionen.
     */
    private void setupViewListeners() {
        // Drehrad-Listener für verschiedene Modi
        view.setDrehradListener(new NaehmaschineView.DrehradListener() {
            @Override
            public void onStichmusterChanged(int nummer) {
                model.setStichmuster(nummer);
            }

            @Override
            public void onStichlaengeChanged(double laenge) {
                model.setStichlaenge(laenge);
            }

            @Override
            public void onStichbreiteChanged(double breite) {
                model.setStichbreite(breite);
            }

            @Override
            public void onFadenspannungChanged(double spannung) {
                model.setFadenspannung(spannung);
            }

            @Override
            public void onLEDHelligkeitChanged(int helligkeit) {
                model.getLED().setHelligkeit(helligkeit);
            }

            @Override
            public void onLEDModusChanged(LED.LEDModus modus) {
                model.getLED().setModus(modus);
            }
        });

        // Pedal-Listener
        view.setPedalListener(new NaehmaschineView.PedalListener() {
                                  @Override
                                  public void onPedalPressed(double position) {
                                      model.setPedalPosition(position);

                                      // ← NEU: Bei Automatik-Modus LED einschalten
                                      if (model.getLED().getModus() == LED.LEDModus.AUTOMATISCH) {
                                          view.updateLEDAktiv(position > 0);
                                      }
                                  }

                                  @Override
                                  public void onPedalReleased() {
                                      model.setPedalPosition(0.0);

                                      // ← NEU: Bei Automatik-Modus LED ausschalten
                                      if (model.getLED().getModus() == LED.LEDModus.AUTOMATISCH) {
                                          view.updateLEDAktiv(false);
                                      }
                                  }
        });
    }

    /**
     * Aktualisiert alle Anzeigen mit aktuellen Model-Werten.
     */
    private void updateAllDisplays() {
        view.updateStichmusterAnzeige(model.getAktuellesStichmuster());
        view.updateStichlaengeAnzeige(
                model.getAktuellesStichmuster().getStichlaenge());
        view.updateStichbreiteAnzeige(
                model.getAktuellesStichmuster().getStichbreite());
        view.updateFadenspannungAnzeige(model.getFadenspannung());
        view.updateGeschwindigkeitAnzeige(model.getGeschwindigkeit());
        view.updateLEDModus(model.getLED().getModus());
        view.updateLEDHelligkeit(model.getLED().getHelligkeit());
    }
}
