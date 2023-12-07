package ba.unsa.etf.rpr23;

public class NeodgovarajuciProcesorException extends Exception {
    public NeodgovarajuciProcesorException() {
        super("Nema laptopa s traženim procesorom.");
    }

    public NeodgovarajuciProcesorException(String poruka) {
        super(poruka);
    }
}
