public class MobilniBroj extends TelefonskiBroj {
    private int mobilnaMreza;
    private String broj;

    public MobilniBroj(int mobilnaMreza, String broj) {
        this.mobilnaMreza = mobilnaMreza;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        String pozivniBroj = String.format("%03d", mobilnaMreza); // Formatiraj pozivni broj s tri cifre
        return pozivniBroj + "/" + broj;
    }

    @Override
    public int hashCode() {
        return (String.valueOf(mobilnaMreza) + broj).hashCode();
    }
}
