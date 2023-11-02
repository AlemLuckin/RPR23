
public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Molimo unesite jedan broj kao argument.");
            return;
        }

        try {
            double number = Double.parseDouble(args[0]);
            double sinusValue = Math.sin(number);
            long factorialValue = calculateFactorial((int) number);

            System.out.println("Sinus(" + number + ") = " + sinusValue);
            System.out.println(number + "! = " + factorialValue);
        } catch (NumberFormatException e) {
            System.out.println("Nevažeći unos. Molimo unesite broj.");
        }
    }

    private static long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Faktorijel nije definiran za negativne brojeve.");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}