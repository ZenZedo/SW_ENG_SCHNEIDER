package naehmaschine;

import javax.swing.SwingUtilities;
import naehmaschine.model.Naehmaschine;
import naehmaschine.view.NaehmaschineView;
import naehmaschine.controller.NaehmaschineController;

/**
 * Hauptklasse für den Nähmaschinen-Simulator.
 * Implementiert das MVC-Pattern.
 *
 * @author Ihr Name
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        // GUI im Event Dispatch Thread starten
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
