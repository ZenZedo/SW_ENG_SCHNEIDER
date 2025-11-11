package naehmaschine.model;

/**
 * Repräsentiert ein Stichmuster mit seinen Parametern.
 * Jedes Stichmuster hat eine Nummer, einen Namen und drei Parameter.
 */
public class Stichmuster {

    private final int nummer;
    private final String name;
    private double stichlaenge;      // 1.5 - 5.0 mm
    private double stichbreite;      // 2.5 - 7.0 mm
    private Nadelposition position;

    public enum Nadelposition {
        LINKS, MITTE, RECHTS
    }

    /**
     * Konstruktor für ein Stichmuster mit Standardparametern.
     */
    public Stichmuster(int nummer, String name, double stichlaenge,
                       double stichbreite, Nadelposition position) {
        this.nummer = nummer;
        this.name = name;
        this.stichlaenge = stichlaenge;
        this.stichbreite = stichbreite;
        this.position = position;
    }

    // Getter
    public int getNummer() { return nummer; }
    public String getName() { return name; }
    public double getStichlaenge() { return stichlaenge; }
    public double getStichbreite() { return stichbreite; }
    public Nadelposition getPosition() { return position; }

    // Setter
    public void setStichlaenge(double stichlaenge) {
        if (stichlaenge >= 1.5 && stichlaenge <= 5.0) {
            this.stichlaenge = stichlaenge;
        }
    }

    public void setStichbreite(double stichbreite) {
        if (stichbreite >= 2.5 && stichbreite <= 7.0) {
            this.stichbreite = stichbreite;
        }
    }

    public void setPosition(Nadelposition position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("%d: %s", nummer, name);
    }
}
