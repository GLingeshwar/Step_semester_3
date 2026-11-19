import java.util.Locale;
import java.util.Scanner;

public class Main {
    enum TransportType {
        BUS {
            double fare(double distance, Scanner sc) {
                return Math.min(10, 2 + 0.10 * distance);
            }
        },
        TRAIN {
            double fare(double distance, Scanner sc) {
                return 3 + 0.15 * distance;
            }
        },
        METRO {
            double fare(double distance, Scanner sc) {
                double peakHourFactor = sc.nextDouble();
                return (1.50 + 0.20 * distance) * peakHourFactor;
            }
        };

        abstract double fare(double distance, Scanner sc);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            TransportType type = TransportType.valueOf(sc.next());
            double distance = sc.nextDouble();
            double fare = type.fare(distance, sc);

            System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
