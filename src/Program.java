import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Imenik imenik = new Imenik();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Izaberite opciju:");
            System.out.println("1. Dodaj osobu");
            System.out.println("2. Daj broj po imenu");
            System.out.println("3. Daj ime po broju");
            System.out.println("4. Osobe na slovo");
            System.out.println("5. Osobe iz grada");
            System.out.println("6. Izađi");
            int opcija = scanner.nextInt();
            scanner.nextLine(); // Consuming the newline character

            switch (opcija) {
                case 1:
                    System.out.print("Unesite ime: ");
                    String ime = scanner.nextLine();
                    System.out.print("Unesite broj: ");
                    String broj = scanner.nextLine();
                    // Dodaj osobu u imenik
                    imenik.dodaj(ime, new MedunarodniBroj("+387", broj));
                    break;
                case 2:
                    System.out.print("Unesite ime: ");
                    ime = scanner.nextLine();
                    String daniBroj = imenik.dajBroj(ime);
                    System.out.println("Broj za " + ime + ": " + daniBroj);
                    break;
                case 3:
                    System.out.print("Unesite broj: ");
                    broj = scanner.nextLine();
                    String imeOsobe = imenik.dajIme(new MedunarodniBroj("+387", broj));
                    System.out.println("Ime za broj " + broj + ": " + imeOsobe);
                    break;
                case 4:
                    System.out.print("Unesite slovo: ");
                    char slovo = scanner.nextLine().charAt(0);
                    String osobeNaSlovo = imenik.naSlovo(slovo);
                    System.out.println("Osobe na slovo " + slovo + ":\n" + osobeNaSlovo);
                    break;
                case 5:
                    System.out.print("Unesite grad: ");
                    FiksniBroj.Grad grad = FiksniBroj.Grad.valueOf(scanner.nextLine().toUpperCase());
                    Set<String> imenaIzGrada = imenik.izGrada(grad);
                    System.out.println("Osobe iz grada " + grad + ":\n" + imenaIzGrada);
                    break;
                case 6:
                    System.out.println("Izlaz iz programa.");
                    return;
                default:
                    System.out.println("Nepoznata opcija.");
                    break;
            }
        }
    }
}
