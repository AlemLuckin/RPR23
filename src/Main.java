import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Kreirajte Scanner objekt za unos korisnika
        Scanner scanner = new Scanner(System.in);

        // Zatražite korisnika da unese broj "n"
        System.out.print("Unesite broj n: ");
        int n = scanner.nextInt();

        // Iterirajte kroz brojeve od 1 do n
        for (int i = 1; i <= n; i++) {
            if (i % sumOfDigits(i) == 0) {
                System.out.println(i);
            }
        }

        // Zatvorite Scanner
        scanner.close();
    }
    // Metoda za računanje sume cifara broja
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}