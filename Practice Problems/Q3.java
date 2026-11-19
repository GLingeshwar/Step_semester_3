import java.util.Locale;
import java.util.Scanner;

public class Main {
    enum DeliveryType {
        STANDARD {
            double fee(double weight, double distance, Scanner sc) {
                return 5 + 0.50 * weight + 0.10 * distance;
            }
        },
        EXPRESS {
            double fee(double weight, double distance, Scanner sc) {
                return 15 + weight + 0.20 * distance;
            }
        },
        INTERNATIONAL {
            double fee(double weight, double distance, Scanner sc) {
                double customsFee = sc.nextDouble();
                return 25 + 2 * weight + 0.50 * distance + customsFee;
            }
        };

        abstract double fee(double weight, double distance, Scanner sc);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            DeliveryType type = DeliveryType.valueOf(sc.next());
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            double fee = type.fee(weight, distance, sc);

            System.out.printf(Locale.US, "%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
