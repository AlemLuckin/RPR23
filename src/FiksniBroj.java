public class FiksniBroj extends TelefonskiBroj {
    public enum Grad {
        SARAJEVO, TUZLA, ZENICA, /* Dodajte ostale gradove prema potrebi */
    }

    private Grad grad;
    private String broj;

    public Grad getGrad() {
        return grad;
    }

    public String getBroj() {
        return broj;
    }

    public FiksniBroj(Grad grad, String broj) {
        this.grad = grad;
        this.broj = broj;
    }

    @Override
    public String ispisi() {
        String pozivniBroj = "";
        switch (grad) {
            case SARAJEVO:
                pozivniBroj = "033";
                break;
            case TUZLA:
                pozivniBroj = "035";
                break;
            case ZENICA:
                pozivniBroj = "032";
                break;
            // Dodajte ostale pozivne brojeve prema potrebi
        }
        return pozivniBroj + "/" + broj;
    }

    @Override
    public int hashCode() {
        return (grad.toString() + broj).hashCode();
    }
}
