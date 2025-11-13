package naehmaschine;

import javax.swing.SwingUtilities;
import naehmaschine.model.Naehmaschine;
import naehmaschine.view.NaehmaschineView;
import naehmaschine.controller.NaehmaschineController;

/**
 * Hauptklasse für den Nähmaschinen-Simulator.
 * Sprint 1: Stichmuster, Stichlänge, Stichbreite
 * Sprint 2 (TODO): LED, Pedal, Fadenspannung
 *
 * @author Ihr Name
 * @version Sprint 1
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Model erstellen
            Naehmaschine model = new Naehmaschine();

            // View erstellen
            NaehmaschineView view = new NaehmaschineView();

            // Controller erstellen und Model mit View verbinden
            NaehmaschineController controller =
                    new NaehmaschineController(model, view);

            // View sichtbar machen
            view.setVisible(true);
        });
    }
}
