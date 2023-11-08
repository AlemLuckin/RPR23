import java.util.*;

public class Imenik {
    private HashMap<String, TelefonskiBroj> imenik = new HashMap<>();

    public void dodaj(String ime, TelefonskiBroj broj) {
        imenik.put(ime, broj);
    }

    public String dajBroj(String ime) {
        TelefonskiBroj broj = imenik.get(ime);
        if (broj != null) {
            return broj.ispisi();
        }
        return "Nema broja za osobu s imenom: " + ime;
    }

    public String dajIme(TelefonskiBroj broj) {
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            if (entry.getValue().equals(broj)) {
                return entry.getKey();
            }
        }
        return "Nema osobe s tim brojem.";
    }

    public String naSlovo(char s) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            String ime = entry.getKey();
            if (ime.charAt(0) == s) {
                result.append(ime).append(" - ").append(entry.getValue().ispisi()).append("\n");
            }
        }
        return result.toString();
    }

    public Set<String> izGrada(FiksniBroj.Grad g) {
        Set<String> imena = new TreeSet<>();
        for (Map.Entry<String, TelefonskiBroj> entry : imenik.entrySet()) {
            TelefonskiBroj broj = entry.getValue();
            if (broj instanceof FiksniBroj) {
                FiksniBroj fiksniBroj = (FiksniBroj) broj;
                if (fiksniBroj.getGrad() == g) {
                    imena.add(entry.getKey());
                }
            }
        }
        return imena;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g) {
        Set<TelefonskiBroj> brojevi = new TreeSet<>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj broj1, TelefonskiBroj broj2) {
                return broj1.ispisi().compareTo(broj2.ispisi());
            }
        });

        for (TelefonskiBroj broj : imenik.values()) {
            if (broj instanceof FiksniBroj) {
                FiksniBroj fiksniBroj = (FiksniBroj) broj;
                if (fiksniBroj.getGrad() == g) {
                    brojevi.add(fiksniBroj);
                }
            }
        }
        return brojevi;
    }
}
