import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StatisticCalculator {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Unesite broj (ili 'stop' za kraj unosa): ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            try {
                double number = Double.parseDouble(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Unesite validan broj ili 'stop' za kraj unosa.");
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("Niste unijeli nijedan broj.");
        } else {
            double min = calculateMin(numbers);
            double max = calculateMax(numbers);
            double mean = calculateMean(numbers);
            double stdDeviation = calculateStandardDeviation(numbers);

            System.out.println("Minimum: " + min);
            System.out.println("Maksimum: " + max);
            System.out.println("Srednja vrijednost (Mean): " + mean);
            System.out.println("Standardna devijacija: " + stdDeviation);
        }
    }

    private static double calculateMin(List<Double> numbers) {
        double min = Double.MAX_VALUE;
        for (double number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    private static double calculateMax(List<Double> numbers) {
        double max = Double.MIN_VALUE;
        for (double number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static double calculateMean(List<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    private static double calculateStandardDeviation(List<Double> numbers) {
        double mean = calculateMean(numbers);
        double sumOfSquaredDifferences = 0;
        for (double number : numbers) {
            double difference = number - mean;
            sumOfSquaredDifferences += difference * difference;
        }
        double variance = sumOfSquaredDifferences / numbers.size();
        return Math.sqrt(variance);
    }
}
