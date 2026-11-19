import java.util.Locale;
import java.util.Scanner;

public class Main {
    enum Room {
        SINGLE {
            double bill(int units, int occupants) {
                return 8.0 * units;
            }
        },
        SHARED {
            double bill(int units, int occupants) {
                return 6.0 * units / occupants;
            }
        },
        AC {
            double bill(int units, int occupants) {
                return 10.0 * units + 200;
            }
        };

        abstract double bill(int units, int occupants);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] fields = sc.nextLine().trim().split("\\s+");
            Room room = Room.valueOf(fields[0]);
            int units = Integer.parseInt(fields[1]);
            int occupants = fields.length == 3 ? Integer.parseInt(fields[2]) : 1;

            double amount = room.bill(units, occupants);
            System.out.printf(Locale.US, "%s: %.2f%n", room, amount);
            total += amount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
